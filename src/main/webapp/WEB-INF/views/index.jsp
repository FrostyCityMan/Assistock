<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-12-23
  Time: 오전 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html lang="ko">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="../js/jquery-3.6.1.min.js"></script>
    <script src="../js/jquery.cookie.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <link rel="stylesheet" href="../css/index.css">

    <title>당신의 투자를 위한
        의사결정 지원 플랫폼, 어시스톡</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="../images/Favi4.png"/>
</head>
<body>
<div class="flex-container">
    <div class="spinner">
        <p>
        <div class="cube1"></div>
        <div class="cube2"></div>
        Loading...
        </p>
    </div>
    <div class="flex-slide home" onclick="location.href='/home'">
            <div class="flex-title flex-title-home">Home
            </div>
        <div class="flex-title">
                <img class="assistockIcon" style="width:120px;" src="../images/home.png"/>
        </div>
            <div class="flex-about flex-about-home">
                <p>당신의 투자를 위한<br>
                    의사결정 지원 플랫폼, 어시스톡</p>
            </div>
    </div>
    <div class="flex-slide about" onclick="location.href='/about'">
        <div class="flex-title">About
        </div>
        <div class="flex-title">
            <img class="assistockIcon" style="width:120px;" src="../images/about.png"/>
        </div>
        <div class="flex-about">
            <p>어시스톡은 전 세계 수백만 명의 투자자로부터 신뢰받고 있습니다.</p></div>
    </div>
    <div class="flex-slide work" onclick="location.href='/Pricing'">
        <div class="flex-title">Pricing
        </div>
        <div class="flex-title">
            <img class="assistockIcon" style="width:120px;" src="../images/price.png"/>
        </div>
        <div class="flex-about">
            <p>어시스톡 구독하기.</p>
            <ul>
                <li>기본 키워드 분석 제공</li>
                <li>대시보드 제공</li>
                <li>무제한 주식 종목 추천</li>
            </ul>
        </div>
    </div>
    <div class="flex-slide contact">
        <div class="flex-title" onclick="location.href='/login'">Login
        </div>
        <div class="flex-title">
            <img class="assistockIcon" style="width:120px;" src="../images/login.png"/>
        </div>
<%--        <div class="flex-about">--%>
<%--            <form class="contact-form">--%>
<%--                <p>ID <input type="text" name="id" id="id"/></p>--%>
<%--                <p>Password <input type="password" name="password" id="password"/></p>--%>
<%--                <p><input type="submit" name="email" value="Login"></p>--%>
<%--            </form>--%>
<%--        </div>--%>
    </div>
</div>

<script src="../js/index.js"></script>

</body>
</html>
