<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/res/import/zui/css/zui.min.css"/>">
<script type="text/javascript" src="<c:url value="/res/import/jquery/jquery-3.2.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/res/import/zui/js/zui.min.js"/>"></script>
<title>LOGIN</title>
</head>
<body>
<form action="login.do" method="post">       
    <p>
        <label for="username">Username</label>
        <input type="text" id="userAccount" name="userAccount"/>	
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" id="accPwd" name="accPwd"/>	
    </p>
    <input type="hidden" name="token" value=""/>
    <input type="checkbox" name="rememberMe">rememberMe
    <button type="submit" class="btn">Log in</button>
</form>
</body>
</html>