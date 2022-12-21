package Crwaling.Cache;


import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.InputStream;
import java.util.*;
import java.text.SimpleDateFormat;

public class CrwalingCacheDAO {

    public CrwalingCacheDAO() {
        System.out.println("CrwalingCache Start-----------");
    }


    public void main() {

        Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
        try {
            String resource = "config/CrwalingCacheConfig.xml";
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
            System.out.println("-------DB연결 성공");
            SqlSession sql = ssf.openSession(true);
            String urlSelect = null;
            String Class_News = null;
            for (int Selector = 1; Selector < 3; Selector++) {
                if (Selector == 1) {
                    urlSelect = "https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid2=263&sid1=101&date="; //경제
                    Class_News = "경제";
                }
                if (Selector == 2) {
                    urlSelect = "https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid2=322&sid1=104&date="; //세계
                    Class_News = "세계";
                }
//                for (int A = 0; A < 22; A++) {
                for (int A = 0; A < 1; A++) {
                    Date now = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    Calendar cal = Calendar.getInstance();     //날짜 계산을 위해 Calendar 추상클래스 선언 getInstance()메소드 사용
                    cal.setTime(now);
                    cal.add(Calendar.DATE, -A);    //6개월 더하기
                    String datecal = sdf.format(cal.getTime());

                    outerLoop:
                    for (int j = 1; j < 200; j++) {


                        String url = urlSelect + datecal + "&page=" + j;
                        Document doc = Jsoup.connect(url).get();
                        Elements elements = doc.getElementsByAttributeValue("class", "list_body newsflash_body");

                        Element element = elements.get(0);
                        Elements photoElements = element.getElementsByAttributeValue("class", "photo");
                        Elements Paging = doc.getElementsByAttributeValue("class", "next nclicks(fls.page)");

                        for (Element photoElement : photoElements) {
                            try {
                                Elements aElements = photoElement.select("a");
                                Element aElement = aElements.get(0);

                                String articleUrl = aElement.attr("href");        // 기사링크
                                Element imgElement = aElement.select("img").get(0);
                                String imgUrl = imgElement.attr("src");            // 사진링크


                                System.out.println(imgUrl.substring(0,imgUrl.length()-6));
                                String title = imgElement.attr("alt");            // 기사제목
                                Document subDoc = Jsoup.connect(articleUrl).get();

                                Elements bElement = subDoc.getElementsByAttributeValue("class", "media_end_head_top");
                                Element comElement = bElement.select("img").get(0);
                                String comTitle = comElement.attr("alt");            // 신문사
                                Element contentElement = subDoc.getElementById("dic_area");
                                String content = contentElement != null ? contentElement.text() : null;            // 기사내용
                                Elements dateElement = subDoc.getElementsByAttributeValue("class", "media_end_head_info_datestamp_time _ARTICLE_DATE_TIME");
                                String date = dateElement.attr("data-date-time");
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                Date newstime = formatter.parse(date);
                                System.out.println(date);

                                try {
                                    KomoranResult analyzeResultList = komoran.analyze(content);
                                    List<String> nounList = analyzeResultList.getNouns();
                                    String noun = nounList.toString();
                                    Set<String> set = new HashSet<String>(nounList);
                                    Map<String, Integer> map = new HashMap<>();

                                    for (String str : set) {
                                        map.put(str, Collections.frequency(nounList, str));
                                        // 갯수 새기
                                    }
                                    List<String> listKeySet = new ArrayList<>(map.keySet());
                                    Collections.sort(listKeySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
                                    System.out.println(Class_News);

                                    sql.insert("Now.insert",
                                            new CrwalingCacheDTO(comTitle, articleUrl, date, title, listKeySet.get(0),
                                                    map.get(listKeySet.get(0)), listKeySet.get(1), map.get(listKeySet.get(1)),
                                                    listKeySet.get(2), map.get(listKeySet.get(2))
                                                    , listKeySet.get(3), map.get(listKeySet.get(3)),
                                                    listKeySet.get(4), map.get(listKeySet.get(4)),
                                                    listKeySet.toString(), listKeySet.toArray().length, Class_News, imgUrl.substring(0,imgUrl.length()-6)));// end of sql insert

                                } catch (Exception e) {

                                    if (e.getClass().getName() == "org.apache.ibatis.exceptions.PersistenceException") {
                                        break outerLoop;
                                    }
                                    System.out.println(e.getClass().getName() + "형태소 예외가" + e.getMessage() + " 때문에 발생");
                                }//end of 형태소 try-catch
                            } catch (Exception e) {

                                if (e.getClass().getName() == "org.apache.ibatis.exceptions.PersistenceException") {
                                    break outerLoop;
                                }
                                System.out.println(e.getClass().getName() + "형태소 예외가" + e.getMessage() + " 때문에 발생");
                            }//스포츠,경제 판별 try-catch

                        }
                        System.out.println(j + "page 크롤링 완료");
                    }
                }
                System.out.println(Class_News + "편 완료");
            }
        } catch (Exception e) {
            System.out.println("크롤링 실패" + e.getClass().getName() + " 예외가" + e.getMessage() + " 때문에 발생");
        } // end try-catch
    }//end of main
} //end of CrwalingDAO class
