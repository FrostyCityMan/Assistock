package Crwaling.Now;

import Crwaling.Cache.CrwalingCacheDTO;
import dh.assistock.wordcloud.WordCloudDTO;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class CrawlingNowDAO {

    public void main() {
        System.out.println("CrwalingNow Start ---------------");
        Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);

        try {
            String resource = "config/CrwalingNowConfig.xml";
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
            System.out.println("-------DB연결 성공");
            SqlSession sql = ssf.openSession(true);
            List<CrwalingCacheDTO> list = sql.selectList("Word.Word");
            List<CrwalingNowDTO> list_Word = sql.selectList("Word.WordAnalysis");
            List<CrwalingCacheDTO> list_Stock = sql.selectList("Word.Name(Stock)");
            List<CrwalingNowDTO> list_Material = sql.selectList("Word.Material");

            Map<String, Integer> map_word = new HashMap<>();
            Map<String, String> map_Stock = new HashMap<>();
            Map<String, String> map_Material = new HashMap<>();

            for (int a = 0; a < list_Word.size(); a++) {
                CrwalingNowDTO dto = list_Word.get(a);
                map_word.put(dto.getWord(), dto.getScore());
            }
                System.out.println("주식 목록 불러오는중 --------------");
            for (int b = 0; b < list_Stock.size(); b++) {
                CrwalingCacheDTO dto = list_Stock.get(b);
                map_Stock.put(dto.getName_Stock(), dto.getClass_Item());
            }
                System.out.println("국가 목록 불러오는중---------------");
            for (int c = 0; c < list_Material.size(); c++) {
                CrwalingNowDTO dto = list_Material.get(c);
                map_Material.put(dto.getName_Country(), dto.getClass_Item());
            }
            outerloop:
            for (int i = 0; i < list.size(); i++) {
                CrwalingCacheDTO dto = list.get(i);
                KomoranResult analyzeResultList = komoran.analyze(dto.getEntire_Now());
                List<String> nounList = analyzeResultList.getNouns(); //전체분석

                // 뉴스 점수 매기기
                int score = 0;
                try {
                    for (int c = 0; c < nounList.size(); c++) {
                        if (map_word.get(nounList.get(c)) == null) {
                            score = score + 0;
                        } else {
                            score += map_word.get(nounList.get(c));
                        }
                    }//end of scoring for
                } catch (Exception e) {
                    System.out.println("뉴스 점수 매기기 실패"+e);

                }// end of Scoring try-catch
                String stock = " ";
                String item = " ";
                String Country = " ";
                System.out.println(dto.getClass_News() + "==================================");
//               단어 걸러내기
                try {
                    for (int c = 0; c < nounList.size(); c++) {
                        if (Objects.equals(dto.getClass_News(), "경제")
                                && map_Stock.get(nounList.get(c)) != null
                                && !Objects.equals(nounList.get(c), "대상")) {
                            stock = nounList.get(c);
                            item = map_Stock.get(nounList.get(c));
                            System.out.println(stock + "========================경제====================");
                            break;
                        }
                        if (Objects.equals(dto.getClass_News(), "세계")
                                && map_Material.get(nounList.get(c)) != null) {
                            Country = nounList.get(c);
                            item = map_Material.get(nounList.get(c));
                            System.out.println(Country + "========================세계====================");
                            break;
                        }

                    }//end of stock search for

                    try {

                        // 뉴스점수 기록
                        CrwalingNowDTO Word = CrwalingNowDTO.builder()
                                .name_News(dto.getName_News())
                                .name_Stock(stock)
                                .class_Item(item)
                                .name_Country(Country)
                                .URL_Now(dto.getURL_Now())
                                .date_Now(dto.getDate_Now())
                                .head_Now(dto.getHead_Now())
                                .entire_Now(dto.getEntire_Now())
                                .score(score)
                                .img(dto.getImg())
                                .build();
                        System.out.println(Word);
                        sql.insert("Word.Word(Analysis)Insert", Word);
                    } catch (Exception e) {
                        System.out.println("INSERT 실패" + e.getClass().getName() + " 예외가" + e.getMessage());
                        if (e.getClass().getName() == "org.apache.ibatis.exceptions.PersistenceException") {
                            break outerloop;
                        }
                    }


                } catch (Exception e) {
                    System.out.println("경제 세계 구분에서 " + e.getClass().getName() + " 예외가" + e.getMessage() + " 때문에 발생");
                }//end of stock search try-catch


            }//end of for
//            int result = sql.delete("Word.delete");
            //-----------------단어 개수세기-------------

            //단어 개수 세기 변수 선언
            List<String> allWordList = new ArrayList<>();
            List<Date> alldateList = sql.selectList("Word.datelist");
            System.out.println("datelist 불러오기성공 -----------------");
            String class_News = "";
            String content = "";
            wordloop:
            for (int e = 0; e < alldateList.size(); e++) {
                //경제편 정리
                List<CrwalingNowDTO> Wordlist = sql.selectList("Word.Wordlist_eco", alldateList.get(e));
                System.out.println("wordlist_eco 불러오기성공 -----------------");

                for (int d = 0; d < Wordlist.size(); d++) {
                    CrwalingNowDTO dto = Wordlist.get(d);
                    allWordList.add(dto.getEntire_Now());
                    class_News = "경제";
                }
                content = allWordList.toString();

                KomoranResult analyzeResultList = komoran.analyze(content);
                List<String> nounList = analyzeResultList.getNouns();
                Set<String> set = new HashSet<String>(nounList);
                Map<String, Integer> map = new HashMap<>();

                for (String str : set) {
                    map.put(str, Collections.frequency(nounList, str));
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String strNowDate = simpleDateFormat.format(alldateList.get(e));
                List<String> listKeySet = new ArrayList<>(map.keySet());
                Collections.sort(listKeySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
                for (int d = 0; d < 80; d++) {
                    sql.insert("Word.Word(dayAnalysis)Insert",
                            new WordCloudDTO(strNowDate, listKeySet.get(d),
                                    map.get(listKeySet.get(d)), class_News));
                }

                //----------------------------end of 경제
                //세계편 정리
                Wordlist = sql.selectList("Word.Wordlist_world", alldateList.get(e));
                System.out.println("wordlist_world 불러오기 성공 --------------");
                for (int d = 0; d < Wordlist.size(); d++) {
                    CrwalingNowDTO dto = Wordlist.get(d);
                    allWordList.add(dto.getEntire_Now());
                    class_News = "세계";
                }
                content = allWordList.toString();
                analyzeResultList = komoran.analyze(content);
                nounList = analyzeResultList.getNouns();
                set = new HashSet<String>(nounList);
                Map<String, Integer> map2 = new HashMap<>();

                for (String str : set) {
                    map2.put(str, Collections.frequency(nounList, str));
                }
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                strNowDate = simpleDateFormat.format(alldateList.get(e));
                listKeySet = new ArrayList<>(map2.keySet());
                Collections.sort(listKeySet, (value1, value2) -> (map2.get(value2).compareTo(map2.get(value1))));
                for (int d = 0; d < 80; d++) {
                    sql.insert("Word.Word(dayAnalysis)Insert",
                            new WordCloudDTO(strNowDate, listKeySet.get(d),
                                    map2.get(listKeySet.get(d)), class_News));
                }
                //----------------------------end of 세계


                //단어 골라내기
                List<String> removeWord = new ArrayList<>();
                removeWord.add("말");
                removeWord.add("이날");
                removeWord.add("가운데");
                removeWord.add("사진");
                removeWord.add("제공");
                removeWord.add("현지");
                removeWord.add("이번");
                removeWord.add("후");
                removeWord.add("연합뉴스");
                removeWord.add("이후");
                removeWord.add("관련");
                removeWord.add("기자");
                removeWord.add("월드컵");
                removeWord.add("축구");
                removeWord.add("경기");
                removeWord.add("카타르");
                removeWord.add("감독");
                removeWord.add("선수");
                removeWord.add(".kr");
                removeWord.add(".co");
                for (int d = 0; d < removeWord.size(); d++) {
                    sql.delete("Word.Word(dayAnalysis)Delete", removeWord.get(d));
                }

            }//end of 단어개수세기----------------
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + " 예외가" + e.getMessage() + " 때문에 발생");
            if (e.getClass().getName() == "org.apache.ibatis.exceptions.PersistenceException") {
                String resource = "config/CrwalingNowConfig.xml";
                InputStream is = null;
                try {
                    is = Resources.getResourceAsStream(resource);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
                System.out.println("-------DB연결 성공");
                SqlSession sql = ssf.openSession(true);
                List<String> allWordList = new ArrayList<>();
                List<Date> alldateList = sql.selectList("Word.datelist");
                System.out.println("datelist 불러오기성공 -----------------");
                String class_News = "";
                String content = "";
                wordloop:
                for (int f = 0; f < 1; f++) {
                    //경제편 정리
                    List<CrwalingNowDTO> Wordlist = sql.selectList("Word.Wordlist_eco", alldateList.get(f));
                    System.out.println("wordlist_eco 불러오기성공 -----------------");

                    for (int d = 0; d < Wordlist.size(); d++) {
                        CrwalingNowDTO dto = Wordlist.get(d);
                        allWordList.add(dto.getEntire_Now());
                        class_News = "경제";
                    }
                    content = allWordList.toString();

                    KomoranResult analyzeResultList = komoran.analyze(content);
                    List<String> nounList = analyzeResultList.getNouns();
                    Set<String> set = new HashSet<String>(nounList);
                    Map<String, Integer> map = new HashMap<>();

                    for (String str : set) {
                        map.put(str, Collections.frequency(nounList, str));
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String strNowDate = simpleDateFormat.format(alldateList.get(f));
                    List<String> listKeySet = new ArrayList<>(map.keySet());
                    Collections.sort(listKeySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
                    for (int d = 0; d < 80; d++) {
                        sql.update("Word.Word(dayAnalysis)Update",
                                new WordCloudDTO(strNowDate, listKeySet.get(d),
                                        map.get(listKeySet.get(d)), class_News));

                    }

                    //----------------------------end of 경제
                    //세계편 정리
                    Wordlist = sql.selectList("Word.Wordlist_world", alldateList.get(f));
                    System.out.println("wordlist_world 불러오기 성공 --------------");
                    for (int d = 0; d < Wordlist.size(); d++) {
                        CrwalingNowDTO dto = Wordlist.get(d);
                        allWordList.add(dto.getEntire_Now());
                        class_News = "세계";
                    }
                    content = allWordList.toString();
                    analyzeResultList = komoran.analyze(content);
                    nounList = analyzeResultList.getNouns();
                    set = new HashSet<String>(nounList);
                    Map<String, Integer> map2 = new HashMap<>();

                    for (String str : set) {
                        map2.put(str, Collections.frequency(nounList, str));
                    }
                    simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    strNowDate = simpleDateFormat.format(alldateList.get(f));
                    listKeySet = new ArrayList<>(map2.keySet());
                    Collections.sort(listKeySet, (value1, value2) -> (map2.get(value2).compareTo(map2.get(value1))));
                    for (int d = 0; d < 80; d++) {
                        sql.update("Word.Word(dayAnalysis)Update",
                                new WordCloudDTO(strNowDate, listKeySet.get(d),
                                        map2.get(listKeySet.get(d)), class_News));

                    }
                    //----------------------------end of 세계


                    //단어 골라내기
                    List<String> removeWord = new ArrayList<>();
                    removeWord.add("말");
                    removeWord.add("이날");
                    removeWord.add("가운데");
                    removeWord.add("사진");
                    removeWord.add("제공");
                    removeWord.add("현지");
                    removeWord.add("이번");
                    removeWord.add("후");
                    removeWord.add("연합뉴스");
                    removeWord.add("이후");
                    removeWord.add("관련");
                    removeWord.add("기자");
                    removeWord.add("월드컵");
                    removeWord.add("축구");
                    removeWord.add("경기");
                    removeWord.add("카타르");
                    removeWord.add("감독");
                    removeWord.add("선수");
                    removeWord.add(".kr");
                    removeWord.add(".co");
                    for (int d = 0; d < removeWord.size(); d++) {
                        sql.delete("Word.Word(dayAnalysis)Delete", removeWord.get(d));
                    }
                    //end of 단어 개수 세기
                }
            }

        } //end of try-catch


    }//end of psvm

} //end of CrawlingNowDAO class
