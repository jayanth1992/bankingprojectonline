<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Update Information</title>
<style>

 ul {
	list-style-type: none;
	overflow:hidden;
	border:2px solid black;
}

li {		
	box-sizing: border-box;
	float:left;
	width:20%;
}

#navbar {
	background-color: #ccffff;
	padding:8px;
	
}

.label {
	color:blue;
}

</style>

</head>
<body>

	<div id="navbar">
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-2"><a href="accountSummary">Account Summary</a></div>
		<div class="col-md-2"><a href="accountActivity">Account Activity</a></div>
		<div class="col-md-2"><a href="transfers">Transfers</a></div>
		<div class="col-md-2"><a href="updateInfo">Update Information</a></div>
		<div class="col-md-2"><a href="signoff">Sign Off</a> </div>
	</div>
	</div>
	
	<div class="well well-sm"> <h4>Edit and click "Update" to Update Information </h4> </div>
	<br/> 
	<div style="background-color: #ccffcc; margin-left:500px; padding:5px; width:330px">
	<s:form action="updateInfoOnClick">
		<s:textfield label="First Name" name="firstName" size="28" disabled="true" />
		<s:textfield label="Last Name" name="lastName" size="28" disabled="true"/>
		<s:textfield label="E-mail" name="email" size="28"/>
		<s:textfield label="Phone" name="phoneNumber" size="28"/>
		<s:textfield label="Address Line 1" name="addressLine1" size="28"/>
		<s:textfield label="Address Line 2" name="addressLine2" size="28"/>
		<s:textfield label="City" name="city" size="28"/>
		<s:textfield label="State" name="state " size="28"/>
		<s:textfield label="ZipCode" name="zip" size="28"/>
		<s:submit value="Update"/>
	</s:form>
	</div>	
</body>
</html>