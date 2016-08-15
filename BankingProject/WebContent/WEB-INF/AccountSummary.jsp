<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

<title>Account Summary</title>
<style>

table{
	margin-left: 450px;
	margin-top:100px;
}
#navbar {
	background-color: #ccffff;
	padding:8px;
	
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
	<table class="table" style="width:400px">
		<thead>
		<tr>
			<th>Accounts</th>
			<th>Balance</th>
		</tr>
		</thead>
		<tbody>
		<tr class="info"> 
			<td>Checking Account Number: <s:property value="checkingAccountNumber"/></td>
			<td>$ <s:property value="checkingBalance"/></td> 
		</tr>
		<tr class="info"> 
			<td>Savings Account Number: <s:property value="savingsAccountNumber"/></td>
			<td>$ <s:property value="savingsBalance"/></td> 
		</tr>
		</tbody>
	</table>
</html>