<#-- @ftlvariable name="" type="com.brahma.loganalyzer.views.LogAnalysisSummaryView" -->
<!DOCTYPE HTML>
<html>
	<head>
		<title>Log Analyzer Application - ${logFile.logFileName?html}</title>
		<link href="//datatables.net/download/build/nightly/jquery.dataTables.css" rel="stylesheet" type="text/css" />
		<link href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/redmond/jquery-ui.css" rel="stylesheet" type="text/css" />
		<link href="/assets/css/loganalyzer.css" rel="stylesheet" type="text/css" />

		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
		<script src="//datatables.net/download/build/nightly/jquery.dataTables.js"></script>
		
		<meta charset=utf-8 />
		<script>
			$(document).ready( function () {
  				$('#counts-by-ip').dataTable();
  				$('#counts-by-status').dataTable();
			} );
		</script>		
	</head>
	<body id="home">
		<#include "header.ftl">
		<div id="nav-container">
			<h2>Statistics for: ${logFile.logFileName?html}</h2>
			<a href="/loganalyzer">Select a Different Log File</a>
		</div>
		<div id="main-container">
			<div id="left-container">
				<h3>Total Unique IP Addresses: ${logFile.uniqueIPAddressCount?html}</h3>
				<table class="display" id="counts-by-status">
					<thead>
						<tr>
							<th>HTTP Status Codes</th>
							<th>Count</th>
						</tr>	
					</thead>
					<tbody>
						<#list logFile.statusCodeCounts?keys as key>
							<tr><td>${key}</td><td>${logFile.statusCodeCounts[key]}</td></tr>
						</#list>
					</tbody> 
				</table>
			</div>
			<div id="right-container">
				<h3>Counts by IP Addresses</h3>
				<table class="display" id="counts-by-ip">
					<thead>
						<tr>
							<th>Origin IP Address</th>
							<th>Count</th>
						</tr>	
					</thead>
					<tbody>
						<#list logFile.ipAddressCounts?keys as key>
							<tr><td>${key}</td><td>${logFile.ipAddressCounts[key]}</td></tr>
						</#list>
					</tbody> 
				</table>
			</div>
		</div>
	</body>
</html>