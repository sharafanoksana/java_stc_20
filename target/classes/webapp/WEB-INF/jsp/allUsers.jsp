<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h2>Users list</h2>

<c:forEach items="${users}" var="userPerson">
<a href='showusers?id=${userPerson.id}'>${userPerson.users}></a>
<p>
    </c:forEach>
</body>
</html>