<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-11-18
  Time: 오후 4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <%--    --%>

    <%--    --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="../js/jquery-3.6.1.min.js"></script>
    <script src="../js/jquery.cookie.js"></script>
    <link rel="stylesheet" as="style"
          href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.5/dist/web/static/pretendard-dynamic-subset.css">
    <link rel="stylesheet" href="../css/home.css">

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>당신의 투자를 위한
        의사결정 지원 플랫폼, 어시스톡</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="../images/Favi4.png"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <%--    <link href="../css/styles.css" rel="stylesheet"/>--%>
    <!--    anyChart -->


</head>
<body>
<sql:setDataSource
        var="DS"
        driver="oracle.jdbc.OracleDriver"
        url="jdbc:oracle:thin:@localhost:1521/xe"
        user="system"
        password="1234"
/>
<sql:query var="rs" dataSource="${DS}">
    SELECT (Trunc(TO_DATE("Date(Now)", 'YYYY-MM-DD HH24:MI:SS')) ) as "Date(Now)"
    FROM "Word(Analysis)"
    GROUP BY Trunc(TO_DATE("Date(Now)", 'YYYY-MM-DD HH24:MI:SS'))
    order by "Date(Now)" desc
</sql:query>
<%----%>

<%----%>
<!-- Responsive navbar-->

<!-- Page header with logo and tagline-->
<header>
    <div class="top-nav container">
        <div class="logo">
            <a href="/" style="color: white">
                <img src="../images/Favi.png" style="width: 40px; padding-right: 5px; margin-right: 5px;">A S S I S T O
                C K
            </a>
        </div>
        <ul>
            <li><a href="/home">Home</a></li>
            <li><a href="/Pricing">Pricing</a></li>
<%--            TODO about완성시 채워넣기--%>
            <li><a href="/">About</a></li>
            <%
                if (session.getAttribute("ID") == null) {
            %>
            <li><a href="/login">Login</a></li>
            <%} else {%>
            <li><a href="/dashboard"> <c:out value="${sessionScope.ID}"/></a></li>
            <li><a class="btn-logout" href="/home">Logout</a></li>
            <% }%>
        </ul>

    </div>


    <!-- end top-nav -->


    <div class="hero container" id="top-nv">
        <div class="hero-image">
            <img src="../images/loginLogo.png"
                 alt="hero image">
        </div>
        <div class="hero-copy" style=" margin: 0 auto; text-align: center;">
            <h1>당신의 투자를 위한<br>
                의사결정 지원 플랫폼, 어시스톡</h1>

            <div class="hero-buttons">
                <a href="/login" class="button button-white">가입하기</a>
                <a href="/Pricing" class="button button-white">구독하기</a>
            </div>
        </div> <!-- end hero-copy -->


    </div> <!-- end hero -->

</header>


<!-- Page content-->
<div class="featured-section">
    <div>
        <div class="intro-container">
            <p id="first-intro">
                내 모든 투자 결정을 한눈에 분석하고 한 곳에서 관리하세요.<br>
                이제껏 경험 못 했던 쉽고 편리한 투자 분석 서비스,<br>
                어시스톡과 함께라면 당신의 투자가 새로워질 거예요.
            </p>
        </div>

        <section class="et-hero-tabs">
            <div id="second-intro">
                <img src="../images/Favi2.png">
                <h1>사람과 세상,<br>
                    그 이상을 연결하는 어시스톡 <br>
                    실시간 무료로 즐겨보세요.</h1>
            </div>
            <div class="et-hero-tabs-container">
                <a class="et-hero-tab" href="#tab-es6">오늘의 키워드</a>
                <a class="et-hero-tab" href="#tab-flexbox">스코어 분석</a>
<%--                <a class="et-hero-tab" href="#tab-react">원자재 분석</a>--%>
                <a class="et-hero-tab" href="#tab-angular">대쉬보드</a>
                <a class="et-hero-tab" href="#tab-other">뉴스레터</a>
                <span class="et-hero-tab-slider"></span>
            </div>
        </section>

        <!-- Main -->
        <main class="et-main">
            <section class="et-slide" id="tab-es6">
                <div style="margin-bottom: 80px;">
                    <h2 style="color:#5271ff">
                        오늘의 키워드</h2>
                        <div style="font-size: 50px;
                         font-weight: 700;
                         line-height: 1.4;
color:black">
                            간편하게 확실하게 <br>
                        구독료는 평생 무료로, <br>
                        이런 분석 해보셨나요?
                        </div>
                </div>


                <h2 style="color:#5271ff; margin-left:5%; margin-bottom: 20px">무료 키워드 분석</h2>
                <div style="display: flex">
                    <div style="font-size: 35px;
                         font-weight: 700;
                         line-height: 1.4;
                         display: inline;
                        width:40%;
                        margin-left:5%;
                        color: #888888;" >
                        어시스톡 평생 무료분석으로 <br>
                        모두의 투자의 자유를 <br>
                    <h2>
                        매일 수집된 뉴스 내 주요 키워드 <br>
                        (인물, 기관, 장소 등)를 분석하여 보여드려요. <br>
                    </h2>
                    </div>

                    <div id="loader-wrapper">
                        <div id="loader"></div>
                        <div class="loader-section section-left"></div>
                        <div class="loader-section section-right"></div>
                    </div>
                    <div id="wordCloud">
                    </div>
                    <%--                time picker--%>

                    <div class="container-fluid timeline-container" style="    overflow: clip;">
                        <div class="row">
                            <div class="col-sm-1 d-none d-sm-block">
                                <div class="row">
                                    <div class="col-12 prev-btn">
                                        <span class="fa fa-angle-left"><</span>
                                    </div>
                                </div>
                            </div>

                            <div class="col-12 col-sm-10" style="width:80%">
                                <div >
                                    <div class="row timeline-list" >
                                        <c:forEach var="datelist" items="${rs.rows}">
                                            <c:forEach items="${datelist}" var="map" varStatus="status">
                                                <%--                                            실제 반복할 div--%>
                                                <div class="col-3 col-sm-2 col-lg-2 timeline-item"
                                                     id="datenum+${map.value}">

                                                    <a href="javascript:void(0)" class="datebutton"
                                                       onclick="document.getElementById('datelist').value=' <fmt:formatDate value='${map.value}' pattern='yyyy-MM-dd'/>'
                                                               "/>
                                                    <span class="d-block"><strong><fmt:formatDate value="${map.value}"
                                                                                                  pattern="E"/></strong></span>
                                                        <span class="d-block"><fmt:formatDate value="${map.value}"
                                                                                              pattern="MM-dd"/></span>
                                                    </a>
                                                </div>
                                                <%--                                            <li> <fmt:formatDate value="${map.value}" pattern="yyyy-MM-dd(E)"/></li>--%>

                                            </c:forEach>
                                        </c:forEach>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-1 d-none d-sm-block">
                                <div class="row">
                                    <div class="col-12 next-btn">
                                        <span class="fa fa-angle-right">></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <%--                time picker end------------------------------%>
                <form id="keywordFrm" style="display: block; text-align: center; margin-left:35%">
                    <input type="hidden" id="datelist" name="datelist">
                    <input type="radio" id="keyword_eco" value="경제" name="select_class"/>
                    경제
                    <input type="radio" id="keyword_world" value="세계" name="select_class"/>세계 <br><br>
                    <a id="btn-search" href="javascript:void(0)" onclick="search1()"
                       class="button button-black">찾기</a>
                </form>
                <a id="btn-research" href="javascript:void(0)" onclick="research1()"
                   style="display: block; text-align: center; width: 35%"
                   class="button button-black">다시
                    찾기</a>

            </section>
            <section class="et-slide" id="tab-flexbox">
                <div style="margin-bottom: 80px;">
                    <h2 style="color:#5271ff">
                        스코어 분석</h2>
                    <div style="font-size: 50px;
                         font-weight: 700;
                         line-height: 1.4;
color:black">
                        의사 결정의 첫 걸음, <br>
                        뉴스분석을 편하게 <br>
                        어시스톡에서 확인하세요.
                    </div>
                </div>

               <img src="https://static.toss.im/icons/png/4x/icon-credit-grade-up-2.png" alt="" style="width: 120px; margin-left: 93%">
                <div style="font-size: 28px;
    font-weight: 700;
    line-height: 1.5;
    color: rgb(51, 61, 75);
    margin-bottom: 10px;">긍정, 부정적 뉴스</div>
                <h2 style="color: rgb(107, 118, 132)">
                    매일 수집된 뉴스중 긍정, 부정적 뉴스를 <br>
                    분석하여 보여드려요. <br>
                </h2>
                <div id="keywordMax" style="text-align: right">
                </div>

            </section>
            <section class="et-slide" id="tab-react" style="padding-top: 40%">
                <div class="css-i198f4 e1q82xoo2"><span class="css-os8tek e1q82xoo1">꼭 필요했던 금융</span>
                    <div style="transform: translate3d(-67.1289%, 0px, 0px);" class="css-o4cwoz e1q82xoo0"></div>
                    <div style="transform: translate3d(67.1289%, 0px, 0px);" class="css-1mq85uf e1q82xoo0"></div>
                </div>

            <%--                <div id="keywordMax2">--%>
<%--                </div>--%>
            </section>
            <section class="et-slide" id="tab-angular">
                <div style="margin-top: 10px;">
                <h1 style="text-align: left">어시스톡으로 <br>
                나에게 딱 맞게</h1>
                </div>
                <img src="https://c0.wallpaperflare.com/preview/366/410/456/doors-choices-choose-open.jpg"
                     style="width:800px; margin: 25vh 60px 60px;">
                <div style="text-align: left;  margin-right: 50% ">
                <h1 >대시 보드</h1>
                <h3 style="    font-size: 20px;
    font-weight: 600;
    line-height: 1.5;
    color: #333d4b;">기업분석, 국가분석, 테마분석 <br>
                    그동안 매일 일일이 분석하느라 고생했어요 <br>
                    앞으로는 어시스톡에서 간단히 찾아볼 수 있어요</h3>
                </div>
            </section>
            <section class="et-slide" id="tab-other">
                <img src="https://wallpapercave.com/wp/wp3396925.jpg"
                     style="width:1000px; margin: 60px; ">
                <div style="display:flex;">
                    <div style="margin-right: 10vh">
                        <h1>뉴스레터</h1>
                        <h3 style="    font-size: 40px;
                            font-weight: 700;
                            line-height: 1.3;
                            color: #191f28;
                            margin-bottom: 5px;">
                            정기적으로 받아보세요
                        </h3>
                    </div>
                    <p style=" font-size: 20px;
                     font-weight: 600;
                     line-height: 1.5;
                     color: #333d4b;">
                        주가와 원자재의 공통점은 잘 사서, 잘 관리하고, 잘 팔아야 한다는 것.<br>
                        관심 있는 기업뉴스와 글로벌 뉴스 까지 <br>
                        모두 어시스톡 뉴스레터로 받아보세요.</p>
                </div>

            </section>
        </main>


    </div>
</div>
<!-- Footer-->
<footer class="site-footer">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-9">
                <h6>About</h6>
                <p class="text-justify">Assistock.co.kr 어시스톡 서비스는 종합일간지, 경제지, 지역일간지, 방송사 등과 같은 다양한
                    언론사로부터 수집한 뉴스로 구성된 통합 <i>데이터베이스에 빅데이터 분석 기술을 접목하여 만든 새로운 뉴스 분석</i>
                    서비스입니다. 어시스톡 서비스는 일회성으로 소모되는 뉴스 콘텐츠를 가치 있는 정보로 재사용할 수 있도록 최적의 분석
                    환경을 제공합니다. <br> <br>
                    <strong>(주)어시스톡</strong> <br>
                    06234 서울 강남구 테헤란로 124 4층<br/>
                    전화:02-0000-0000/ 연락처:010-9143-0000/ 대표자:김도훈<br/>

                </p>
            </div>

            <%--            <div class="col-xs-6 col-md-3">--%>
            <%--                <h6>Categories</h6>--%>
            <%--                <ul class="footer-links">--%>
            <%--                    <li><a href="http://scanfcode.com/category/c-language/">C</a></li>--%>
            <%--                    <li><a href="http://scanfcode.com/category/front-end-development/">UI Design</a></li>--%>
            <%--                    <li><a href="http://scanfcode.com/category/back-end-development/">PHP</a></li>--%>
            <%--                    <li><a href="http://scanfcode.com/category/java-programming-language/">Java</a></li>--%>
            <%--                    <li><a href="http://scanfcode.com/category/android/">Android</a></li>--%>
            <%--                    <li><a href="http://scanfcode.com/category/templates/">Templates</a></li>--%>
            <%--                </ul>--%>
            <%--            </div>--%>

            <div class="col-xs-6 col-md-3">
                <h6>Quick Links</h6>
                <ul class="footer-links">
                    <li><a href="/home">Home</a></li>
                    <li><a href="/Pricing">Pricing</a></li>
                    <li><a href="/about">About</a></li>
                    <li><a href="/login">Login</a></li>
                    <%--                    <li><a href="-">Sitemap</a></li>--%>
                </ul>
            </div>
        </div>
        <hr>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-sm-6 col-xs-12">
                <p class="copyright-text">Copyright &copy; 2022 All Rights Reserved by
                    <a href="#">Assistock</a>.
                </p>
            </div>

            <div class="col-md-4 col-sm-6 col-xs-12">
                <ul class="social-icons">
                    <li><a class="facebook" href="#"><i class="fa fa-facebook">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                             stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                             class="feather feather-home">
                            <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"/>
                            <polyline points="9 22 9 12 15 12 15 22"/>
                        </svg>
                    </i></a></li>

                </ul>
            </div>
        </div>
    </div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<%-- 워드 클라우드--%>
<script src="https://cdn.anychart.com/releases/8.11.0/js/anychart-core.min.js"></script>
<script src="https://cdn.anychart.com/releases/8.11.0/js/anychart-tag-cloud.min.js"></script>


<!-- Core theme JS-->
<script src="../js/scripts.js"></script>

</body>
</html>
