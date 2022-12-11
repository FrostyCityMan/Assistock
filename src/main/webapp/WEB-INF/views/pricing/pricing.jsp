<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-11-21
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/header.jsp" %>
<%-- 본문시작 credit.jsp--%>
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="check" viewBox="0 0 16 16">
        <title>Check</title>
        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"></path>
    </symbol>
</svg>

<link rel="stylesheet" href="../css/pricing.css">

<div class="pricing-container py-3">

    <div class="background">
        <div class="pricing-container">
            <div class="panel pricing-table">

                <div class="pricing-plan row">
                    <img src="https://s22.postimg.cc/8mv5gn7w1/paper-plane.png" alt="" class="pricing-img">
                    <h2 class="pricing-header">Guest</h2>
                    <ul class="pricing-features">
                        <li class="pricing-features-item">기본 키워드 분석 제공</li>
                    </ul>
                    <span class="pricing-price">Free</span>
                    <a href="http://192.168.14.24:9095/" class="pricing-button">Try it</a>
                </div>


                <div class="pricing-plan row">
                    <img src="https://s28.postimg.cc/ju5bnc3x9/plane.png" alt="" class="pricing-img">
                    <h2 class="pricing-header">Member</h2>
                    <ul class="pricing-features">
                        <li class="pricing-features-item">기본 키워드 분석 제공</li>
                        <li class="pricing-features-item">대시보드 제공</li>
                        <li class="pricing-features-item">무제한 주식 종목 추천</li>
                    </ul>
                    <span class="pricing-price">$150</span>
                    <a href="http://192.168.14.24:9095/credit" class="pricing-button is-featured">Sign up</a>
                </div>

                <div class="pricing-plan row">
                    <img src="https://s21.postimg.cc/tpm0cge4n/space-ship.png" alt="" class="pricing-img">
                    <h2 class="pricing-header">Super Member</h2>
                    <ul class="pricing-features">
                        <li class="pricing-features-item">기본 키워드 분석 제공</li>
                        <li class="pricing-features-item">대시보드 제공</li>
                        <li class="pricing-features-item">무제한 주식 종목 추천</li>
                        <li class="pricing-features-item">메일 또는 문자로 종목<br> 분석 알림</li>
                    </ul>
                    <span class="pricing-price">$400</span>
                    <a href="#/" class="pricing-button">Free trial</a>
                </div>

            </div>
        </div>
    </div>


</div>
<%-- 본문끝--%>
<%@ include file="/footer.jsp" %>
