<#-- @ftlvariable name="" type="com.brahma.loganalyzer.views.LogAnalyzerMainView" -->
<!DOCTYPE html>
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Log Analyzer | Welcome</title>
    <link rel="stylesheet" href="/assets/css/foundation.min.css" />
    <script src="/assets/javascript/modernizr.js"></script>
  </head>
  <body>
    <#include "header.ftl">
        
    <div class="row">
      <div class="large-12 columns">
        <div class="radius panel">
          <h3>REST API (json)</h3>
          <p>
            <h5>To upload a log file -</h5> 
            curl -H "Content-Type: application/json" -X POST -d '{"logName":"Test","logFileContent":"188.165.243.118 - - [16/Mar/2012:05:49:49 -0700] \"GET / HTTP/1.1\" 200 7599 \"-\" \"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0)\""}' http://localhost:8080/loganalyzer/upload</br>
            Note that the data corresponding to the key logFileContent should be the the http log, as a continuous string. All quote characters in the log string should be escaped with a single backslash character. All line breaks should be replaced with \n.</br>
            This method will return a system generated unique ID corresponding to the log file information
          </p>
          
          <p>
            <h5>To get a summary of a log file:</h5>
            curl -H "Content-Type: application/json" http://localhost:8080/loganalyzer/1/results-summary</br>
            where 1 is the unique ID of the log information uploaded in a previous step.
          </p>
          
          <p>
            <h4>Other available REST API calls</h4>
            <p>
              <h5>Unique IP Address count (as an integer)</h5>
              curl -H "Content-Type: application/json" http://localhost:8080/loganalyzer/1/results-summary/unique-ip-count
            </p>
                    
            <p>
            <h5>Line count (as an integer)</h5>
            curl -H "Content-Type: application/json" http://localhost:8080/loganalyzer/1/results-summary/line-count
            </p>
          
            <p>
            <h5>Counts by IP Addresses (as a json string)</h5>
            curl -H "Content-Type: application/json" http://localhost:8080/loganalyzer/1/results-summary/count-by-ip
            </p>
            
            <p>
            <h5>Counts by Status Codes (as a json string)</h5>
            curl -H "Content-Type: application/json" http://localhost:8080/loganalyzer/1/results-summary/count-by-status
            </p>
          </p>
        </div>
      </div>
    </div>

  </body>
</html>