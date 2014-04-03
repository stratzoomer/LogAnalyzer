<#-- @ftlvariable name="" type="com.brahma.loganalyzer.views.LogAnalysisSummaryView" -->
<html>
	<head>
		<title>Contact</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<th colspan ="2">Default File Statistics</th>
			</tr>
			<tr>
				<td>Total Unique IP Addresses</td>
				<td>${logFile.uniqueIPAddressCount?html}</td></tr>
			</tr>
		</table>
	</body>
</html>