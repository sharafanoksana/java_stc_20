<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>birthday</th>
        <th>login</th>
        <th>city</th>
        <th>email</th>
        <th>description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="userPerson" items="${userPerson}">
        <tr>
            <td scope="row">${userPerson.id}</td>
            <td>${userPerson.name}</td>
            <td>${userPerson.birthday}</td>
            <td>${userPerson.login}</td>
            <td>${userPerson.city}</td>
            <td>${userPerson.email}</td>
            <td>${userPerson.description}</td>
            <td>
                <a href="${pageContext.request.contextPath}/showuser?id=${userPerson.id}">Link</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<a href="/users/">Main page</a>