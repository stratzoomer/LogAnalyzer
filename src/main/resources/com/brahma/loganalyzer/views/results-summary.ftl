<#-- @ftlvariable name="" type="com.brahma.loganalyzer.views.LogAnalysisSummaryView" -->
<!DOCTYPE html>
<html>
	<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Log Analyzer | Results Summary | ${logFile.logFileName?html}</title>
    <link rel="stylesheet" href="/assets/css/foundation.min.css" />
    <script src="/assets/javascript/modernizr.js"></script>

		<link href="//datatables.net/download/build/nightly/jquery.dataTables.css" rel="stylesheet" type="text/css" />
		<link href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/redmond/jquery-ui.css" rel="stylesheet" type="text/css" />

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
	<body>
		<#include "header.ftl">

    <div class="row">
      <div class="large-12 small-12 columns">
        <ul class="breadcrumbs">
          <li><a href="/loganalyzer">Home</a></li>
          <li class="current"><a href="#">Summary</a></li>
        </ul>
      </div>
    </div>

    <div class="row">
      <div class="large-12 small-12 columns">
        <div class="row">
          <div class="large-12 small-12 columns">
            <h4>Summary Statistics for Log: ${logFile.logFileName?html}  (logID: ${logFile.logID?html})</h4>
          </div>
        </div>
      
        <div class="row">
          <div class="large-6 small-12 columns">
            <p><a href="/loganalyzer/${logFile.logID}/log-file-detail">>> Go to Log File Detail</a></p>
          </div>
          
          <div class="large-6 small-12 columns">
            <div class="radius callout panel">
              <p>Total Number of log entries: <strong>${logFile.lineCount?html}</strong></p>
              <p>Total Unique IP Addresses: <strong>${logFile.uniqueIPAddressCount?html}</strong></p>
            </div>
          </div>
          
        </div>
      </div>
    </div>

    <div class="row">
      <div class="large-6 small-12 columns">
        <div class="radius callout panel">
        <h3>Counts by HTTP status codes</h3>
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
      </div>
      
      <div class="large-6 small-12 columns">
        <div class="radius callout panel">
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
    </div>

	</body>
</html>