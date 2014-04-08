<#-- @ftlvariable name="" type="com.brahma.loganalyzer.views.LogFileDetailView" -->
<!DOCTYPE HTML>
<html>
	<head>
		<title>Log Analyzer Application</title>
		<link href="//datatables.net/download/build/nightly/jquery.dataTables.css" rel="stylesheet" type="text/css" />
		<link href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/redmond/jquery-ui.css" rel="stylesheet" type="text/css" />
		<link href="/assets/css/loganalyzer.css" rel="stylesheet" type="text/css" />

		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
		<script src="//datatables.net/download/build/nightly/jquery.dataTables.js"></script>
		
		<meta charset=utf-8 />
		<script>
			$(document).ready( function () {
  				$('#log-file-detail').dataTable();
			} );
		</script>
	</head>
	<body id="home">
		<#include "header.ftl">
		<div id="nav-container">
			<div id="nav-options">
				<a href="/loganalyzer/${logFile.logID}/results-summary"><< Back to summary page</a>
			</div>
			<div id="nav-title">
				<h2>Contents of: ${logFile.logFileName?html}  (logID: ${logFile.logID?html})</h2>
			</div>
		</div>
		<div id="summary-container">
			<div><em>Total Number of log entries: <strong>${logFile.lineCount?html}</strong></em></div>
			<div><em>Total Unique IP Addresses: <strong>${logFile.uniqueIPAddressCount?html}</strong></em></div>
		</div>
		<div id="main-container">
			<table class="display" id="log-file-detail">
				<thead>
					<tr>
						<th>Origin IP Address</th>
						<th>User Identifier</th>
						<th>Auth User</th>
						<th>Log Date</th>
						<th>Log Time</th>
						<th>Time Zone</th>
						<th>Method</th>
						<th>Resource</th>
						<th>Protocol</th>
						<th>Status Code</th>
						<th>Response Size</th>
						<th>Client Info</th>
					</tr>	
				</thead>
				<tbody>
					<#list logFile.logEntries?if_exists as logs>
						<tr>
							<td>${logs.originIPAddress?html}</td>
							<td>${logs.userIdentifier?html}</td>
							<td>${logs.authUser?html}</td>
							<td>${logs.logDate?html}</td>
							<td>${logs.logTime?html}</td>
							<td>${logs.timeZone?html}</td>
							<td>${logs.method?html}</td>
							<td>${logs.resource?html}</td>
							<td>${logs.protocol?html}</td>
							<td>${logs.statusCode?html}</td>
							<td>${logs.responseSize?html}</td>
							<td>${logs.clientInfo?html}</td>
						</tr>
					</#list>
				</tbody> 
			</table>
		</div>
	</body>
</html>