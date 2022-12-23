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

<sql:query var="mailLoad" dataSource="${DS}">
    Select "MailOK"
    from "Member"
    where "ID" = ?
    <sql:param value="${sessionScope.ID}"/>
</sql:query>



<c:set var="now" value="<%=new java.util.Date()%>">

</c:set>
<c:set var="today">
    <fmt:formatDate value="${now}" pattern="yyyy-MM-dd(E)"/>
</c:set>