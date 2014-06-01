<!DOCTYPE html>
<html>
	<head>
		<title>Log Analyzer Application - ERROR</title>
		<link href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/redmond/jquery-ui.css" rel="stylesheet" type="text/css" />
		<link href="/assets/css/loganalyzer.css" rel="stylesheet" type="text/css" />

		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
	</head>
	<body id="home">
		<#include "header.ftl">
		<div id="nav-container">
			<div id="nav-options">
				<div><a href="/loganalyzer"><< Select a Different Log File</a></div>
			</div>
			<div id="nav-title">
				<h2>Log file processing error</h2>
			</div>
		</div>
		<div id="main-container">
			Encountered error while processing log - bad format!
		</div>
	</body>
</html>