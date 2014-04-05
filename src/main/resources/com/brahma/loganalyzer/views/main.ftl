<#-- @ftlvariable name="" type="com.brahma.loganalyzer.views.LogAnalyzerMainView" -->
<!DOCTYPE HTML>
<html>
	<head>
		<title>Log Analyzer Application</title>
		<link href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/redmond/jquery-ui.css" rel="stylesheet" type="text/css" />
		<link href="/assets/css/loganalyzer.css" rel="stylesheet" type="text/css" />

		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
	</head>
	<body id="home">
		<#include "header.ftl">
		<div id="main-container">
			<div id="left-container">
				<a href="/loganalyzer/results-summary">Use default log file for analysis</a>
			</div>
			<div id="right-container">
				<a href="">Upload a log file for analysis</a>
			</div>
		</div>
	</body>
</html>