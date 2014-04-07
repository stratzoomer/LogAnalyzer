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
		<div id="nav-container">
			<h2>Select Type of Log File to Process</h2>
		</div>
		<div id="main-container">
			<div id="left-container">
				<a href="/loganalyzer/load-default">Use default log file for analysis</a>
			</div>
			<div id="right-container">
				<form enctype="multipart/form-data" method="POST" action="/loganalyzer/upload">
					<p>
	            		<label for="file">Click to choose a log file from your computer</label>
	            		<input type="file" id="file" name="file"/>
	            	</p>
	            	<p>
	            		<label for="file-name">Enter a name for your log file</label>
	            		<input type="text" id="file-name" name="file-name"/>
	            	</p>
	            	<p>
	            		<input type="submit" value="Upload and Process"/>
	            	</p>
        		</form>
			</div>
		</div>
	</body>
</html>