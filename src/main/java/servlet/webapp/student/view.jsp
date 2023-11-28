<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="cfmt" uri="http://nhnacademy.com/cfmt" %>--%>
<html>
<head>
    <title>학생-조회</title>
    <link rel="stylesheet" href="/style.css"/>
</head>
<body>
<table>
    <!-- todo view 구현 -->
    <tbody>
    <tr>
        <th>ID</th>
        <td style="text-align: center">${student.id}</td>
    </tr>
    <tr>
        <th>이름</th>
        <td style="text-align: center">${student.name}</td>
    </tr>
    <tr>
        <th>성별</th>
        <td style="text-align: center" name="id">${student.gender}</td>
    </tr>
    <tr>
        <th>나이</th>
        <td style="text-align: center" name="id">${student.age}</td>
    </tr>
    <tr>
        <th>등록일</th>
        <td style="text-align: center" name="id">${student.createdAt}</td>
    </tr>
    </tbody>
</table>
<ul>
    <li>
        <a href="/student/list">리스트</a>
    </li>
    <li>
        <!-- todo ${update_link} 설정 c:url -->
        <c:url var="redirectURL" value="/student/update"></c:url>
        <a href="${redirectURL}">수정</a>
        <%--        <c:url var="redirectURL" value="/student/register">--%>
        <%--        </c:url>--%>
        <%--        redirect test url is ${redirectURL}--%>
        <%--        <c:redirect url="${redirectURL}}"/>--%>
    </li>
    <li>
        <!-- todo 삭제버튼 구현, method=post -->
        <form action="/student/delete" method="post">
            <input type="hidden" name = "id" value = "${student.id}">
            <button type="submit">삭제</button>
        </form>
    </li>
</ul>
</body>
</html>