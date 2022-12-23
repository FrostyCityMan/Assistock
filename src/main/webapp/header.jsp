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

        <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>당신의 투자를 위한
        의사결정 지원 플랫폼, 어시스톡</title>
    <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="../images/Favi4.png"/>

    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../css/header.css" rel="stylesheet"/>
    <script src="https://cdn.anychart.com/releases/v8/js/anychart-base.min.js"></script>
    <script src="https://cdn.anychart.com/releases/v8/js/anychart-tag-cloud.min.js"></script>


</head>
<body>

<%----%>

<%----%>
<!-- Responsive navbar-->
<header>
<div style="background-color: #5271ff;">
    <div class="top-nav container">
        <div class="logo" >
            <a href="/home" style="color: white">
                <img src="../images/Favi.png" style="width: 40px; padding-right: 5px; margin-right: 5px;">A S S I S T O C K
            </a>
        </div>
        <ul id="header">
            <li><a href="/home">Home</a></li>
            <li><a href="/Pricing">Pricing</a></li>
            <li><a href="/about">About</a></li>
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
</div>
</header>