var details;

$(document).ready(function(){
	$.ajax({
	url: "accountActivity/getTransactions.action",
	success : function checking(data){
		details=data;
		document.getElementById("accountName").innerHTML = "<h4>Showing <u>Checking</u> Account</h4>";
		document.getElementById("accountBalance").innerHTML = "<h4>Available Balance: $<u>"+details.checkingBalance+"</u></h4>"
		document.getElementById("toDisplay").innerHTML="";
		document.getElementById("toDisplay").innerHTML="<tr>"+
														"<thead>"+
																"<th>Date</th>"+
																"<th>Description</th>"+
																"<th>Amount</th>"+
														"</thead>"
														"</tr>"+
														"<tbody>";

		
		for(var i=0;i<details.checkingTransactions.length;i++ ){
			document.getElementById("toDisplay").innerHTML += "<tr class='success'>"+
															"<td>"+details.checkingTransactions[i][0].split("T")[0]+"</td>"+
															"<td>"+details.checkingTransactions[i][1]+"</td>"+
															"<td> $"+details.checkingTransactions[i][2]+"</td>"+
															"</tr>";
			} 
		}
	}); // ajax closed
}) // ready closed

function jsfunction(){
	if(document.getElementById("selectedTag").value == "01"){
		document.getElementById("accountName").innerHTML = "<h4>Showing <u>Checking</u> Account</h4>";
		document.getElementById("accountBalance").innerHTML = "<h4>Available Balance: $"+details.checkingBalance+"</h4>"
		document.getElementById("toDisplay").innerHTML="";
		document.getElementById("toDisplay").innerHTML="<tr>"+
														"<thead>"+
																"<th>Date</th>"+
																"<th>Description</th>"+
																"<th>Amount</th>"+
														"</thead>"
														"</tr>"+
														"<tbody>";

		
		for(var i=0;i<details.checkingTransactions.length;i++ ){
			document.getElementById("toDisplay").innerHTML += "<tr class='success'>"+
															"<td>"+details.checkingTransactions[i][0].split("T")[0]+"</td>"+
															"<td>"+details.checkingTransactions[i][1]+"</td>"+
															"<td> $"+details.checkingTransactions[i][2]+"</td>"+
															"</tr>";
		} 
	} 
	

	if(document.getElementById("selectedTag").value == "02"){
		document.getElementById("accountName").innerHTML = "<h4>Showing <u>Savings</u> Account</h4>";
		document.getElementById("accountBalance").innerHTML = "<h4>Available Balance: $<u>"+details.savingsBalance+"</u></h4>"
		document.getElementById("toDisplay").innerHTML="";
		document.getElementById("toDisplay").innerHTML="<tr>"+
														"<thead>"+
																"<th>Date</th>"+
																"<th>Description</th>"+
																"<th>Amount</th>"+
														"</thead>"
														"</tr>"+
														"<tbody>";

		
		for(var i=0;i<details.checkingTransactions.length;i++ ){
			document.getElementById("toDisplay").innerHTML += "<tr class='success'>"+
															"<td>"+details.savingsTransactions[i].datemodified.split("T")[0]+"</td>"+
															"<td>"+details.savingsTransactions[i].description+"</td>"+
															"<td> $"+details.savingsTransactions[i].depositAmount+"</td>"+
															"</tr>";
		} 
	}
}
