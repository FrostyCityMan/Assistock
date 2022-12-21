<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%--

  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-12-21
  Time: 오전 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="../js/jquery-3.6.1.min.js"></script>
    <script src="../js/jquery.cookie.js"></script>
    <meta charset="UTF-8">

    <link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,700,900,400italic,700italic,900italic|Droid+Serif:400,700,400italic,700italic'
          rel='stylesheet' type='text/css'>
    <title>당신의 투자를 위한
        의사결정 지원 플랫폼, 어시스톡</title>
    <link rel="icon" type="image/x-icon" href="../images/Favi4.png"/>

</head>
<body>
<%--<img src="../images/logo.png"/>--%>

<%--스타일 ---------------------------%>
<%--style--%>
<style>
    body {
        font-family: 'Droid Serif', serif;
        font-size: 14px;
        color: #2f2f2f;
        background-color: #f9f7f1;
    }

    header {
        font-family: 'Playfair Display', serif;
        font-weight: 900;
        font-size: 80px;
        text-transform: uppercase;
        display: inline-block;
        line-height: 72px;
        margin-bottom: 20px;

    }

    a {
        text-decoration: none;
        color: inherit; /* 링크의 색상 제거 */
    }

    p {
        margin-top: 0;
        margin-bottom: 20px;
    }

    .head {
        text-align: center;
        position: relative;


    }

    .headerobjectswrapper {
    }

    .subhead {
        text-transform: uppercase;
        letter-spacing: 1px;
        border-bottom: 2px solid #2f2f2f;
        border-top: 2px solid #2f2f2f;
        padding: 12px 0 12px 0;

    }

    .subhead > div {
        display: inline-grid !important;
        flex: 1;
        box-sizing: border-box;
        padding: 8px;
        width: 25%;
    }

    .weatherforcastbox {
        position: relative;
        width: 12%;
        left: 10px;
        border: 3px double #2f2f2f;
        padding: 10px 15px 10px 15px;
        line-height: 20px;
        display: inline-block;
        margin: 0 50px 20px -360px;
    }

    .content {
        font-size: 0;
        line-height: 0;
        word-spacing: -.31em;
        display: inline-block;
        margin: 30px 2% 0 2%;


    }

    .collumns {

    }

    .collumn {
        font-size: 14px;
        line-height: 20px;
        width: 33.3%;
        display: inline-block;
        padding: 0 1% 0 1%;
        vertical-align: top;
        margin-bottom: 50px;
        transition: all .7s;
    }

    .collumn + .collumn {
        border-left: 1px solid #2f2f2f;
    }

    .collumn .headline {
        text-align: center;
        line-height: normal;
        font-family: 'Playfair Display', serif;
        display: block;
        margin: 0 auto;


    }

    .collumn .headline.hl1 {
        font-weight: 700;
        font-size: 30px;
        text-transform: uppercase;
        padding: 10px 0 10px 0;

    }
    .collumn .headline.hl4 {
        font-weight: 700;
        font-size: 12px;
        box-sizing: border-box;
        padding: 10px 0 10px 0;
    }

    .collumn .headline.hl4:before {
        border-top: 1px solid #2f2f2f;
        content: '';
        width: 100px;
        height: 7px;
        display: block;
        margin: 0 auto;
    }

    .collumn .headline.hl4:after {
        border-bottom: 1px solid #2f2f2f;
        content: '';
        width: 100px;
        height: 10px;
        display: block;
        margin: 0 auto;

    }

    .collumn .headline.hl5 {
        font-weight: 400;
        font-size: 42px;
        text-transform: uppercase;
        font-style: italic;
        box-sizing: border-box;
        padding: 10px 0 10px 0;
        overflow: hidden;
        white-space: normal;
        text-overflow: ellipsis;
        height: 18%;
    }

    .collumn .headline.hl6 {
        font-weight: 400;
        font-size: 18px;
        box-sizing: border-box;
        padding: 10px 0 10px 0;

    }

    .collumn .headline.hl6:before {
        border-top: 1px solid #2f2f2f;
        content: '';
        width: 100px;
        height: 7px;
        display: block;
        margin: 0 auto;
    }

    .collumn .headline.hl6:after {
        border-bottom: 1px solid #2f2f2f;
        content: '';
        width: 100px;
        height: 10px;
        display: block;
        margin: 0 auto;

    }

    .collumn .headline.hl7 {
        font-weight: 700;
        font-size: 12px;
        box-sizing: border-box;
        display: block;
        padding: 10px 0 10px 0;
    }

    .collumn .headline.hl8 {
        font-weight: 700;
        font-size: 12px;
        box-sizing: border-box;
        padding: 10px 0 10px 0;
    }

    .collumn .headline.hl9 {
        font-weight: 700;
        font-size: 12px;
        box-sizing: border-box;
        padding: 10px 0 10px 0;
    }

    .collumn .headline.hl10 {
        font-weight: 700;
        font-size: 12px;
        box-sizing: border-box;
        padding: 10px 0 10px 0;
    }

    .collumn .citation {
        font-family: 'Playfair Display', serif;
        font-size: 36px;
        line-height: 44px;
        /*font-style: italic;*/
        text-align: center;
        font-weight: 400;
        display: block;
        margin: 40px 0 40px 0;
        font-feature-settings: "liga", "dlig";

    }

    .collumn .citation:before {
        border-top: 1px solid #2f2f2f;
        content: '';
        width: 100px;
        height: 16px;
        display: block;
        margin: 0 auto;
    }

    .collumn .citation:after {
        border-bottom: 1px solid #2f2f2f;
        content: '';
        width: 100px;
        height: 16px;
        display: block;
        margin: 0 auto;
    }

    .collumn .figure {
        margin: 0 0 20px;
    }

    .collumn .figcaption {
        font-style: italic;
        font-size: 12px;
    }

    .media {
        -webkit-filter: sepia(80%) contrast(1) opacity(0.8);
        filter: sepia(80%) grayscale(1) contrast(1) opacity(0.8);
        mix-blend-mode: multiply;
        width: 100%;
    }

    /*________________________________________________________________________________________________________________________________*/
    /*MEDIAQUERIES*/
    @media only all and (max-width: 1300px) {
        .weatherforcastbox {
            display: none;
        }

    }

    @media only all and (max-width: 1200px) {
        .collumn {
            width: 31%;
        }

    }

    @media only all and (max-width: 900px) {
        .collumn {
            width: 47%;
        }

    }

    @media only all and (max-width: 600px) {
        .collumn {
            width: 100%;
        }

        .collumn + .collumn {
            border-left: none;
            border-bottom: 1px solid #2f2f2f;
        }

        header {
            max-width: 320px;
            font-size: 60px;
            line-height: 54px;
            overflow: hidden;
        }

    }
</style>
<c:if test="${empty sessionScope.ID}">
    <script>
        if (window.confirm("로그인이 되어있지 않습니다. 로그인을 먼저 해주세요.")) {
            window.location.href = '/login';
        }
    </script>
</c:if>

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

<sql:query dataSource="${DS}" var="result">
    SELECT TO_CHAR(avg("Score"),'0.000') AS avg_score
    FROM "Word(Analysis)"
    WHERE (Trunc(TO_DATE("Date(Now)", 'YYYY-MM-DD HH24:MI:SS'))) = TO_CHAR(CURRENT_DATE, 'yyyy-MM-dd')
</sql:query>

<sql:query var="class_item" dataSource="${DS}">
    SELECT "Class(Item)" AS Class_Item
    FROM "Class(Item)"
</sql:query>
<sql:query var="CustumKeywords" dataSource="${DS}">
    Select "Keywords","Class"
    from "CustumKeywords"
    where "ID" = ?
    <sql:param value="${sessionScope.ID}"/>
</sql:query>

<c:set var="now" value="<%=new java.util.Date()%>">

</c:set>
<c:set var="today">
    <fmt:formatDate value="${now}" pattern="yyyy-MM-dd(E)"/>
</c:set>


<%--본문--%>
<div class="head">
    <div class="headerobjectswrapper">
        <div class="weatherforcastbox">
            <%--            <img src="../images/Favi4.png" style="overflow:hidden"/>--%>
            <span style="font-style: italic;">
                <p>오늘 뉴스 평균 점수</p>
                <c:forEach var="row" items="${result.rows}">
                <c:out value="${row.avg_score}"/>점
            </c:forEach></span>
        </div>
        <header>The assistock</header>
    </div>


    <div class="subhead">
        <%--        TODO 호스팅되면 링크 바꾸기--%>
        <div class="issue"><a href="/">www.assistock.com</a></div>
        <div class="edition"><c:out value="${sessionScope.ID}"/>'s News</div>
        <div class="date"><c:out value="${today}"/></div>
    </div>

</div>
<div class="content">
    <div class="collumns" id="keywordNews">


    </div>
</div>





<%-- 스크립트--%>
<script src="../js/mailContent.js"></script>
</body>
</html>
