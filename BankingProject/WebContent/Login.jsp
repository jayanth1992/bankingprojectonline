<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="/struts-tags" prefix="s"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body> 
	<s:form action="login">
		<s:select label="Accounts"
					  name="selectedAccount"
					  list="#{'acc':'Account Summary', 'trans':'Transfers'}"/>
		<s:textfield label="Username" key="userName" id="username"/>
		<s:password label="Password" key="password"/>
		<s:checkbox label="Save Username" key="saveUserName"/>
		<s:submit value="Log In"/>
	</s:form>

<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	 var username = document.cookie.split("=")[1];
	 document.getElementById("username").value = username;
 })
</script>
</body>
</html>