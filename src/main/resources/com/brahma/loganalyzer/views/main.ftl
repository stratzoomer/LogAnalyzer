<#-- @ftlvariable name="" type="com.brahma.loganalyzer.views.LogAnalyzerMainView" -->
<html>
	<head>
		<title>Contact</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<th colspan ="2">Contact ${contact.id}) </th>
			</tr>
			<tr>
				<td>First Name</td>
				<td>${contact.firstName?html}</td></tr>
			</tr>
		</table>
	</body>
</html>