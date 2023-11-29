<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>student - list</title>
    <link rel="stylesheet" href="/style.css"/>
</head>
<body>
<h1>학생 리스트</h1>
<p><a href="/student/register"> 학생(등록)</a></p>
<table>
    <thead>
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>성별</th>
        <th>나이</th>
        <th>cmd</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${studentList}">
        <tr>
            <td style="text-align: center">${item.id}</td>
            <td style="text-align: center">${item.name}</td>
            <td style="text-align: center">${item.gender}</td>
            <td style="text-align: center">${item.age}</td>
            <td style="text-align: center"><a href="/student/view?id=${item.id}">조회</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>



