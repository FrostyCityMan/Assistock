<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-12-06
  Time: 오전 10:35
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
    <title>당신의 투자를 위한
        의사결정 지원 플랫폼, 어시스톡</title>
    <link rel="icon" type="image/x-icon" href="../images/Favi4.png"/>

    <link href="../css/dashboard.css" rel="stylesheet"/>

</head>
<body>


<%--ID=null이면 login페이지로 이동--%>
<%@ include file="./jstlRepository.jsp" %>




<%--Modal--%>
<div id="my_modal">
    <div class="modal-header">
        <p>관심 키워드 관리</p>
        <a class="modal_close_btn">X</a>
    </div>
    <div class="modal-body">
        <div class="modal-info">
            <p>
                알림 설정을 하시면 관심키워드가 포함된 뉴스가 등록될 때 회원가입시 입력하신 메일주소로 알림을 보내드립니다. <br>
                관심 키워드는 최대 10개까지 등록 가능합니다. <br>
                메일은 평일 8시, 장 시작전에 발송됩니다. </p>



            <c:forEach var="row2" items="${mailLoad.rows}">
                <!-- Display the value of the "MailOK" column in the current row -->
                <c:set value="${row2.MailOK}"  var="mailcheck"/>
            </c:forEach>
        </div>
        <form>
            <input type="hidden" value="${sessionScope.ID}">
            <div class="modal-mail">
                <p>메일 알람 설정</p>

                <li class="tg-list-item">
                    <input class="tgl tgl-flat" id="cb4" type="checkbox" value="true"
                            <c:choose>
                                <c:when test="${mailcheck == 'O'}">checked</c:when>
                                <c:otherwise>unchecked</c:otherwise>
                            </c:choose> />
                    <label class="tgl-btn" for="cb4"></label>
                </li>

            </div>
            <div class="modal-search">
                <p>키워드 등록</p>


                <label for="search">업종 검색</label><br>
                <div class="search-wrapper">
                    <input class="input-class" type="hidden" id="item_class" value="업종">
                    <input class="search-input" type="text" placeholder="검색어를 입력하세요" id="search" name="search">
                    <a class="btn-search" id="btn-item_class">+ 키워드 추가</a>
                </div>
                <div id="suggestions">
                    <ul class="suggestions">
                        <!-- The list of suggestions will go here -->
                    </ul>
                </div>
                <%--end of 업종검색--%>
                <label for="search">종목 검색</label><br>
                <div class="search-wrapper">
                    <input class="input-class" type="hidden" id="stock_class" value="종목">
                    <input class="search-input" type="text" placeholder="검색어를 입력하세요" id="search2" name="search">
                    <a class="btn-search" id="btn-stock_class">+ 키워드 추가</a>
                </div>
                <div id="suggestions2">
                    <ul class="suggestions2">
                        <!-- The list of suggestions will go here -->
                    </ul>
                </div>
                <%--end of 종목 검색--%>
                <label for="search">국가 검색</label><br>
                <div class="search-wrapper">
                    <input class="input-class" type="hidden" id="country_class" value="국가">
                    <input class="search-input" type="text" placeholder="검색어를 입력하세요" id="search3" name="search">
                    <a class="btn-search" id="btn-country_class">+ 키워드 추가</a>
                </div>

                <div id="suggestions3">
                    <ul class="suggestions3">
                        <!-- The list of suggestions will go here -->
                    </ul>
                </div>
                <%--end of 나라검색--%>

            </div>
            <%--end of 키워드--%>

        </form>
    </div>
    <div class="modal-footer">
        <div class="keyword-table">
            <table class="table table-borderless" style="margin-bottom: 0;" id="keyword-table">
                <tr>
                    <th></th>
                    <th>
                        <span>구분</span>
                    </th>
                    <th>
                        <span>키워드</span>
                    </th>
                </tr>


                <c:forEach var="row" items="${CustumKeywords.rows}">
                    <tr>
                        <td>
                            <input type="checkbox" class="cb">
                        </td>
                        <input type="hidden" name="class" value="${row['Class']}">
                        <input type="hidden" name="value" value="${row['Keywords']}">
                        <td><c:out value="${row['Class']}"/></td>
                        <td><c:out value="${row['Keywords']}"/></td>
                    </tr>

                </c:forEach>
            </table>
        </div>
    </div>
    <a class="keyword-delete">삭제</a>
    <script>
        document.querySelector('.btn-search').addEventListener('click', function () {
            var searchInput = document.querySelector('.search-input').value;

            // Use AJAX or some other method to send the search input value to the server
            // and add a new row to the table with the search input value.
        });
    </script>

    <a class="button-search">저장</a>

</div>

<div class="app-container">
    <div class="app-header">
        <div class="app-header-left">
            <span class="app-icon"></span>
            <a href="/home"><p class="app-name">Assistock</p></a>
        </div>
        <div class="app-header-right">
            <button class="mode-switch" title="Switch Theme">
                <svg class="moon" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                     stroke-width="2" width="24" height="24" viewBox="0 0 24 24">
                    <defs></defs>
                    <path d="M21 12.79A9 9 0 1111.21 3 7 7 0 0021 12.79z"></path>
                </svg>
            </button>
            <%--            <button class="add-btn" title="Add New Project">--%>
            <%--                <svg class="btn-icon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24"--%>
            <%--                     fill="none" stroke="currentColor" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"--%>
            <%--                >--%>
            <%--                    &lt;%&ndash;                     class="feather feather-plus">&ndash;%&gt;--%>
            <%--                    <line x1="12" y1="5" x2="12" y2="19"/>--%>
            <%--                    <line x1="5" y1="12" x2="19" y2="12"/>--%>
            <%--                </svg>--%>
            <%--            </button>--%>
            <button class="notification-btn">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                     stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                     class="feather feather-bell">
                    <path d="M18 8A6 6 0 0 0 6 8c0 7-3 9-3 9h18s-3-2-3-9"/>
                    <path d="M13.73 21a2 2 0 0 1-3.46 0"/>
                </svg>
            </button>
            <button class="profile-btn" id="popup_open_btn">
             <span>
                <c:out value="${sessionScope.ID}"/>
            </span>
            </button>
        </div>
        <button class="messages-btn">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none"
                 stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                 class="feather feather-message-circle">
                <path d="M21 11.5a8.38 8.38 0 0 1-.9 3.8 8.5 8.5 0 0 1-7.6 4.7 8.38 8.38 0 0 1-3.8-.9L3 21l1.9-5.7a8.38 8.38 0 0 1-.9-3.8 8.5 8.5 0 0 1 4.7-7.6 8.38 8.38 0 0 1 3.8-.9h.5a8.48 8.48 0 0 1 8 8v.5z"/>
            </svg>
        </button>
    </div>
    <div class="app-content">
        <div class="app-sidebar">
            <a href="" class="app-sidebar-link active">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                     stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                     class="feather feather-home">
                    <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"/>
                    <polyline points="9 22 9 12 15 12 15 22"/>
                </svg>
            </a>
            <%--            class="link-icon"--%>
            <%--            <a href="" class="app-sidebar-link">--%>
            <%--                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none"--%>
            <%--                     stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"--%>
            <%--                     class="feather feather-pie-chart" viewBox="0 0 24 24">--%>
            <%--                    <defs/>--%>
            <%--                    <path d="M21.21 15.89A10 10 0 118 2.83M22 12A10 10 0 0012 2v10z"/>--%>
            <%--                </svg>--%>
            <%--            </a>--%>
            <%--            <a href="" class="app-sidebar-link">--%>
            <%--                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"--%>
            <%--                     stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"--%>
            <%--                     class="feather feather-calendar">--%>
            <%--                    <rect x="3" y="4" width="18" height="18" rx="2" ry="2"/>--%>
            <%--                    <line x1="16" y1="2" x2="16" y2="6"/>--%>
            <%--                    <line x1="8" y1="2" x2="8" y2="6"/>--%>
            <%--                    <line x1="3" y1="10" x2="21" y2="10"/>--%>
            <%--                </svg>--%>
            <%--            </a>--%>
            <%--            class="link-icon"--%>
            <a href="" class="app-sidebar-link">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none"
                     stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                     class="feather feather-settings" viewBox="0 0 24 24">
                    <defs/>
                    <circle cx="12" cy="12" r="3"/>
                    <path d="M19.4 15a1.65 1.65 0 00.33 1.82l.06.06a2 2 0 010 2.83 2 2 0 01-2.83 0l-.06-.06a1.65 1.65 0 00-1.82-.33 1.65 1.65 0 00-1 1.51V21a2 2 0 01-2 2 2 2 0 01-2-2v-.09A1.65 1.65 0 009 19.4a1.65 1.65 0 00-1.82.33l-.06.06a2 2 0 01-2.83 0 2 2 0 010-2.83l.06-.06a1.65 1.65 0 00.33-1.82 1.65 1.65 0 00-1.51-1H3a2 2 0 01-2-2 2 2 0 012-2h.09A1.65 1.65 0 004.6 9a1.65 1.65 0 00-.33-1.82l-.06-.06a2 2 0 010-2.83 2 2 0 012.83 0l.06.06a1.65 1.65 0 001.82.33H9a1.65 1.65 0 001-1.51V3a2 2 0 012-2 2 2 0 012 2v.09a1.65 1.65 0 001 1.51 1.65 1.65 0 001.82-.33l.06-.06a2 2 0 012.83 0 2 2 0 010 2.83l-.06.06a1.65 1.65 0 00-.33 1.82V9a1.65 1.65 0 001.51 1H21a2 2 0 012 2 2 2 0 01-2 2h-.09a1.65 1.65 0 00-1.51 1z"/>
                </svg>
            </a>
        </div>
        <%--        프로젝트 섹션--%>


        <div class="projects-section" id="project-section">


            <div class="projects-section-header">
                <p>오늘 수집 현황</p>
                <%-- Assume that the response object is stored in a variable named "responseData" --%>
                <c:forEach items="${response}" var="item">
                    <%-- Access the url_Now property of the item object using the EL expression ${item.url_Now} --%>
                    <c:out value="${item.url_Now}"/><br>
                </c:forEach>
            </div>
            <div class="projects-section-line">
                <div class="projects-status">
                    <div class="item-status">
                        <span class="status-number"><c:out value="${today}"/></span>
                        <span class="status-type">Today</span>
                    </div>
                    <div class="item-status">
                        <span class="status-number">
                            <c:forEach var="row" items="${result.rows}">
                                <c:out value="${row.avg_score}"/>점
                            </c:forEach>
                        </span>
                        <span class="status-type">Score Avg</span>
                    </div>
                    <div class="item-status">
                        <span class="status-number" id="todayNewsCount"></span>
                        <span class="status-type">Total News</span>
                    </div>
                </div>
                <div class="view-actions">
                    <%--                    <button class="view-btn list-view" title="List View">--%>
                    <%--                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"--%>
                    <%--                             stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"--%>
                    <%--                             class="feather feather-list">--%>
                    <%--                            <line x1="8" y1="6" x2="21" y2="6"/>--%>
                    <%--                            <line x1="8" y1="12" x2="21" y2="12"/>--%>
                    <%--                            <line x1="8" y1="18" x2="21" y2="18"/>--%>
                    <%--                            <line x1="3" y1="6" x2="3.01" y2="6"/>--%>
                    <%--                            <line x1="3" y1="12" x2="3.01" y2="12"/>--%>
                    <%--                            <line x1="3" y1="18" x2="3.01" y2="18"/>--%>
                    <%--                        </svg>--%>
                    <%--                    </button>--%>
                    <button class="view-btn grid-view active" title="Grid View">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none"
                             stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                             class="feather feather-grid">
                            <rect x="3" y="3" width="7" height="7"/>
                            <rect x="14" y="3" width="7" height="7"/>
                            <rect x="14" y="14" width="7" height="7"/>
                            <rect x="3" y="14" width="7" height="7"/>
                        </svg>
                    </button>
                </div>
            </div>
            <div class="container-fluid timeline-container">
                <div class="row">
                    <div class="col-sm-1 d-none d-sm-block">
                        <div class="row">
                            <div class="col-12 prev-btn">
                                <span class="fa fa-angle-left"><</span>
                            </div>
                        </div>
                    </div>
                    <%--                time picker--%>

                    <div class="col-12 col-sm-10">
                        <div>
                            <div class="row timeline-list">
                                <c:forEach var="datelist" items="${rs.rows}">
                                    <c:forEach items="${datelist}" var="map" varStatus="status">
                                        <%--                                            실제 반복할 div--%>
                                        <div class="col-3 col-sm-2 col-lg-1 timeline-item"
                                             id="datenum+${map.value}">

                                            <a href="javascript:void(0)" class="datebutton"
                                               onclick="document.getElementById('datelist').value='<fmt:formatDate
                                                       value='${map.value}' pattern='yyyy-MM-dd'/>'">

                                                               <span class="d-block"><strong><fmt:formatDate
                                                                       value="${map.value}"
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

            <%--            WordCloud--%>
            <div class="project-boxes jsGridView">
                <div class="project-box-wrapper" style="width: 100%">
                    <div class="project-box" style="background-color: #fee4cb;">
                        <div class="project-box-header">
                            <span id="worddate"></span>
                            <div class="more-wrapper">
                                <button class="project-btn-more">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                         fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                         stroke-linejoin="round" class="feather feather-more-vertical">
                                        <circle cx="12" cy="12" r="1"/>
                                        <circle cx="12" cy="5" r="1"/>
                                        <circle cx="12" cy="19" r="1"/>
                                    </svg>
                                </button>
                            </div>
                        </div>
                        <div class="project-box-content-header" style="position: center">
                            <p class="box-content-header" style="font-size: 18px;">키워드 클라우드</p>
                            <div id="loader-wrapper">
                                <div id="loader"></div>
                                <div class="loader-section section-left"></div>
                                <div class="loader-section section-right"></div>
                            </div>
                            <div id="wordCloud">
                            </div>

                            <form id="keywordFrm">
                                <input type="hidden" id="datelist" name="datelist">
                                <input type="radio" id="keyword_eco" value="경제" name="select_class"/>경제
                                <input type="radio" id="keyword_world" value="세계" name="select_class"/>세계 <br><br>
                                <a id="btn-search" href="javascript:void(0)" onclick="search1()"
                                   class="button button-black">찾기</a>
                            </form>
                            <br>
                            <a id="btn-research" href="javascript:void(0)" onclick="research1()"
                               class="button button-black">다시
                                찾기</a>
                        </div>
                    </div>
                </div>

                <%--키워드 별 뉴스 -------------------------------------%>
                <div id="keywordNews" class="project-boxes jsGridView" style="width:100%">

                </div>

            </div>
            <%--            섹션 종료--%>
        </div>
    </div>
</div>

<%-- 워드 클라우드--%>
<script src="https://cdn.anychart.com/releases/8.11.0/js/anychart-core.min.js"></script>
<script src="https://cdn.anychart.com/releases/8.11.0/js/anychart-tag-cloud.min.js"></script>

<script src="../js/dashboard.js"></script>
</body>
</html>
