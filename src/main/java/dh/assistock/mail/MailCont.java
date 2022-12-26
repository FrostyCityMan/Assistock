package dh.assistock.mail;

import Crwaling.Now.CrwalingNowDTO2;
import dh.assistock.dashboard.DashboardDTO;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utility.MyAuthenticator;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class MailCont {

    public static void main(String[] args) {


//        // Create a Calendar object to represent the current time
//        Calendar now = Calendar.getInstance();
//
//        // Set the Calendar object to the desired execution time: 9 a.m.
//        now.set(Calendar.HOUR_OF_DAY, 14);
//        now.set(Calendar.MINUTE, 43);
//        now.set(Calendar.SECOND, 0);
//        System.out.println("메일링 스타트");
//        // If the execution time has already passed today, schedule the task for tomorrow
//        if (now.before(Calendar.getInstance())) {
//            now.add(Calendar.DATE, 1);
//        }
//
//        // Create a Timer object
//        Timer timer = new Timer();
//
//        // Create a TimerTask to be executed at the desired execution time
//        TimerTask task = new TimerTask() {
//            public void run() {
        // This code will be executed every day at 9 a.m.
        try {
            String resource = "config/MailConfig.xml";
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
            System.out.println("-------DB연결 성공");
            SqlSession sql = ssf.openSession(true);


            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String parameterName = sdf.format(now);

            List<MailDTO> maillist = sql.selectList("Mailing.selectMail");
            System.out.println(maillist);
            System.out.println(parameterName);
            List<CrwalingNowDTO2> list = new ArrayList<>();

            for (int a = 0; maillist.size() > a; a++) {
                String ID = maillist.get(a).getID();
                List<DashboardDTO> dashboardDTO = sql.selectList("Mailing.userKeywords",ID);
                System.out.println(dashboardDTO);
                for (int i = 0; i < dashboardDTO.size(); i++) {
                    String keywords = dashboardDTO.get(i).getKeywords();
                    String Class = dashboardDTO.get(i).getClass1();
                    CrwalingNowDTO2 dto2 = null;
                    if (Class.equals("업종")) {
                        dto2 = new CrwalingNowDTO2("", keywords, "", parameterName);
                    } else if (Class.equals("종목")) {
                        dto2 = new CrwalingNowDTO2(keywords, "", "", parameterName);
                    } else if (Class.equals("국가")) {
                        dto2 = new CrwalingNowDTO2("", "", keywords, parameterName);
                    }
                    // Add the elements of the list returned by dashboardDAO.keywordNews to the list object
                    list.addAll(sql.selectList("Mailing.keywordNews",dto2));
                }//end of 키워드
                System.out.println(list);
                File file = new File("src/main/resources/static/mail/" + ID + "Newsletter.txt");
                try {
                    BufferedWriter fw = new BufferedWriter(new FileWriter(file, false));
                    String content = "<body style=\"box-sizing: border-box;margin: 0;font-family: 'Droid Serif', serif;font-size: 14px;font-weight: 400;line-height: 1.5;color: #2f2f2f;background-color: #f9f7f1;-webkit-text-size-adjust: 100%;-webkit-tap-highlight-color: transparent;\">\n" +
                            "\n" +
                            "<div class=\"head\" style=\"box-sizing: border-box;text-align: center;position: relative;\">\n" +
                            "    <div class=\"headerobjectswrapper\" style=\"box-sizing: border-box;\">\n" +
                            "\n" +
                            "        <header style=\"box-sizing: border-box;font-family: 'Playfair Display', serif;font-weight: 900;font-size: 80px;text-transform: uppercase;display: inline-block;line-height: 72px;margin-bottom: 20px;\">\n" +
                            "            The assistock\n" +
                            "        </header>\n" +
                            "    </div>\n" +
                            "    <div class=\"subhead\" style=\"box-sizing: border-box;text-transform: uppercase;letter-spacing: 1px;border-bottom: 2px solid #2f2f2f;border-top: 2px solid #2f2f2f;padding: 12px 0 12px 0;\">\n" +
                            "\n" +
                            "        <div class=\"issue\" style=\"box-sizing: border-box;flex: 1;padding: 8px;width: 25%;display: inline-grid !important;\"><a href=\"/\" style=\"box-sizing: border-box;color: inherit;text-decoration: none;\">www.assistock.com</a></div>\n" +
                            "        <div class=\"edition\" style=\"box-sizing: border-box;flex: 1;padding: 8px;width: 25%;display: inline-grid !important;\">\n" +
                            "            "+ID+"'s News\n" +
                            "        </div>\n" +
                            "        <div class=\"date\" style=\"box-sizing: border-box;flex: 1;padding: 8px;width: 25%;display: inline-grid !important;\">\n" +
                            "            "+parameterName+"" +
                            "        </div>\n" +
                            "    </div>\n" +
                            "</div>\n" +
                            "<div class=\"content\" style=\"box-sizing: border-box;font-size: 0;line-height: 0;word-spacing: -.31em;display: inline-block;margin: 30px 2% 0 2%;\">";
                    for (int b = 0; b < list.size(); b++) {
                        String url = list.get(b).getURL_Now();
                        Document subDoc = Jsoup.connect(url).get();

                        Elements bElement = subDoc.getElementsByAttributeValue("class", "media_end_head_top");

                        Element contentElement = subDoc.getElementById("dic_area");
                        String body = contentElement != null ? contentElement.html() : null;

                        content += " <div class=\"collumn\" style=\"box-sizing: border-box;font-size: 14px;line-height: 20px;width: 33.3%;display: inline-block;padding: 0 1% 0 1%;vertical-align: top;margin-bottom: 50px;transition: all .7s;\">\n" +
                                "            <div class=\"head\" style=\"box-sizing: border-box;text-align: center;position: relative;\">\n" +
                                "              <span class=\"headline hl5\" style=\"box-sizing: border-box;text-align: center;line-height: normal;font-family: 'Playfair Display', serif;display: block;margin: 0 auto;font-weight: 400;font-size: 42px;text-transform: uppercase;font-style: italic;padding: 10px 0 10px 0;overflow: hidden;white-space: normal;text-overflow: ellipsis;height: 18%;\">"+list.get(b).getHead_Now()+"</span>\n" +
                                "              <p style=\"box-sizing: border-box;margin-top: 0;margin-bottom: 20px;\"><span class=\"headline hl6\" style=\"box-sizing: border-box;text-align: center;line-height: normal;font-family: 'Playfair Display', serif;display: block;margin: 0 auto;font-weight: 400;font-size: 18px;padding: 10px 0 10px 0;\">"+list.get(b).getName_Country()+list.get(b).getName_Stock()+"\"<br>\n" +
                                "              </span></p>\n" +
                                "            </div>\n" +
                                "            <p style=\"font-size: 20px;font-weight: bold;box-sizing: border-box;margin-top: 0;margin-bottom: 20px;\">"+list.get(b).getClass_Item()+"</p>\n" +
                                "            <figure class=\"figure\" style=\"box-sizing: border-box;margin: 0 0 20px;display: inline-block;\">\n" +
                                "              <img style=\"box-sizing: border-box;vertical-align: middle;-webkit-filter: sepia(80%) contrast(1) opacity(0.8);filter: sepia(80%) grayscale(1) contrast(1) opacity(0.8);mix-blend-mode: multiply;width: 100%;\" class=\"media\" src=\""+list.get(b).getImg()+"\" alt=\"\">\n" +
                                "              <figcaption class=\"figcaption\" style=\"box-sizing: border-box;font-style: italic;font-size: 12px;\">"+list.get(b).getName_News()+" 사진자료</figcaption>\n" +
                                "            </figure>\n" +
                                "            <p style=\"box-sizing: border-box;margin-top: 0;margin-bottom: 20px;\">"+body+"</p>\n" +
                                "          </div>";
                    }
                    ;
                    content += "</div>";
                    fw.write(content);
                    fw.flush();
                    fw.close();

                } catch (Exception e) {
                    System.out.println(e);
                }//end of file쓰기 try-catch

                String email = maillist.get(a).getEmail();

                try {
                    String mailsever = "mw-002.cafe24.com";
                    Properties props = new Properties();
                    props.put("mail.smtp.host", mailsever);
                    props.put("mail.smtp.auth", true);
                    Authenticator myAuth = new MyAuthenticator();
                    Session sess = Session.getInstance(props, myAuth);
                    String to = email;
                    String from = "assistock@naver.com";
                    String subject = "어시스톡에서 오늘의 뉴스를 전달해 드립니다.";
                    FileInputStream fis = new FileInputStream("src/main/resources/static/mail/" + ID + "Newsletter.txt");
                    String mailtext = IOUtils.toString(fis, "UTF-8");
                    InternetAddress[] address = {new InternetAddress(to)};
                    Message message = new MimeMessage(sess);
                    message.setRecipients(Message.RecipientType.TO, address);
                    message.setFrom(new InternetAddress(from, "어시스톡"));
                    message.setSubject(subject);
                    message.setContent(mailtext, "text/html;charset=UTF-8");
                    message.setSentDate(new Date());
                    Transport.send(message);
                    System.out.println("PW 이메일전송 完");
                } catch (Exception e) {
                    System.out.println(e.getClass().getName() + " 예외가" + e.getMessage() + " 때문에 발생");

                }

                System.out.println("Task executed!");


            }
            ;


        } catch (Exception e) {
            System.out.println(e);
        }


        // Schedule the task to be executed at the desired time
//        timer.scheduleAtFixedRate(task, now.getTime(), 1000 * 60 * 60 * 24);
//    }

    }
}//end of MailCont class


