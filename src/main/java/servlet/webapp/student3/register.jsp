<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>student - register</title>
    <%--    <link rel="stylesheet" href="/style.css"/>--%>
    <style>
        table {
            width: 800px;
            border-collapse: collapse;
            border: 1px #ccc solid;
        }

        table tr {
            padding: 5px;
            border: 1px #ccc solid;
        }
    </style>
</head>
<body>
<h1>학생 등록</h1>
<%--<%--%>
<%--//    String action = request.getServletPath();--%>
<%--    String action = request.getServletPath()+".do";--%>
<%--%>--%>
<c:choose>
    <c:when test="${empty student}">
        <c:set var="action" value="/student/register.do" />
        <c:set var="method" value ="post"/>
    </c:when>
    <c:otherwise>
        <c:set var="action" value="/student/update.do" />
        <c:set var="method" value ="get"/>
    </c:otherwise>
</c:choose>

<form action = "${action}" method = "${method}">
    <table>
        <tr>
            <th>ID</th>
            <td><input type = "text" name = "id" value = "${student.id}" required/></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type = "text" name = "name" value = "${student.name}" required/></td>
        </tr>
        <tr>
            <th>성별</th>
            <input type="radio" name="gender" value="M" ${student.gender eq 'M' ? 'checked' : '' } />남
            <input type="radio" name="gender" value="M" ${student.gender eq 'F' ? 'checked' : '' } />여
        </tr>
        <tr>
            <th>나이</th>
            <td><input type = "text" name = "age" value = "${student.age}" required/></td>
        </tr>
    </table>
    <p>
        <button type = "submit">
            <c:choose>
                <c:when test="${empty student}">
                    등록
                </c:when>
                <c:otherwise>
                    수정
                </c:otherwise>
            </c:choose>
        </button>
    </p>
<%--    <input type="submit" value="Submit" />--%>
</form>
</body>
</html>