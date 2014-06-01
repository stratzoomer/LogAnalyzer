<#-- @ftlvariable name="" type="com.brahma.loganalyzer.views.LogAnalyzerMainView" -->
<!DOCTYPE html>
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Log Analyzer | Welcome</title>
    <link rel="stylesheet" href="/assets/css/foundation.min.css" />
    <script src="/assets/javascript/modernizr.js"></script>
    
    <link href="/assets/css/loganalyzer.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <#include "header.ftl">
        
    <div class="row" id="row1">
      <div class="large-12 columns">
        <div class="radius panel">
          <p>Log Analyzer is a RESTful application that helps you analyze and glean information from http logs that are in Simple Log Format. It has a packaged log file that can be used by default or users can supply a log file of their own choice.</p>
          <p>User supplied log files can be uploaded via this web page or via RESTful operations.</p>
          <p>To start, use one of the options below:</p>
        </div>
      </div>
    </div>

    <div class="row" id="row2">
      
      <div class="large-6 medium-6 small-12 columns" id="row2-col1">
        <div class="callout panel main-panel" id="main-panel-1">
          <form enctype="multipart/form-data" method="POST" action="/loganalyzer/upload" data-abide>
            <fieldset>
              <legend>Upload Log File</legend>
              
              <div class="row" id="row2-col1-row1">
                <div class="large-12 columns">
                  <label>Select a file to upload <small>required</small>
                    <input type="file" name="file" />
                  </label>
                </div>
              </div> <!--row2-col1-row1-->
              
              <div class="row" id="row2-col1-row2">
                <div class="large-6 medium-6 small-12 columns" id="row2-col1-row2-col1">
                  <div class="name-field">
                    <label>Enter a name for your log file <small>required</small>
                      <input type="text" id="file-name" name="file-name" maxlength="15" required pattern="alpha_numeric" />
                    </label>
                    <small class="error">Name is required and must be a string.</small>
                  </div>
                </div> <!--row2-col1-row2-col1-->
              </div> <!--row2-col1-row2-->

              <div class="row" id="row2-col1-row3">
                <div class="large-6 medium-6 small-12 columns" id="row2-col1-row3-col1">
                  <input class="small round button" type="submit" value="Upload and Process" />
                </div>
              </div> <!--row2-col1-row3-->
                
            </fieldset>
          </form>
        </div> <!--main-panel-1-->
      </div> <!--row2-col1-->
      
      <div class="large-6 medium-6 small-12 columns" id="row2-col2">
        <div class="callout panel main-panel" id="main-panel-2">
          <div class="row" id="row2-col2-row1">
            <div class="large-12 columns">
              <a href="/loganalyzer/restful-information" class="small round button">List of RESTful operations</a>
            </div>
          </div> <!--row2-col2-row1-->
          <div class="row" id="row2-col2-row2">
            <div class="large-12 columns">
              <a href="/loganalyzer/load-default" class="small round button">Use default log file for analysis</a>
            </div>
          </div> <!--row2-col2-row2-->

        </div> <!--main-panel-2-->      
      </div> <!--row2-col2-->
      
    </div> <!--row2-->

    <script src="/assets/javascript/jquery.js"></script>
    <script src="/assets/javascript/fastclick.js"></script>
    <script src="/assets/javascript/foundation.min.js"></script>
    <script>
      $(document).foundation();
    </script>
    
  </body>
</html>