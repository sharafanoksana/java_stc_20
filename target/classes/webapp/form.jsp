<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="userPerson" class="lesson15.entities.UserPerson" />
<%--<table cellspacing="5" cellpadding="5" border="1"></table>--%>
    <c:set target="${userPerson}" property="name" value="FIRST" />
    <jsp:setProperty name="userPerson" property="name" value="0" />

<h1>Adding a new student</h1>
<form method="post" action="${pageContext.request.contextPath}/adduser" autocomplete="off">
    <div class="form-group">
        <label for="name">Name</label>
        <input name="name" type="text" class="form-control" id="name" value="<jsp:getProperty name="userPerson" property="name" />">
    </div>
    <div class="form-group">
        <label for="birthday">Birthday</label>
        <input name="birthday" type="Date" class="form-control" id="birthday" value="<jsp:getProperty name="userPerson" property="birthday" />">
    </div>
    <div class="form-group">
        <label for="login">Login</label>
        <input name="login" type="text" class="form-control" id="login" value="<jsp:getProperty name="userPerson" property="login" />">
    </div>
    <div class="form-group">
        <label for="city">City</label>
        <input name="city" type="text" class="form-control" id="city" value="<jsp:getProperty name="userPerson" property="city" />">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input name="email" type="text" class="form-control" id="email" value="<jsp:getProperty name="userPerson" property="email" />">
    </div>
    <div class="form-group">
        <label for="description">Manufacturer</label>
        <input name="description" type="text" class="form-control" id="description" value="<jsp:getProperty name="userPerson" property="description" />">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
