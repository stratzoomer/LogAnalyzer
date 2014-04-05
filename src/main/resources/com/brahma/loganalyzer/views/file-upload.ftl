<#-- @ftlvariable name="" type="com.brahma.loganalyzer.views.FileUploadView" -->
<!DOCTYPE HTML>
<html>
	<head>
		<title>Log Analyzer Application</title>
		<link href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/redmond/jquery-ui.css" rel="stylesheet" type="text/css" />
		<link href="/assets/css/loganalyzer.css" rel="stylesheet" type="text/css" />

		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
		
		<script>
    		$(document).ready(function() {
        		$('#fileUpload').on('change', function() {
	            	var fakePath = $('#fileUpload').val();
	            	var fileName = fakePath.replace(/^.*[\\\/]/, '');
	            	$('#fileName').val(fileName);
        		});
    		});
		</script>
	</head>
	<body id="home">
		<#include "header.ftl">
		<div id="main-container">
			<div id="left-container">
				<form enctype="multipart/form-data" method="POST" action="/loganalyzer/file-upload">
            		<input type="file" id="file" name="file"/>
            		<input type="submit" value="Upload"/>
        		</form>
			</div>
			<div id="right-container">
				<a href="/loganalyzer/results-summary">Go!</a>
			</div>
		</div>
	</body>
</html>