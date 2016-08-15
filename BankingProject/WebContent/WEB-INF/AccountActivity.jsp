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
<title>Account Activity</title>
<style>


table {
	margin-left: 400px;
}

#accountNavigation {
	float:left;
	margin-left: 5px;
}

#info {
	background-color:#ccffcc;
	width:230px;
	margin-left:450px;
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
	<br>
	<div>
	<s:select  	 label="    "
				 name="accounts"
				 list="#{'01':'Checking Account', '02':'Savings Account'}" 
				 value="Checking" id="selectedTag"/>
				 
	<button id="accountNavigation" onclick="jsfunction()">Go</button> <br>
	</div>
	<br><br>
	<div id="info">
		<p id="accountName"></p>
		<p id="accountBalance"></p>
	</div>
	<br>
	
	<table id="toDisplay" class="table table-condensed" style="width:600px">
	
	</tbody>	
	</table>
	
<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script src="scripts/js1.js"> 
</script>
</body>
</html>