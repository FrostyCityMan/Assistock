package dh.assistock.mail;

import dh.assistock.dashboard.DashboardDAO2;
import dh.assistock.dashboard.DashboardDTO;
import dh.assistock.member.MemberDAO;
import dh.assistock.member.MemberDTO;
import dh.assistock.wordcloud.WordCloudDAO;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import utility.MyAuthenticator;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Properties;
@Controller
public class MailCont {
    @Autowired
    MailDAO2 mailDAO2;
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
        DashboardDAO2 dashboardDAO = new DashboardDAO2();
        MemberDAO memberDAO = new MemberDAO();
        List<MemberDTO> maillist = memberDAO.mailList();
        System.out.println(maillist);
        for (int a=0; maillist.size() > a; a++) {
            String ID = maillist.get(a).getID();
            List<DashboardDTO> dashboardDTO = dashboardDAO.userKeywords(ID);
            for (int i = 0; i < dashboardDTO.size(); i++) {
            String keyword = dashboardDTO.get(i).getKeywords();
            }//end of 키워드
            File file = new File("src/main/resources/static/mail/"+ID+"Newsletter.txt");
            try {
                BufferedWriter fw = new BufferedWriter(new FileWriter(file, false));
                String content ="<body style=\"box-sizing: border-box;margin: 0;font-family: 'Droid Serif', serif;font-size: 14px;font-weight: 400;line-height: 1.5;color: #2f2f2f;background-color: #f9f7f1;-webkit-text-size-adjust: 100%;-webkit-tap-highlight-color: transparent;\">\n" +
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
                        "            mesl456's News\n" +
                        "        </div>\n" +
                        "        <div class=\"date\" style=\"box-sizing: border-box;flex: 1;padding: 8px;width: 25%;display: inline-grid !important;\">\n" +
                        "            2022-12-23\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</div>\n" +
                        "<div class=\"content\" style=\"box-sizing: border-box;font-size: 0;line-height: 0;word-spacing: -.31em;display: inline-block;margin: 30px 2% 0 2%;\">";
                        for(int b=0; b<7; b++){
                            content += b;
                        };
                        content+="</div>";

            }catch (Exception e){
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
                FileInputStream fis = new FileInputStream("src/main/resources/static/mail/"+ID+"Newsletter.txt");
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


    }


//        };

    // Schedule the task to be executed at the desired time
//        timer.scheduleAtFixedRate(task, now.getTime(), 1000 * 60 * 60 * 24);
//    }


} //end of MailCont class


