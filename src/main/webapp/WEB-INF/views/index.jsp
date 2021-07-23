<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="/" method="post">
            <input type="text" name="text" placeholder="값 입력" value="크루엘라">
            <input type="submit" value="gogo">
        </form>
    </div>
    <div>
        <c:forEach var="i" items="${hrefList}" varStatus="status">
            <a href="<c:out value="${i}"></c:out>"><img src="${ImgList[status.index]}" width="500px" height="300px"><br>
                <c:out value="${writerList[status.index]}"></c:out>&nbsp;&nbsp;<c:out value="${cntList[status.index]}"></c:out><br>
                <c:out value="${titleList[status.index]}"></c:out>
            </a><br>

        </c:forEach>
    </div>
</body>
</html>
