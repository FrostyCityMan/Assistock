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
<html lang="ko">

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



    <link rel="stylesheet" href="../css/mailContetnt.css">

</head>
<body>
<%

    request.setCharacterEncoding("utf-8");

    String pagefile = request.getParameter("page");

//리퀘스트로 위에 넘긴 Get방식의 파라미터명을 써서 내용을 받는다.

%>

<%--<img src="../images/logo.png"/>--%>
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
        <div class="date"><%out.print(pagefile);%></div>
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


