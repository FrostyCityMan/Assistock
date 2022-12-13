<%@ page import="utility.Utility" %><%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-12-01
  Time: 오후 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="ssi.jsp" %>
<%@ include file="/header.jsp" %>

<h3>* 로그인 결과 *</h3>
<%

    String id = request.getParameter("Id").trim();
    String passwd = request.getParameter("PW").trim();

    dto.setID(id);
    dto.setPW(passwd);
    dto = dao.login(dto);
    Map<String, String> map_login = new HashMap<>();
    map_login.put(dto.getID(), dto.getClass_Member());

    String Class_Member = map_login.get(id);
    if (Class_Member == null) {
        out.println("<p>아이디 또는 비밀번호가 일치하지 않습니다.");
        out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
    } else {
        //로그인 성공
        //out.print("로그인 성공!");
        //out.print("회원등급 : " + mlevel);

        //다른 페이지에서 로그인 상태 정보를 공유할 수 있도록
        session.setAttribute("s_ID", id);
        session.setAttribute("s_PW", passwd);
        session.setAttribute("s_Class_Member", Class_Member);

        //쿠키시작 --------------------------------------------------------
        //->웹서버가 사용자PC에 저장하는 텍스트 파일로 된 정보
        //->각 브라우저의 쿠키삭제의 영향을 받는다
        //->보안에 취약하다
        //->예)아이디저장, 오늘창그만보기, 클락한상품목록
        //->예)오늘창그만보기는 자바스크립트 쿠키. 참조)https://www.w3schools.com/js/js_cookies.asp

        //<input type="checkbox" name="c_id" value="SAVE">아이디 저장
        String c_id = Utility.checkNull(request.getParameter("c_id"));
        Cookie cookie = null;
        if (c_id.equals("SAVE")) {         //아이디저장에 체크를 했다면,
            //쿠키변수선언 new Cookie("변수명", 값)
            cookie = new Cookie("c_id", id);
            //쿠키의 생존기간
            cookie.setMaxAge(60 * 60 * 24 * 30);   //각 브라우저의 쿠키삭제의 영향을 받는다
        } else {
            cookie = new Cookie("c_id", "");
            cookie.setMaxAge(0);
        }//if end

        response.addCookie(cookie);         //요청한 사용자PC에 쿠키값을 저장
        //쿠키 끝 --------------------------------------------------------

        //첫페이지 이동
        //﻿http://localhost:9090/myweb/index.jsp
        String root = Utility.getRoot();   //myweb 반환
        response.sendRedirect("/login");

    }//if end
%>
<%@ include file="/footer.jsp" %>
