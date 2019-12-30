<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="/webapp/WEB-INF/date.tld" prefix="datetag" %>
<%@taglib prefix="myTags" tagdir="/webapp/WEB-INF/tags" %>

<myTags:template>
    <jsp:attribute name="header">
        <h1>Users</h1>
        (<datetag:DateTag plus="1"/>)
    </jsp:attribute>
    <jsp:body>
        <ul>
            <li><a href="${pageContext.request.contextPath}/allusers">List users</a></li>
            <li><a href="${pageContext.request.contextPath}/adduser">Add userPerson</a></li>
        </ul>
    </jsp:body>
</myTags:template>

