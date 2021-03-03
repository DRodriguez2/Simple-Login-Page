<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<link href="css/basicStyling.css" rel="stylesheet" type="text/css">
<body>
	<form action="Login" method="post">
		<fieldset class="fieldset-auto-width">
			<legend>User Login</legend>
			<p>
				User name: <input type="text" name="username"><br>
				Password: <input type="password" name="password"><br>
				<input type="submit">
			</p>
		</fieldset>
	</form>
	<c:if test="${loginResult != null}">
			${loginResult}
	</c:if>

</body>
</html>
