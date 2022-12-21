package dh.assistock.mail;

import utility.MyAuthenticator;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

public class MailCont {
    public static void main(String[] args) {
        // Create a Calendar object to represent the current time
        Calendar now = Calendar.getInstance();

        // Set the Calendar object to the desired execution time: 9 a.m.
        now.set(Calendar.HOUR_OF_DAY, 9);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);

        // If the execution time has already passed today, schedule the task for tomorrow
        if (now.before(Calendar.getInstance())) {
            now.add(Calendar.DATE, 1);
        }

        // Create a Timer object
        Timer timer = new Timer();

        // Create a TimerTask to be executed at the desired execution time
        TimerTask task = new TimerTask() {
            public void run() {
                // This code will be executed every day at 9 a.m.

                String email = "gpgp910@naver.com";
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
                    String content = dto.getPW();


                    <div class="head" >
    <div class="headerobjectswrapper" >
        <div class="weatherforcastbox" >
            <%-- < img src = "../images/Favi4.png" style = "overflow:hidden" / > -- % >
            <span style = "font-style: italic;" >
                <p > 오늘 뉴스 평균 점수 </p >
                <c:
                    forEach var = "row" items = "${result.rows}" >
                <c:
                    out value = "${row.avg_score}" / > 점
                            </c:
                    forEach ></span >
        </div >
        <header > The assistock </header >
    </div >
    <div class="subhead" >
        <%--TODO 호스팅되면 링크 바꾸기-- % >
        <div class="issue" ><a href = "/" > www.assistock.com </a ></div >
        <div class="edition" ><c:
                    out value = "${sessionScope.ID}" / > 's News</div>
                            < div class="date" ><c:
                    out value = "${today}" / ></div >
    </div >
</div >
<div class="content" >
    <div class="collumns" id = "keywordNews" >
    </div >
</div >
<%--스크립트-- % >
<script src = "../js/mailContent.js" ></script >


                            InternetAddress[]address = {new InternetAddress(to)};
                    Message message = new MimeMessage(sess);
                    message.setRecipients(Message.RecipientType.TO, address);
                    message.setFrom(new InternetAddress(from, "어시스톡"));
                    message.setSubject(subject);
                    message.setContent(dto.getID() + "님의 바뀐 비밀번호는 : " + content + " 입니다.", "text/html;charset=UTF-8");
                    message.setSentDate(new Date());
                    Transport.send(message);
                    System.out.println("PW 이메일전송 完");
                } catch (Exception e) {
                    System.out.println(e.getClass().getName() + " 예외가" + e.getMessage() + " 때문에 발생");

                }

                System.out.println("Task executed!");
            }
        };

        // Schedule the task to be executed at the desired time
        timer.scheduleAtFixedRate(task, now.getTime(), 1000 * 60 * 60 * 24);
    }

} //end of MailCont class
