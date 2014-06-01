<#-- @ftlvariable name="" type="com.brahma.loganalyzer.views.LogFileDetailView" -->
<!DOCTYPE html>
<html>
	<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Log Analyzer | Results Detail | ${logFile.logFileName?html}</title>
    <link rel="stylesheet" href="/assets/css/foundation.min.css" />
    <script src="/assets/javascript/modernizr.js"></script>
 
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

    <div class="row">
      <div class="large-12 small-12 columns">
        <ul class="breadcrumbs">
          <li><a href="/loganalyzer">Home</a></li>
          <li><a href="/loganalyzer/${logFile.logID}/results-summary">Summary</a></li>
          <li class="current"><a href="#">Detail</a></li>
        </ul>
      </div>
    </div>
    
    <div class="row">
      <div class="row">
        <div class="large-12 small-12 columns">
          <h4>Details for Log: ${logFile.logFileName?html}  (logID: ${logFile.logID?html})</h4>
        </div>
      </div>
    
      <div class="row">
        <div class="large-6 small-12 columns">
            <p><a href="/loganalyzer/${logFile.logID}/results-summary"><< Back to Summary</a></p>
        </div>
      
        <div class="large-6 small-12 columns">
            <div class="radius callout panel">
              <p>Total Number of log entries: <strong>${logFile.lineCount?html}</strong></p>
              <p>Total Unique IP Addresses: <strong>${logFile.uniqueIPAddressCount?html}</strong></p>
            </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="large-12 columns">
        <!--<div class="radius callout panel">-->
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
        <!--</div>-->
      </div>
    </div>
    
	</body>
</html>