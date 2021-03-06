<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h3>
	Add new user
</h3>
<h6 id="err" style="display: none;color: red;"></h6>
<input type="hidden" id="pageCtx" value="${pageContext.request.contextPath}">
<table id="userInputs">
	<tr>
		<td>Full name:</td>
		<td><input name="fullName" value="" /></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><input name="email" value="" /></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><input name="city" value="" /></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><input name="state" value="" /></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><input name="country" value="" /></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input name="password" type="password" value="" /></td>
	</tr>
	<tr>
		<td>Confirm password:</td>
		<td><input name="confirmPassword" type="password" value="" /></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td><input id="saveBttn" value="Save" type="button"></td>
	</tr>
</table>
<hr>
<h3>Existing users</h3>
<div id="allUsers"></div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/angular.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/jquery21.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/user.js"></script>
</html>
