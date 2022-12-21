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
<%@ include file="auth.jsp" %>

<%--<%@ include file="auth.jsp" %>--%>
<html>
<head>
    <script src="../js/jquery-3.6.1.min.js"></script>
    <script src="../js/jquery.cookie.js"></script>
    <link rel="stylesheet" href="../css/loginForm.css">
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>당신의 투자를 위한
        의사결정 지원 플랫폼, 어시스톡</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="../images/Favi4.png"/>
</head>
<body>

<%
    if (s_ID.equals("guest") || s_PW.equals("guest") || s_Class_Member.equals("guest")) {
        //아이디 저장 쿠키 확인 ----------------------------------------------------------
        Cookie[] cookies = request.getCookies();   //사용자PC에 저장된 모든 쿠키값 가져오기
        String c_id = "";
        if (cookies != null) {                  //쿠키가 존재하는지?
            for (int i = 0; i < cookies.length; i++) {   //모든 쿠키값을 검색
                Cookie cookie = cookies[i];         //쿠키 하나씩 가져오기
                if (cookie.getName().equals("c_id") == true) {    //쿠키이름(변수명)이 c_id인가요?
                    c_id = cookie.getValue();               //찾은 c_id의 값 가져오기
                }//if end
            }//for end
        }//if end
    }
    //--------------------------------------------------------------------------
%>
<div class="wrapper">
    <div class="sign-panels">
        <div class="login">
            <div class="title">

                <a href="/">
                    <img src="../images/Favi2.png">
                </a>
                <a href="/dashboard" class="dashlink">
                    <img src="../images/Favi2.png">
                </a>

                <span>Sign In</span>
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

            <form name="Loginfrm"
                  id="Loginfrm" METHOD="POST" action="/login/proc">
                <input type="text" name="Id" id="Id" placeholder="아이디를 입력해주세요">
                <input type="password" name="PW" id="PW" placeholder="비밀번호를 입력해주세요">
                <span class="error"></span>
                <input type="checkbox" id="remember" name="remember">
                <label for="remember">로그인 유지하기</label>
                <input type="button" value="로그인" id="btn-login" onkeydown="runlogin(e)" onclick="loginInsert()">
                <a href="javascript:void(0)" class="btn-reset btn-fade">아이디 및 비밀번호 찾기 <i
                        class="fa fa-long-arrow-right"
                        aria-hidden="true"></i></a>
                <a href="javascript:void(0)" class="btn-member btn-fade">아직 회원이 아니신가요? <i
                        class="fa fa-long-arrow-right"
                        aria-hidden="true"></i></a>
            </form>
            <div class="loginoti">
                <p>환영해요! <span class="login-name"></span> 님로그인이 완료되었어요. </p>
            </div>
        </div>

        <div class="signup">
            <div class="title">
                <a href="/">
                    <img src="../images/Favi2.png">
                </a>
                <span>Sign Up</span>
                <p>어시스톡에 처음 오신 것을 환영해요! <br>
                    페이스북이나 네이버로도 회원가입 할 수 있어요.</p>
            </div>

            <div>
                <a href="#" class="btn-face"><i class="fa fa-facebook" aria-hidden="true"></i> Facebook</a>
                <a href="#" class="btn-twitter"><i class="fa fa-twitter" aria-hidden="true"></i> Naver</a>
            </div>

            <div class="or"><span>OR</span></div>

            <form name="registerMember" id="registerMember" METHOD="post" onsubmit="return validateForm()">
                <span class="error"></span>
                <input type="hidden" name="Name_Register" value="어시스톡">
                <input type="hidden" name="Class_Member" value="회원">
                <input type="text" name="Regi_Id" id="Regi_Id" placeholder="아이디를 입력해주세요.">
                <input type="password" name="Regi_PW" id="Regi_PW" placeholder="비밀번호를 입력해주세요.">
                <input type="password" name="RePW" id="RePW" placeholder="비밀번호를 다시 입력해주세요.">
                <input type="text" name="Name_Member" id="Name_Member" placeholder="이름을 입력해주세요.">
                <input type="text" name="Email" id="Email" placeholder="이메일 주소를 입력해주세요.">
                <input type="text" name="Tel" id="Tel" placeholder="연락처를 '-'를 제외하고 입력해주세요">

                <a class="btn-register" onclick="memberInsert()">회원가입</a>
                <a href="javascript:void(0)" class="btn-login btn-fade">Already have an account, Sign In <i
                        class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
            </form>

            <div class="reginoti">

                <p>환영해요! <span class="regist-name"></span>님 회원가입이 완료되었어요. </p>
            </div>
        </div>

        <div class="recover-password">
            <div class="title">
                <a href="/">
                    <img src="../images/Favi2.png">
                </a>
                <span>아이디 및 비밀번호 찾기</span>
                <p>회원 가입시 입력하신 이메일 주소를 입력하시면, <br>
                    해당 이메일로 아이디 및 임시 비밀번호를 보내드릴게요!</p>
            </div>

            <form action="/login/findID" METHOD="post">
                <input type="email" placeholder="이메일 주소를 입력해주세요." id="resetPassword"
                       name="resetPassword" required>
                <span class="error"></span>
                <a onclick="findInsert()" class="btn-signin btn-password">계정 찾기</a>
                <%--                <button class="btn-signin btn-password">계정 찾기</button>--%>
                <a href="javascript:void(0)" class="btn-login btn-fade"><i class="fa fa-long-arrow-left"
                                                                           aria-hidden="true"></i> 취소하고 로그인 화면으로 돌아가기
                </a>
            </form>
            <div class="notification">
                <p>잘 하셨어요! <span class="reset-mail"></span>의 주소로 찾으시는 아이디와 임시 비밀번호를 발송 드렸어요. 확인 하시고 비밀번호를
                    변경해주세요. </p>
            </div>

        </div>
    </div>
</div>

<script src="../js/loginForm.js" charset="utf-8"></script>
<%--네이버 로그인--%>
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>

</body>
</html>