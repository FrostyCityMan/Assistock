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
        now.set(Calendar.HOUR_OF_DAY, 17);
        now.set(Calendar.MINUTE, 27);
        now.set(Calendar.SECOND, 0);
        System.out.println("메일링 스타트");
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
                    String content = "<html><head>\n" +
                            "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n" +
                            "    <script src=\"../js/jquery-3.6.1.min.js\"></script>\n" +
                            "    <script src=\"../js/jquery.cookie.js\"></script>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "\n" +
                            "    <link href=\"https://fonts.googleapis.com/css?family=Playfair+Display:400,700,900,400italic,700italic,900italic|Droid+Serif:400,700,400italic,700italic\" rel=\"stylesheet\" type=\"text/css\">\n" +
                            "    <title>당신의 투자를 위한\n" +
                            "        의사결정 지원 플랫폼, 어시스톡</title>\n" +
                            "    <link rel=\"icon\" type=\"image/x-icon\" href=\"../images/Favi4.png\">\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "    <link rel=\"stylesheet\" href=\"../css/mailContetnt.css\">\n" +
                            "\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"head\">\n" +
                            "    <div class=\"headerobjectswrapper\">\n" +
                            "        <div class=\"weatherforcastbox\">\n" +
                            "            \n" +
                            "            <span style=\"font-style: italic;\">\n" +
                            "                <p>오늘 뉴스 평균 점수</p>\n" +
                            "                \n" +
                            "                 1.133점\n" +
                            "            </span>\n" +
                            "        </div>\n" +
                            "        <header>The assistock</header>\n" +
                            "    </div>\n" +
                            "    <div class=\"subhead\">\n" +
                            "        \n" +
                            "        <div class=\"issue\"><a href=\"/\">www.assistock.com</a></div>\n" +
                            "        <div class=\"edition\">mesl456's News</div>\n" +
                            "        <div class=\"date\">2022-12-21(수)</div>\n" +
                            "    </div>\n" +
                            "</div>\n" +
                            "<div class=\"content\">\n" +
                            "    <div class=\"collumns\" id=\"keywordNews\">\n" +
                            "    \n" +
                            "          <div class=\"collumn\">\n" +
                            "            <div class=\"head\">\n" +
                            "              <span class=\"headline hl5\">[지구촌 돋보기] 영국, 르완다로 ‘난민 밀어내기’ 본격화하나</span>\n" +
                            "              <p><span class=\"headline hl6\">르완다 <br>\n" +
                            "              </span></p>\n" +
                            "            </div>\n" +
                            "            <p style=\"font-size: 20px; font-weight: bold\"> 1차 금속 제조업</p>\n" +
                            "            <figure class=\"figure\">\n" +
                            "              <img class=\"media\" src=\"https://imgnews.pstatic.net/image/origin/056/2022/12/21/11396413.jpg?type=nf\" alt=\"\">\n" +
                            "              <figcaption class=\"figcaption\">KBS 사진자료</figcaption>\n" +
                            "            </figure>\n" +
                            "            <p></p><div id=\"video_area_0\" class=\"video_area _VIDEO_AREA\"></div><br><br> [앵커]<br><br> 유럽 국가들의 풀리지 않는 숙제, 바로 난민 문제죠.<br><br> 영국 정부가 앞으로는 불법 이주자들을 아프리카 르완다로 강제 이송하겠다고 해 논란이 됐는데, 이런 시도가 법적으로 아무런 문제가 없다고 영국 법원이 판결했습니다.<br><br> 르완다 역시 난민들의 피난처가 돼 주겠다며 이 정책을 반기고 있는데, 정말 그럴 수 있을까요?<br><br> 지구촌 돋보기에서 황경주 기자와 자세히 알아봅니다.<br><br> 영국 법원이 정부의 손을 들어줬군요?<br><br>[기자]<br><br> 네, 영국 정부의 이른바 '난민 밀어내기' 정책이 합법적이라고 영국 법원이 판단했습니다.<br><br> 영국 고등법원은 현지시각 19일 난민 신청자를 르완다로 이송하는 정부 방침이 인권법과 유엔난민협약을 위반하지 않는다고 판결했습니다.<br><br> 리시 수낵 영국 총리는 \"불법 이주에 잘 대처할 수 있게 됐다\"며 이번 판결을 환영했습니다.<br><br> 영국 정부는 보리스 전 총리가 수장이던 지난 4월, 영연방인 르완다 정부와 난민 이송 협약을 맺었는데요.<br><br> 영국이 난민 신청자를 르완다로 보내 망명 심사를 받게 하는 대신, 르완다에 1억 2천만 파운드, 우리 돈 천9백억 원 정도를 지불한다는 내용입니다.<br><br> 르완다로 옮겨진 사람들이 현지에서 난민 지위를 얻으면 5년 동안 머물며 교육을 받게 되고, 그렇지 않으면 다른 이민 절차를 밟거나 추방됩니다.<br><br> [앵커]<br><br> 사실상 돈을 내고 사람을 거래하는 셈이라서 나라 안팎의 비판이 크겠는데요?<br><br>[기자]<br><br> 네, 영국 정부가 이 정책을 강하게 밀어붙이면서 비판 여론이 상당한데요.<br><br> 영국과 르완다가 난민 이송 협약을 맺은 두달 뒤인 지난 6월, 영국은 실제로 불법 이주민들을 르완다행 비행기에 태웠습니다.<br><br> 다만 이륙 직전 유럽인권재판소가 나서서 계획을 중단하라고 명령하면서, 당시 비행기가 영국 공군기지를 떠나지는 못했습니다.<br><br>[필리포 그란디/유엔 난민고등판무관 : \"지난 몇 주 동안 우리는 이 모든 것이 잘못됐다고 확실히 믿게 됐습니다. 이 거래는 모두 잘못된 것입니다.\"]<br><br> 유엔난민기구 역시 이 정책에 대해 '대참사'라고 규정했고, 영국 국교회 지도부는 '부도덕하고 수치스러운 일'이라고 비난했는데요.<br><br> 목숨을 걸고 살길을 찾아 온 사람들을 6,500km 떨어진 생면부지의 나라로 보내 버리는 이 정책이 비인간적이라는 겁니다.<br><br>[앵커]<br><br> 영국 정부는 난민들을 악용하는 각종 범죄를 없애겠다는 명분을 내세우고 있죠?<br><br>[기자]<br><br> 네. 불법 이주자들이 위험하게 영국해협을 건너면서 생기는 각종 사고를 막고, 또 이들을 악용하는 인신매매업자 등을 몰아내기 위한 조치라고 말하고 있습니다.<br><br> 하지만 갈수록 늘고 있는 난민을 막아보자는 게 가장 큰 이유일 텐데요.<br><br> 지난해만 2만 8천여 명이 프랑스 북부에서 영국해협을 건너 영국으로 밀입국한 것으로 추정됩니다.<br><br> 주로 중동과 아프리카에서 난민 지위나 일자리를 얻기 위해 오는 사람들입니다.<br><br> 영국은 이들을 르완다로 보내기 위해 인권 탄압이 심각하기로 유명한 르완다에 대한 평가도 180도 바꿨습니다.<br><br> 르완다가 안전한 법치주의 국가라면서, 난민들의 재정착을 돕는 데 숙련된 나라라고 표현했습니다.<br><br>[프리티 파텔/전 영국 내무장관 : \"영국과 르완다는 협력하여 이민 제도를 더 공정하게 만들고, 사람들이 안전하고, 번영할 수 있는 새로운 기회를 누릴 수 있도록 도울 것입니다.\"]<br><br> 돈과 함께 난민을 받게 되는 르완다 역시 이민자들에게 안전한 피난처를 제공하겠다고 호응하고 있습니다.<br><br>[앵커]<br><br> 하지만 현실은 양국 정부가 내세우는 것과는 많이 다르다면서요?<br><br>[기자]<br><br> 르완다는 이전에도 다른 나라에서 추방된 난민을 받아들인 적이 있는데, 당시 상황을 들여다보면 인권과는 거리가 멉니다.<br><br> BBC는 지난 6월 '이스라엘이 르완다에 난민을 보냈을 때 무슨 일이 벌어졌나'라는 제목의 기사를 실었는데요.<br><br> 기사를 보면 이스라엘은 2013년~2018년 사이 망명자 약 4천 명을 비공식적으로 르완다와 우간다로 보냈습니다.<br><br> 당시에 르완다로 보내진 한 망명 신청자는 \"르완다에서 환영받지 못해 다른 나라로 떠나야 했고, 그 모든 과정에서 돈을 내야 했다\"고 증언했습니다.<br><br> 인권 단체들도 르완다가 '인권 탄압국'이라는 오명을 씻으려는 목적으로 영국의 제안을 받아들인 것이라고 지적하고 있는데요.<br><br> 폴 카가메 르완다 대통령은 반체제 인물들을 암살한다는 의혹을 꾸준히 받아 온 인물입니다.<br><br> 지난해 국경없는기자회가 집계한 세계 언론자유 지수에서 르완다는 180개국 중 156개국을 차지했고, 이는 전년도보다도 한 계단 떨어진 순위입니다.<br><br> 지금까지 지구촌 돋보기 황경주였습니다.<br><br><p></p>\n" +
                            "          </div>\n" +
                            "        \n" +
                            "          <div class=\"collumn\">\n" +
                            "            <div class=\"head\">\n" +
                            "              <span class=\"headline hl5\">트럼프 '반란선동' 혐의…美하원, 형사처벌 권고</span>\n" +
                            "              <p><span class=\"headline hl6\">미국 <br>\n" +
                            "              </span></p>\n" +
                            "            </div>\n" +
                            "            <p style=\"font-size: 20px; font-weight: bold\"> 코크스, 연탄 및 석유정제품 제조업</p>\n" +
                            "            <figure class=\"figure\">\n" +
                            "              <img class=\"media\" src=\"https://imgnews.pstatic.net/image/origin/008/2022/12/21/4831178.jpg?type=nf\" alt=\"\">\n" +
                            "              <figcaption class=\"figcaption\">머니투데이 사진자료</figcaption>\n" +
                            "            </figure>\n" +
                            "            <p><span class=\"end_photo_org\">\n" +
                            " </span></p><div class=\"nbd_im_w _LAZY_LOADING_WRAP \">\n" +
                            "  <div class=\"nbd_a _LAZY_LOADING_ERROR_HIDE\" id=\"img_a1\"><img id=\"img1\" data-src=\"https://imgnews.pstatic.net/image/008/2022/12/21/0004831178_001_20221221050101047.jpg?type=w647\" class=\"_LAZY_LOADING\">\n" +
                            "  </div>\n" +
                            " </div><em class=\"img_desc\">The members of the U.S. House Select Committee investigating the January 6 Attack on the U.S. Capitol sit beneath a video of former U.S. President Donald Trump talking about the results of the 2020 U.S. Presidential election as they hold their final public meeting to release their report on Capitol Hill in Washington, U.S., December 19, 2022. REUTERS/Jonathan Ernst /사진=로이터=뉴스1</em><br>지난해 1월6일 발생한 미국 의회 공격사건을 조사하는 미 하원 특위는 19일(현지시간) 법무부에 트럼프 전 대통령에 대한 형사처벌을 권고하는 의견을 포함한 최종 보고서를 채택했다. <br><br>이날 마지막 회의를 연 특위는 지난 1·6 의회난입 사건과 관련, 트럼프 전 대통령에게 △공무집행 방해죄 △미국에 대한 사기음모 △거짓 진술 음모 △반란을 선동하거나 지원 또는 이를 위한 편의를 제공한 것 등 4개 혐의를 적용해 기소할 것을 법무부에 권고했다. 이 결정은 투표에 나선 9명 위원 전원 만장일치로 이뤄졌다.<br><br>이번 의회 공격을 '쿠데타 미수의 정점'이라고 불러온 베니 톰슨 의장은 트럼프 전 대통령이 여러 시도를 통해 유임을 시도하고 조 바이든 대통령에게 권력 이양을 저지하려 했다고 말했다. <br><br>위원회 부위원장인 리즈 체니 공화당 의원(와이오밍)은 \"트럼프 대통령이 폭도들을 멈추게 하는 것을 거부한 것은 '완전한 도덕적 실패'\"라고 지적했다. 그는 \"우리 역사상 모든 대통령들은 한 명(트럼프)을 제외하고는 질서 있는 권한 이양을 옹호해왔다\"고 말했다. <br><br>뉴욕타임스는 \"의회가 전직 대통령에 대한 형사처벌을 권고한 것은 미국 역사상 처음\"이라며 \"이번 조치는 트럼프 전 대통령 지지자 중 폭도들이 의사당을 포위하고 2020년 선거를 뒤집으려 했던 시도에 대해 위원회가 18개월 간 진행한 강도높은 조사의 종지부\"라고 평가했다. <br><br>이번 조치는 법적 구속력이 없는 상징적 조치에 불과하지만, 의회의 초당적 위원회가 전 대통령이 범죄를 저질렀다고 믿고 있다는 강력한 신호를 보낸 것이라는 점에서 의미가 크다는 진단이다. 실제 기소 여부는 연방 검찰이 결정한다. <br><br>미 법무부 측은 이날 특위 발표에 대해 별다른 입장을 내놓지 않았다. <br><br>이밖에 위원회는 조사 시 소환에 불응한 케빈 매카시(캘리포니아), 짐 조던(오하이오), 스콧 페리(펜실베니아), 앤디 빅스(애리조나) 등 공화당 의원 4명을 하원 윤리위원회에 회부했다. <br><br>앞서 전날 트럼프 전 대통령은 자신의 소셜미디어 플랫폼에 특위 의원들을 \"폭도와 악당들\"이라고 비난했다.<!--article_split--><p></p>\n" +
                            "          </div>\n" +
                            "        \n" +
                            "          <div class=\"collumn\">\n" +
                            "            <div class=\"head\">\n" +
                            "              <span class=\"headline hl5\">국내 유일 발포정 생산 기업… 아시아서 독보적 입지</span>\n" +
                            "              <p><span class=\"headline hl6\"> 서산<br>\n" +
                            "              </span></p>\n" +
                            "            </div>\n" +
                            "            <p style=\"font-size: 20px; font-weight: bold\"> 비금속 광물제품 제조업</p>\n" +
                            "            <figure class=\"figure\">\n" +
                            "              <img class=\"media\" src=\"https://imgnews.pstatic.net/image/origin/020/2022/12/21/3469263.jpg?type=nf\" alt=\"\">\n" +
                            "              <figcaption class=\"figcaption\">동아일보 사진자료</figcaption>\n" +
                            "            </figure>\n" +
                            "            <p><strong class=\"media_end_summary\">[2022 대한민국 중소벤처기업 대상]<br>대한민국 중소벤처기업 대상<br>기술혁신 부문</strong><span class=\"end_photo_org\">\n" +
                            " </span></p><div class=\"nbd_im_w _LAZY_LOADING_WRAP is_small\">\n" +
                            "  <div class=\"nbd_a _LAZY_LOADING_ERROR_HIDE\" id=\"img_a1\"><img id=\"img1\" data-src=\"https://imgnews.pstatic.net/image/020/2022/12/21/0003469263_001_20221221030431889.jpg?type=w647\" class=\"_LAZY_LOADING\">\n" +
                            "  </div>\n" +
                            " </div><span class=\"end_photo_org\">\n" +
                            " <div class=\"nbd_im_w _LAZY_LOADING_WRAP is_small\">\n" +
                            "  <div class=\"nbd_a _LAZY_LOADING_ERROR_HIDE\" id=\"img_a2\"><img id=\"img2\" data-src=\"https://imgnews.pstatic.net/image/020/2022/12/21/0003469263_002_20221221030431910.jpg?type=w647\" class=\"_LAZY_LOADING\">\n" +
                            "  </div>\n" +
                            " </div><em class=\"img_desc\">김동호 대표</em></span>에프엔바이오㈜는 국내 유일, 아시아 최고의 발포정 전문 생산업체다. 제약 기술강국인 일본조차도 현재 해당 기술 생산기업을 보유하고 있지 않다.<br><br> 에프엔바이오는 HACCP, GMP, ISO22000, 이노비즈 인증 획득 및 다수의 특허를 보유함으로써 기술력에서도 높은 평가를 받으며 ‘2022 대한민국 중소벤처기업 대상’에선 기술혁신 부문 수상자로 이름을 올렸다. <br><br> 올해 한류 열풍으로 태국, 베트남 등 동남아와 홍콩을 비롯한 해외 시장에서 100만 달러 수출 실적을 달성했다. 구연산 코팅, 타정·보존기술을 기반으로 착실히 실적을 쌓아올렸다. <br><br> 연세대 식품공학과 출신으로 대기업과 사업경력까지 포함하면 식품 관련 경력이 40년에 이르는 김동호 대표의 경험과 네트워크가 성공의 밑바탕이 됐다는 평가가 나온다.<br><br> 현재 3개년 연평균 200만 달러 수출 실적을 기록하고 있다. 에프엔바이오는 2023년 3월 준공을 목표로 서산공장을 신축 중이다. <br><br> 이에 맞춰 독보적인 발포정 전문기업으로 적극적인 신제품개발과 사업 다각화로 국가발전에도 크게 기여한다는 계획이다.<br><br> 김 대표는 “건강과 환경을 미래 성장 동력의 핵심 과제로 선정하고 국가를 대표하는 발포정 전문 글로벌 강소기업으로 도약해나가겠다”라고 수상 소감을 밝혔다.<p></p>\n" +
                            "          </div>\n" +
                            "        \n" +
                            "          <div class=\"collumn\">\n" +
                            "            <div class=\"head\">\n" +
                            "              <span class=\"headline hl5\">“미세공정 초격차로 위기 극복” 삼성, 최선단 12나노급 D램 개발</span>\n" +
                            "              <p><span class=\"headline hl6\"> 삼성전자<br>\n" +
                            "              </span></p>\n" +
                            "            </div>\n" +
                            "            <p style=\"font-size: 20px; font-weight: bold\"> 전자부품, 컴퓨터, 영상, 음향 및 통신장비 제조업</p>\n" +
                            "            <figure class=\"figure\">\n" +
                            "              <img class=\"media\" src=\"https://imgnews.pstatic.net/image/origin/005/2022/12/21/1574779.jpg?type=nf\" alt=\"\">\n" +
                            "              <figcaption class=\"figcaption\">국민일보 사진자료</figcaption>\n" +
                            "            </figure>\n" +
                            "            <p><span class=\"end_photo_org\">\n" +
                            " </span></p><div class=\"nbd_im_w _LAZY_LOADING_WRAP \">\n" +
                            "  <div class=\"nbd_a _LAZY_LOADING_ERROR_HIDE\" id=\"img_a1\"><img id=\"img1\" data-src=\"https://imgnews.pstatic.net/image/005/2022/12/21/2022122115311043135_1671604270_0017792089_20221221161601747.jpg?type=w647\" class=\"_LAZY_LOADING\">\n" +
                            "  </div>\n" +
                            " </div><em class=\"img_desc\">삼성전자가 개발한 업계 최선단 12나노급 16Gb DDR5 D램 모습. 삼성전자 제공</em><br><br>삼성전자가 반도체 업계 최초로 12나노미터(㎚, 10억분의 1m)<span>급 공정으로 D램을 개발하는 데 성공했다. 글로벌 경기침체로 반도체 산업이 ‘빙하기’를 맞고 있지만, ‘기술 초격차’로 위기를 돌파하겠다는 전략이다.</span><br><br>삼성전자는 업계 최선단인 12나노급 공정으로 16기가비트(Gb) DDR5 D램을 개발했다고 21일 밝혔다. 최근 AMD와 함께 호환성 검증까지 마쳤다. DDR5는 차세대 D램 규격이다. 상용화한 DDR4보다 2배 이상 빠르다. 전력 효율도 30% 이상 좋다. 삼성전자 관계자는 “유전율(K)이 높은 신소재를 적용해 전하를 저장하는 커패시터(Capacitor)의 용량을 높이고, 회로 특성 개선을 위한 설계 등으로 업계 최선단 공정을 완성했다. 멀티레이어 극자외선(EUV) 기술을 활용해 업계 최고 수준의 집적도로 개발했다”고 설명했다.<br><br>DDR5 규격의 이번 제품은 최대 동작속도 7.2Gbps(초당 기가비트)를 지원한다. 1초에 30GB 용량의 UHD 화질 영화 2편을 처리할 수 있다. 이전 세대의 제품보다 소비 전력이 약 23% 개선되기도 했다. 삼성전자 관계자는 “기후위기 극복에 동참하고 있는 글로벌 IT기업에 최상의 솔루션이 될 것으로 기대한다”고 강조했다.<br><br>반도체 업계에서는 삼성전자가 지난해 10월 업계 최선단인 14나노 DDR5 D램을 양산한 데 이어 12나노급 D램 개발에 성공하면서 경쟁자들보다 앞서나갈 수 있는 발판을 마련했다고 평가한다.<br><br>삼성전자는 반도체 한파에 따른 실적 악화를 이겨내는 데 도움이 될 것으로 판단한다. 삼성전자 관계자는 “현재 DDR5 시장의 주력 모델 성능이 4800Mbps에서 5600Mbps로 옮겨가고 있다. 내년에는 데이터센터 증설 확대에 따라 신규 CPU를 위한 DDR5 채용이 늘 것으로 전망한다”면서 “시장에서 요구하는 성능을 크게 웃도는 이번 제품의 차별화된 성능으로 차세대 DDR5 시장을 본격 견인할 계획”이라고 말했다.<br><br>삼성전자는 글로벌 IT기업들과 협력해 시장 지배력을 강화할 방침이다. 조 매크리 AMD 최고기술책임자(CTO)는 “기술의 한계를 뛰어넘는 혁신을 위해서는 파트너들의 긴밀한 협력이 필요하다. AMD의 젠(Zen) 플랫폼에서 DDR5를 검증하고 최적화하는 데 삼성과 협력할 수 있어 기쁘다”고 했다. 이주영 삼성전자 메모리사업부 D램개발실장(부사장)은 “업계 최선단 12나노급 D램은 DDR5 시장 확대의 기폭제가 될 것”이라고 말했다.<p></p>\n" +
                            "          </div>\n" +
                            "        \n" +
                            "          <div class=\"collumn\">\n" +
                            "            <div class=\"head\">\n" +
                            "              <span class=\"headline hl5\">'머스크 딸' 스토커 차로 들이받았다…용의자 누군지 봤더니</span>\n" +
                            "              <p><span class=\"headline hl6\">영국 <br>\n" +
                            "              </span></p>\n" +
                            "            </div>\n" +
                            "            <p style=\"font-size: 20px; font-weight: bold\"> 자동차 및 부품 판매업</p>\n" +
                            "            <figure class=\"figure\">\n" +
                            "              <img class=\"media\" src=\"https://imgnews.pstatic.net/image/origin/015/2022/12/21/4789896.jpg?type=nf\" alt=\"\">\n" +
                            "              <figcaption class=\"figcaption\">한국경제 사진자료</figcaption>\n" +
                            "            </figure>\n" +
                            "            <p><span class=\"end_photo_org\">\n" +
                            " </span></p><div class=\"nbd_im_w _LAZY_LOADING_WRAP \">\n" +
                            "  <div class=\"nbd_a _LAZY_LOADING_ERROR_HIDE\" id=\"img_a1\"><img id=\"img1\" data-src=\"https://imgnews.pstatic.net/image/015/2022/12/21/0004789896_001_20221221132202742.jpg?type=w647\" class=\"_LAZY_LOADING\">\n" +
                            "  </div>\n" +
                            " </div><em class=\"img_desc\">일론 머스크.</em><br>일론 머스크 테슬라·트위터 최고경영자(CEO)의 경호원이 차량으로 행인을 들이받은 혐의로 경찰 조사를 받고 있는 가운데 최근 머스크가 '미친 스토커'가 자신의 자녀를 미행했다고 주장한 사건과 연관이 있다는 추정이 제기됐다. <br><br>20일(현지시간) 블룸버그 통신과 영국 일간 가디언 등에 따르면 지난 13일 오후 9시 51분께 코네티컷주 출신의 남성 A씨(29)는 미국 로스앤젤레스(LA) 외곽 사우스패서디나의 한 주차장에서 폭행을 당했다며 경찰에 신고했다. <br><br>A씨는 휴대전화를 사용하고자 이 주차장에 잠시 멈췄는데 한 차량이 그에게 접근하더니 \"왜 우리를 따라오느냐\"며 시비를 걸고 차량으로 자신을 쳤다고 진술했다.<br><br>현지 경찰은 머스크가 고용한 경호원 중 한 명을 폭행 용의자로 보고 조사하고 있다. 앞서 머스크는 같은 날 트위터에서 자신의 자녀가 탄 차량을 \"미친 스토커\"가 따라왔다며 차가 움직이지 못하도록 보닛 위에 올라타는 등 소동이 일었다고 언급한 바 있다. 스토커로 지목된 인물은 우버이츠 배달 기사로 추후 확인됐다.<br><br>미 일간 워싱턴포스트(WP)는 이 인물이 과거 대리모를 통해 머스크의 딸을 출산한 전 여자친구 그라임스(본명 클레어 바우처)로부터 \"암호화된 인스타그램 메시지\"를 받고 있으며 \"머스크가 내 위치를 실시간 모니터링하고 있다\"고 주장하는 등 횡설수설했다고 말했다.<br><br><p></p>\n" +
                            "          </div>\n" +
                            "        \n" +
                            "          <div class=\"collumn\">\n" +
                            "            <div class=\"head\">\n" +
                            "              <span class=\"headline hl5\">윤석열 정부, 기시다의 '위험한 꼼수' 지지하나</span>\n" +
                            "              <p><span class=\"headline hl6\">일본 <br>\n" +
                            "              </span></p>\n" +
                            "            </div>\n" +
                            "            <p style=\"font-size: 20px; font-weight: bold\"> 자동차 및 부품 판매업</p>\n" +
                            "            <figure class=\"figure\">\n" +
                            "              <img class=\"media\" src=\"https://imgnews.pstatic.net/image/origin/047/2022/12/21/2376823.jpg?type=nf\" alt=\"\">\n" +
                            "              <figcaption class=\"figcaption\">오마이뉴스 사진자료</figcaption>\n" +
                            "            </figure>\n" +
                            "            <p><strong>[주장] 평화헌법 뒤흔드는 일본의 안보전략 개정... 반대입장 분명히 해야 </strong><br><br>\n" +
                            "<table class=\"nbd_table\">\n" +
                            " <tbody>\n" +
                            "  <tr>\n" +
                            "   <td><span class=\"end_photo_org\">\n" +
                            "     <div class=\"nbd_im_w _LAZY_LOADING_WRAP \">\n" +
                            "      <div class=\"nbd_a _LAZY_LOADING_ERROR_HIDE\" id=\"img_a1\"><img id=\"img1\" data-src=\"https://imgnews.pstatic.net/image/047/2022/12/21/0002376823_001_20221221170001190.jpg?type=w647\" class=\"_LAZY_LOADING\">\n" +
                            "      </div>\n" +
                            "     </div></span></td>\n" +
                            "  </tr>\n" +
                            "  <tr>\n" +
                            "   <td><b>▲ </b>&nbsp;윤석열 대통령이 지난 10월 13일(현지시간) 캄보디아 프놈펜의 한 호텔에서 열린 한일 정상회담에서 기시다 후미오 일본 총리와 손을 잡은 채 기념 촬영을 하고 있다.</td>\n" +
                            "  </tr>\n" +
                            "  <tr>\n" +
                            "   <td>ⓒ 대통령실 제공</td>\n" +
                            "  </tr>\n" +
                            " </tbody>\n" +
                            "</table><br>&nbsp;<br>지난 16일 일본 기시다 내각이 &lt;국가안전보장전략&gt; 등 3대 안보문서 개정을 통해 2차 대전 이후 유지돼 온 '전수방위(專守防衛)', 즉 적으로부터 공격을 받았을 때 비로소 방위력을 행사한다는 원칙을 실질적으로 무력화시켰다.<br><br>일본 평화헌법을 개정하지 않고 꼼수를 부린 것이다. 그러나 우리 정부는 이에 대해 모호한 입장만을 취하고 있다. 이 기사는 일본의 속이 보이는 전수방위 무력화에 미온적으로 대응하는 우리 정부의 문제점을 제기하고자 한다.<br>&nbsp;<br><strong>평화헌법 뒤흔드는 3대 안보문서 꼼수 개정</strong><br>&nbsp;<br>일본 정부는 지난 16일 임시 각의(閣議, 국무회의)를 통해 적 미사일 기지 등을 공격할 수 있는 '반격 능력'을 보유하는 내용을 포함한 3대 안보문서를 개정했다. 이번에 개정된 3대 안보문서는 &lt;국가안전보장전략&gt; &lt;국가방위전략&gt; 그리고 &lt;방위력정비계획&gt;이다. 이들 문서는 일본의 외교안보 기본 지침과 자위대의 역할 및 방위력 건설, 그리고 방위 장비 조달을 규정한 핵심 문서들이다.<br>&nbsp;<br>3대 안보문서의 핵심적인 개정 내용은, 적이 일본에 대해 \"공격에 착수한 것이 확인되면\" 선제적으로 '적기지 공격 능력'(반격 능력)을 사용하겠다는 것이다. 그러나 어떤 기준으로 '공격 착수'를 판단할 것인지 모호하다. 판단 기준에 따라 '전수방위' 원칙이 무력화될 수 있는 것이다.<br>&nbsp;<br>일본의 평화헌법은 일본의 군사적 공격 의지와 그 능력을 스스로 부정한다. 평화헌법 제9조는 \"국제 분쟁을 해결하는 수단으로서 국권이 발동되는 전쟁과 무력에 의한 위협 또는 무력 행사를 영구히 포기\"함을 명시하고 있다. 보다 구체적으로 이러한 목적을 달성하기 위한 \"육·해·공군 및 기타 전력을 보유하지 않으며, 국가의 교전권을 인정하지 않는다\"는 것이다.<br>&nbsp;<br>잘 알려진 바와 같이 아베 전 총리는 평화헌법 제9조를 개정하기 위해 부단히 노력했다. 그러나 국내외의 반대로 헌법개정이 어려워진 상황에서 기시다 내각이 3대 안보문서 개정이라는 꼼수를 부린 것이다. 기시다 내각의 후속조치도 발빠르게 진행됐다. '반격 능력' 보유를 포함해 2023년 방위 예산을 올해보다 약 25%나 증가한 6조8000억 엔(약 65조 원)으로 증액했다.<br>&nbsp;<br><strong>윤석열 정부, 일본의 '전수방위' 무력화 지지하나&nbsp;</strong><br><br>전수방위를 무력화하기 위한 일본 정부의 시도는 아베 내각이 등장한 이후 끈질기게 추진돼 왔다. 일본이 식민지 역사를 인정하지 않고 반성하지 않는 상황에서 전수방위 원칙을 흔드는 것은, 식민지 당사국인 우리나라로서는 결단코 용납할 수 없는 것이다.<br>&nbsp;<br>윤석열 정부는 우리 국민의 정서와 달리 한일 군사협력에 정성을 쏟고 있다. 그러나 한일간 역사문제가 해결되지 않고 일본이 이를 인정하고 반성하지 않는 상황에서 군사협력에 대한 우리 국민의 인식은 매우 부정적이다. 지난 11월 6일 진행된 일본 해상자위대 창설 70주년 관함식에서 우리 해군이 욱일기에 경례한 것과 관련해 우리 국민의 60.7%가 \"국민정서와 배치되는 부적절한 행동이었다\"고 답한 바 있다('미디어토마토' 60차 정기 여론조사).<br>&nbsp;<br>일본의 안보전략 개정에 대해 윤석열 정부는 반격 능력을 \"전수방위 개념을 변경치 않으면서 엄격한 요건 내에서 행사\"한다는 일본의 입장을 근거 없이 비호하고 있다. 또한 \"한반도 대상 반격 능력 행사와 같이 한반도 안보 및 우리의 국익에 중대한 영향을 미치는 사안은 사전에 우리와의 긴밀한 협의 및 동의가 반드시 필요\"하다고 강조한다. 그러나 이것은 한국 정부의 희망 사항일 뿐, 일본의 생각은 그렇지 않다.<br>&nbsp;<br><strong>한국, 일본의 '선제적 반격' 통제할 수 있나</strong><br>&nbsp; \n" +
                            "<table class=\"nbd_table\">\n" +
                            " <tbody>\n" +
                            "  <tr>\n" +
                            "   <td><span class=\"end_photo_org\">\n" +
                            "     <div class=\"nbd_im_w _LAZY_LOADING_WRAP \">\n" +
                            "      <div class=\"nbd_a _LAZY_LOADING_ERROR_HIDE\" id=\"img_a2\"><img id=\"img2\" data-src=\"https://imgnews.pstatic.net/image/047/2022/12/21/0002376823_002_20221221170001227.jpg?type=w647\" class=\"_LAZY_LOADING\">\n" +
                            "      </div>\n" +
                            "     </div></span></td>\n" +
                            "  </tr>\n" +
                            "  <tr>\n" +
                            "   <td><b>▲ </b>&nbsp;기시다 후미오 일본 총리가 지난 11월 6일 도쿄 인근 가나가와현 사가미만에서 미국 항공모함 로널드 레이건호의 제트 전투기 조종석에 앉고 있다.</td>\n" +
                            "  </tr>\n" +
                            "  <tr>\n" +
                            "   <td>ⓒ 교도통신=연합뉴스</td>\n" +
                            "  </tr>\n" +
                            " </tbody>\n" +
                            "</table><br>&nbsp;<br>일본의 새로운 안보전략에 대응한 미국과 중국의 대응도 주의 깊게 바라볼 필요가 있다. 미국은 \"일본의 새전략이 인도·태평양뿐만 아니라 세계 평화를 증진하고 질서에 기반한 규칙을 보호하기 위한 우리 동맹의 능력을 재구성\"했다며 환영(베단트 파텔 미 국무부 부대변인)했다. 반면 중국은 오키나와 근해에 랴오닝함 등 6척의 항모 전단을 파견해 무력 시위에 나섰다. 미국은 동북아 지역에서 북한뿐만 아니라 중국을 봉쇄하기 위한 거점으로 일본을 재건하기 위해 '전수방위'라는 일본의 결계를 걷어내려 하고 있다.<br>&nbsp;<br>일본의 '선제적 반격'은 단기적으로 북한의 미사일 발사에 대응한 것으로 이해된다. 종국적으로 그 범위는 중국을 향하게 될 것이다. 그렇다면 일본의 '선제적 반격'을 우리 정부는 통제할 수 있는가? 현재 일본의 입장을 봤을 때, 우리 정부가 일본의 대북 선제 반격을 통제할 수 있다고 단정하기 어렵다.<br>&nbsp;<br>최근 일본 방위성 인사는 외신기자 대상 브리핑에서 일본의 선제적 반격은 \"일본의 자위권을 행사하는 것으로 다른 국가의 허가를 얻는 것\"이 아니며, \"일본이 자체적으로 판단할 것\"이라 말해 충격을 주고 있다. 대한민국 헌법상 우리 영토로 규정된 북한에 대한 '선제적 반격'도 자체적으로 판단하겠다는 것이다. 이제 일본이 한반도에서 무력 충돌 가능성을 높이는 변수로 등장한 것이다.<br>&nbsp;<br><strong>한국은 일본 정부에 \"NO\"라고 말해야 한다</strong><br>&nbsp;<br>한국은 한반도 문제의 당사국이다. 윤석열 정부는 일본의 이번 안보전략 개정에 대해 반대 입장을 명확히 표명해야 한다. 무엇보다 일본이 한반도, 특히 북한을 목표로 한 '선제적 반격'을 가한다는 것은 또 다른 전쟁으로 비화될 수 있다는 점에서 절대로 용납할 수 없다.<br><br>아니나 다를까. 북한은 지난 20일 외무성 대변인 담화를 통해 북한의 \"자위권 행사를 핑계삼아 재침 군사력 증강이라는 검은 배 속을 채우려는 일본의 행태는 결코 정당화될 수 없고 용납될 수 없다\"며 \"부당하고 과욕적인 야망 실현 기도에 대해 실제적인 행동으로 계속해서 보여줄 것\"이라 엄포를 놨다. 한반도에서 또 다른 전선이 그어지고 있다.<br>&nbsp;<br>결론적으로 일본의 군사 행동, 최소한 한반도에 관한 행동은 한미연합의 한반도 안전보장의 틀 내에서 통제돼야 한다. 그렇지 않다면 한반도는 북일간 무력 충돌이라는 소용돌이 속에 빠져들 수 있기 때문이다. 이와 관련해 윤석열 정부는 미국 정부에게도 우리의 반대 입장을 명확히 전달해야 할 것이다.<br>&nbsp;<br>한일이 국가 주도로 양국의 현안을 해결하려는 자세는 매우 우려스럽다. 무엇보다도 윤석열 정부는 한일간 역사문제를 온전히 해결해야 한다는 우리 국민의 여론을 무시하고 있다. 기시다 내각 또한 스스로 평화헌법을 부정함으로써 평화헌법을 지지하는 일본 국민의 여론을 무시하고 있다.<br>&nbsp;<br>최근 한반도 문제에 관한 민주적 의사결정이 모든 관련국에서 침해받고 있다. 한일 양국의 시민사회가 이 문제에 적극적으로 대안을 모색하고 공동으로 대응해야 하는 이유가 여기에 있다.<br><br><strong>덧붙이는 글 | </strong>글쓴이 정일영씨는 서강대 사회과학연구소 연구교수입니다. 관심분야는 북한 사회통제체제, 남북관계 제도화, 한반도 평화체제 등으로, &lt;평양 오디세이&gt;, &lt;한반도 스케치北&gt; 등 집필에 참여했습니다.<br></p>\n" +
                            "          </div>\n" +
                            "        \n" +
                            "          <div class=\"collumn\">\n" +
                            "            <div class=\"head\">\n" +
                            "              <span class=\"headline hl5\">[스프] 일론 머스크식 '언론의 자유'는 민주주의를 위협한다</span>\n" +
                            "              <p><span class=\"headline hl6\">중국 <br>\n" +
                            "              </span></p>\n" +
                            "            </div>\n" +
                            "            <p style=\"font-size: 20px; font-weight: bold\"> 전자부품, 컴퓨터, 영상, 음향 및 통신장비 제조업</p>\n" +
                            "            <figure class=\"figure\">\n" +
                            "              <img class=\"media\" src=\"https://imgnews.pstatic.net/image/origin/055/2022/12/21/1022202.jpg?type=nf\" alt=\"\">\n" +
                            "              <figcaption class=\"figcaption\">SBS 사진자료</figcaption>\n" +
                            "            </figure>\n" +
                            "            <p><strong class=\"media_end_summary\">머스크가 트위터에선 물러난다지만…</strong>일론 머스크가 트위터 인수 두 달여 만에 최고경영자(CEO) 자리에서 물러나겠다고 밝혔습니다. 자신의 트위터에 \"후임을 맡아줄 만큼 어리석은 사람을 찾는 대로 물러나겠다\"고 발표했는데, 이에 앞서서는 역시 자기 트위터를 통해 CEO 사임 여부를 묻는 투표를 진행했습니다. 응답자 1천750만여 명 중에 57.5%가 사임에 찬성했습니다. 트위터 인수 이후 직원 수천 명을 대량 해고하고 언론사 기자들 계정을 무더기로 정지시키는 등의 조치로 머스크는 미국 내는 물론 국제적인 비난을 받아왔습니다. 이런 상황이 '머스크 리스크'라 불리면서 테슬라 주가 폭락의 주요 원인으로까지 지목되자 트위터에서 손을 떼기로 한 것으로 보입니다.<br><br><span class=\"end_photo_org\">\n" +
                            " </span></p><div class=\"nbd_im_w _LAZY_LOADING_WRAP \">\n" +
                            "  <div class=\"nbd_a _LAZY_LOADING_ERROR_HIDE\" id=\"img_a1\"><img id=\"img1\" data-src=\"https://imgnews.pstatic.net/image/055/2022/12/21/0001022202_002_20221221152801293.jpg?type=w647\" class=\"_LAZY_LOADING\">\n" +
                            "  </div>\n" +
                            " </div><br>스프에서 뉴욕타임스의 명칼럼을 번역하면서, 해당 글로벌 이슈의 맥락과 배경을 해설하고 있는 뉴스페퍼민트는 일론 머스크식 '언론의 자유'가 민주주의를 위협한다고 지적한 바 있습니다. 최근 상황을 상기하면서 한 번 읽어보시죠.\n" +
                            "<div style=\"border-bottom:1px solid #ebebeb; color:#3e3e40; position:relative\">\n" +
                            " &nbsp;\n" +
                            "</div><br>\n" +
                            "<hr><br>오랜 논란 끝에 테슬라(Tesla)의 창업자 일론 머스크(Elon Musk)가 트위터를 인수했습니다. 머스크를 새 주인으로 맞은 트위터는 상장을 철회하고 비공개기업이 됐는데, 이 과정에서 이미 갖은 내홍에 휩싸였습니다.<br><br>머스크가 트위터를 인수한 경위, 그 과정에서 빚어진 여러 논란에 관해선 여러 언론이 자세히 정리하고 있습니다. 언젠가 머스크의 트위터 인수 일지를 함께 정리해보는 것도 재미있을 것 같은데요, 아직 '트위터 사태'가 종착지에 가지 않았으므로 그 작업은 다음 기회로 미루고, 오늘은 \"언론의 자유의 메시아\"를 자처하는 머스크가 왜 민주주의에 위험할 수 있는지, 그 위험이 구체적으로 어떻게 드러날지 짚어보겠습니다.<br><br>먼저 뉴욕타임스 칼럼니스트 리디아 폴그린(Lydia Polgreen)이 쓴 칼럼 \"If You Want to Understand How Dangerous Elon Musk Is, Look Outside America\"을 옮겼습니다.<br><br><span class=\"end_photo_org\">\n" +
                            " <div class=\"nbd_im_w _LAZY_LOADING_WRAP \">\n" +
                            "  <div class=\"nbd_a _LAZY_LOADING_ERROR_HIDE\" id=\"img_a2\"><img id=\"img2\" data-src=\"https://imgnews.pstatic.net/image/055/2022/12/21/0001022202_003_20221221152801319.jpg?type=w647\" class=\"_LAZY_LOADING\">\n" +
                            "  </div>\n" +
                            " </div></span>\n" +
                            "<div style=\"text-align:center\">\n" +
                            " <span style=\"font-size:20px\"><strong>► 뉴욕타임스 칼럼 \"머스크가 위험한 이유가 궁금하면 미국 밖을 보라\"</strong></span><br><span>[ https://premium.sbs.co.kr/article/MBHvcnTWQL ]</span>\n" +
                            "</div>\n" +
                            "<div class=\"sbs_sub_heading\" style=\"border-bottom:1px solid #ebebeb; border-top:1px solid #444446; color:#3e3e40; line-height:1.5; margin-bottom:16px; margin-top:17px; padding-bottom:14px; padding-top:15px; position:relative\">\n" +
                            " <h4 class=\"sbs_sub_headingline\"><strong><span style=\"font-size:20px\">[그의 반쪽짜리 '언론의 자유']</span></strong></h4>\n" +
                            "</div><br>머스크가 트위터를 인수하겠다는 의향을 처음 밝혔을 때부터 '머스크의 트위터'는 미국 수정헌법 1조가 보장하는 언론의 자유(freedom of speech)를 오히려 침해할 거라고 우려하는 목소리가 있었습니다. 2019년 &lt;엘리트 독식 사회&gt;라는 책을 통해 부자들의 자선 사업에 담긴 위선을 꼬집었던 아난드 기리다라다스는 <u>지난 4월 뉴욕타임스에 쓴 칼럼<br><span>[ https://www.nytimes.com/2022/04/26/opinion/elon-musk-twitter.html ]</span></u>을 통해 \"트위터에 결함이 많지만, 그렇다고 머스크가 트위터를 인수하는 건 해법이 될 수 없다\"라고 단언했습니다.<br><br>머스크는 기존의 트위터가 언론의 자유를 충분히 보장하지 않고 있어서 문제라는 의견을 수 차례 밝혔습니다. 특정 세력이나 진영의 정치적 발언을 문제 삼고 검열한 것을 예로 들면서, 트럼프 전 대통령을 플랫폼에서 퇴출한 것을 대표적인 '잘못'으로 꼽았죠.<br><br>머스크가 생각하는 언론의 자유는 반쪽짜리 자유라서 문제입니다. 언론의 자유는 크게 소극적인 자유(negative freedom of speech)와 적극적인 자유(positive freedom of speech)로 나눌 수 있습니다. 권력에 의해 처벌받을 걱정 없이 하고 싶은 말을 할 수 있는 자유가 소극적인 자유라면, 누구나 생각하는 바를 자유롭게 말할 수 있는 환경을 갖추기 위한 노력은 적극적인 언론의 자유를 위한 일이라고 할 수 있습니다.<br><br>많은 사람은 언론의 자유에 관해 독재자나 권위주의 정권, 큰 정부나 빅 브라더의 검열을 먼저 떠올립니다. 이들은 소극적인 자유를 침해할 수 있는 분명한 위협이자, 민주주의의 적이 맞습니다. 그러나 적극적인 언론의 자유가 보장되지 않는 것도 심각한 문제입니다.<br><br>미국 수정헌법 1조가 언론의 자유를 보장하고 있다는 건 잘 알려진 사실이죠. 그런데 수정헌법 1조에서 말하는 언론의 자유는 소극적인 자유에 가깝습니다. 미국에서 여성이나 유색인종을 비롯한 소수자, 약자들은 자기 생각을 말했다가 감옥에 갈 걱정은 하지 않습니다. 대신 소수자들에게 말할 기회 자체가 처음부터 주어지지 않거나 박탈당하는 게 문제입니다. 이는 미국에 적극적인 언론의 자유가 보장돼 있지 않다는 뜻입니다.<br><br>일론 머스크는 자신과 테슬라를 비판한 블로거가 했던 테슬라의 주문을 <u>손수 취소해버린 적<br><span>[ https://www.theguardian.com/technology/2016/feb/03/elon-musk-blogger-tesla-motors-model-x ]</span></u>이 있습니다. 머스크를 비판했다가는 머스크의 열성적으로 따르는 팬들로부터 \"좌표가 찍혀\" 곤욕을 치를 수도 있죠.<br><br><u>팬데믹 초창기에 머스크는<br><span>[ https://www.latimes.com/business/story/2020-03-16/coronavirus-tesla-fremont-factory-musk ]</span></u> 필수 노동을 제외한 모든 이들에게 재택근무 지침을 내린 캘리포니아주 방역 당국에 대놓고 불만을 표시하며, \"코로나19를 둘러싼 호들갑이 지나치다. 확진자는 어차피 전체 인구의 0.1%도 넘지 않을 것\"이라고 말하기도 했었죠. 그러면서 전체 직원에게 보낸 이메일에서 \"몸이 안 좋은 직원들은 억지로 출근하지 않아도 되지만, 나는 상태 봐서 출근할 것\"이라고 썼습니다.<br><br>자유롭게 생각을 말할 수 있는 플랫폼 자체가 없던 시절에 비하면 소셜미디어의 등장은 분명 환영할 만한 일이었습니다. 그러나 소셜미디어가 혐오와 차별의 언어로 가득한 시궁창으로 변한다면, 이를 예방할 수 있는 자가 소셜미디어의 타락을 방치한다면, 이 또한 언론의 자유를 억압하는 기제가 될 뿐입니다. \"뭐든 자유롭게 말해도 좋지만, 뒷감당은 네가 알아서 하라\"는 세상은 언론의 자유가 보장된 세상이라고 하기 어렵습니다.<br><br>테슬라를 비판한다고 감옥에 갈 걱정은 안 해도 되니, 머스크가 그리는 세상은 언론의 자유가 보장된 곳이라고 할 수 있을까요? 그렇지 않습니다. 오히려 트위터가 트럼프를 퇴출하고, 온라인상의 혐오 발언과 가짜 뉴스를 걸러내기 위해 기울인 노력은 적극적인 언론의 자유를 보장하고자 노력했던 일이라고 볼 수 있습니다. 그런데 이를 언론 탄압으로 규정한 머스크가 트위터의 주인이 됐으니, 트위터의 행보를 향한 우려가 계속 나오는 겁니다.\n" +
                            "<div class=\"sbs_sub_heading\" style=\"border-bottom:1px solid #ebebeb; border-top:1px solid #444446; color:#3e3e40; line-height:1.5; margin-bottom:16px; margin-top:17px; padding-bottom:14px; padding-top:15px; position:relative\">\n" +
                            " <h4 class=\"sbs_sub_headingline\"><strong><span style=\"font-size:20px\">[중국과 너무 가까운 테슬라]</span></strong></h4>\n" +
                            "</div><br>테슬라와 중국의 '너무 가까운 관계'를 근거로 머스크의 트위터 인수를 우려하는 목소리도 있습니다. 복스(Vox)의 공동창업자인 매튜 이글레시아스(Matthew Yglesias)는 지난달 <u>자신의 블로그 슬로우보링(Slow Boring)에 쓴 글<br><span>[ https://www.slowboring.com/p/elon-musks-business-ties-deserve ]</span></u>에서 이 문제를 다뤘습니다.<br><br>이 세상의 내로라하는 제조업 브랜드 가운데 중국의 눈치를 보지 않아도 되는 브랜드는 많지 않습니다. 테슬라 만의 문제는 아닙니다. 애플tv+ 내규에는 \"중국을 부정적으로 묘사하는 콘텐츠는 내보낼 수 없다\"라는 규정이 있습니다. 애플tv를 통해 대만을 정상 국가로 묘사하는 내용이 방영된다거나 홍콩 민주화 시위, 신장 위구르 소수민족 인권 문제를 다룬 다큐멘터리가 나가기라도 한다면, 중국 정부는 곧바로 아이폰이나 맥북 생산 과정을 멈춰버릴지도 모릅니다.<br><br>메르세데스 벤츠는 2018년 브랜드 광고에 달라이 라마가 한 말을 인용했다가 중국 정부의 항의를 받자, 곧바로 사과하고 해당 문구를 삭제했습니다. \"다양한 관점에서 상황을 바라보면, 당신은 좀 더 열린 사람이 될 수 있다\"는, 중국과는 아무런 상관이 없는 말이었지만, 달라이 라마라는 인물 자체가 문제가 된 겁니다. 중국 정부는 거대한 중국 시장의 출입구를 강력히 통제하고 있습니다. 중국 정부의 요구에 굴복한 기업이나 유명 인사의 목록은 얼마든지 더 나열할 수 있습니다.<br><br>테슬라 매출에서 중국 시장이 차지하는 비중만 봐도 머스크가 중국 정부의 눈치를 보지 않을 수 없다는 걸 단박에 알 수 있습니다. 지난 2021년 1~8월 테슬라 매출을 보면 미국과 유럽이 각각 16%인데, 중국 시장에서 테슬라 매출이 미국과 유럽의 매출을 합한 32%에 달합니다.<br><br>오랫동안 해외 기업이 중국에 법인을 세우려면, 중국 자본이 소유한 회사와 합자회사를 세워야 했습니다. 그렇지 않으면 중국 시장에 진출할 길이 없었죠. 그런데 중국 정부가 이 규제를 완화한 덕분에 테슬라는 2019년 100% 자기 지분을 가진 중국 현지 법인을 세울 수 있었습니다. \"언론의 자유의 메시아\"를 자처하는 머스크가 왜 명백하게 언론의 자유가 전혀 보장되지 않은 중국의 상황에는 입을 다물고 있는지 짐작할 수 있는 대목입니다.<br><br>머스크가 중국에 관련해 아무런 말도 하지 않는 건 아닙니다. 오히려 그는 점점 더 중국 정부가 좋아할 만한 말만 골라서 하고 있죠. 최근에는 \"대만 사람들은 중국과 합병되는 걸 반길 것\"이라고 말해, 대만은 물론이고 미국 내에서도 엄청난 반발에 직면했습니다.<br><br><span class=\"end_photo_org\">\n" +
                            " <div class=\"nbd_im_w _LAZY_LOADING_WRAP is_small\">\n" +
                            "  <div class=\"nbd_a _LAZY_LOADING_ERROR_HIDE\" id=\"img_a3\"><img id=\"img3\" data-src=\"https://imgnews.pstatic.net/image/055/2022/12/21/0001022202_004_20221221152801347.png?type=w647\" class=\"_LAZY_LOADING\">\n" +
                            "  </div>\n" +
                            " </div></span><br><span>[ https://premium.sbs.co.kr/article/4giXGSbTLY ]</span><br>**'보러가기' 버튼이 눌리지 않으면 해당 주소를 주소창에 옮겨 붙여서 보실 수 있습니다.<p></p>\n" +
                            "          </div>\n" +
                            "        </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "<script src=\"../js/mailContent.js\"></script>\n" +
                            "\n" +
                            "\n" +
                            "</body></html>";


                    InternetAddress[] address = {new InternetAddress(to)};
                    Message message = new MimeMessage(sess);
                    message.setRecipients(Message.RecipientType.TO, address);
                    message.setFrom(new InternetAddress(from, "어시스톡"));
                    message.setSubject(subject);
                    message.setContent(content,"text/html;charset=UTF-8");
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


