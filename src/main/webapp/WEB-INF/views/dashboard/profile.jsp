<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-11-29
  Time: 오후 3:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../member/auth.jsp" %>

<%--<%@ include file="auth.jsp" %>--%>
<html>
<head>
    <script src="../js/jquery-3.6.1.min.js"></script>
    <script src="../js/jquery.cookie.js"></script>
    <link rel="stylesheet" href="../css/loginForm.css">
    <meta charset="UTF-8">
    <title>당신의 투자를 위한
        의사결정 지원 플랫폼, 어시스톡</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="../images/Favi4.png"/>
</head>
<body>

<div class="wrapper">
    <div class="sign-panels">
        <div class="login">
            <div class="title">
                <a href="/">
                    <img src="../images/Favi2.png">
                </a>
                <span>Profile</span>
                <p>어시스톡에 다시 오신 것을 환영해요! <br>
                    페이스북이나 네이버로도 로그인 할 수 있어요.</p>
            </div>

            <div>
                <a href="javascript:void(0)" class="btn-face"><i class="fa fa-facebook" aria-hidden="true"></i> Facebook</a>
                <a href="javascript:void(0)" class="btn-twitter" id="naverIdLogin_loginButton"><i class="fa fa-twitter"
                                                                                                  aria-hidden="true"></i>
                    Naver</a>
            </div>

            <div class="or"><span>OR</span></div>
<%--TODO 회원 테이블에 최종 비밀번호 변경일 추가.--%>
            <form name="Loginfrm"
                  id="Loginfrm" METHOD="POST" action="/login/proc">
                <input type="text" name="Id" id="Id" placeholder="아이디를 입력해주세요">
                <input type="password" name="PW" id="PW" placeholder="비밀번호를 입력해주세요">
                <span class="error"></span>
                <input type="checkbox" id="remember">
                <label for="remember">로그인 유지하기</label>
                <%--                <a href="javascript:void(0)" class="btn-signin">로그인</a>--%>
<%--                                <button class="btn-signin" onclick="loginInsert()">로그인</button>--%>
                <input type="button" value="로그인" id="btn-login" onkeydown="runlogin(e)" onclick="loginInsert()">
<%--                <a href="javascript:void(0)" class="btn-signin" onclick="loginInsert()"--%>
<%--                   tabindex="0">로그인</a>--%>
                <a href="javascript:void(0)" class="btn-reset btn-fade">아이디 및 비밀번호 찾기 <i
                        class="fa fa-long-arrow-right"
                        aria-hidden="true"></i></a>
                <a href="javascript:void(0)" class="btn-member btn-fade">아직 회원이 아니신가요? <i
                        class="fa fa-long-arrow-right"
                        aria-hidden="true"></i></a>
            </form>
            <div class="loginoti">
                <p>환영해요! <span class="login-name"></span> 로그인이 완료되었어요. </p>
            </div>
        </div>


<script src="../js/loginForm.js"></script>
<%--네이버 로그인--%>
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>

</body>
</html>