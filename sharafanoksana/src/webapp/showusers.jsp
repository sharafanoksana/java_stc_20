<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
<a href='allUsers'> <- Go back to UserPerson list</a>
<h2>${userPerson.userPerson}</h2>
<h3>params</h3>
<ul>
    <li>User id - ${userPerson.id}</li>
    <li>User name - ${userPerson.name}</li>
    <li>User date - ${userPerson.date}</li>.
    <li>User login - ${userPerson.login}</li>
    <li>User city - ${userPerson.city}</li>
    <li>User email - ${userPerson.email}</li>
    <li>User description - ${userPerson.description}</li>
</ul>
</body>
</html>
