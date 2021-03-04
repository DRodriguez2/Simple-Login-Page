<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<link href="css/basicStyling.css" rel="stylesheet" type="text/css">
<body>
	<form action="Register" method="post">
		<fieldset class="fieldset-auto-width">
			<legend>Register</legend>
			<p>
				Enter user name: <input type="text" name="username"><br>
				Enter password: <input type="password" name="password"><br>
				Re enter password: <input type="password" name="verify"><br>
				<input type="submit">
			</p>
		</fieldset>
	</form>
	<p>
		<a href="index.jsp">Login</a>
	</p>
	<br> 
	${result}

</body>
</html>