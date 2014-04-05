package com.brahma.loganalyzer;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.views.ViewBundle;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.AssetsBundle;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

import com.brahma.loganalyzer.resources.*;
import com.brahma.loganalyzer.health.TemplateHealthCheck;

public class LogAnalyzerApplication extends Application<LogAnalyzerConfiguration> {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogAnalyzerApplication.class);
	
    public static void main(String[] args) throws Exception {
        new LogAnalyzerApplication().run(args);
    }

    @Override
    public String getName() {
        return "Log Analyzer";
    }

    @Override
    public void initialize(Bootstrap<LogAnalyzerConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(new AssetsBundle());
    }

    @Override
    public void run(LogAnalyzerConfiguration configuration,
                    Environment environment) {
    	LOGGER.info("Inside run of LogAnalyzer");
        final DropWizardExampleResource exampleResource = new DropWizardExampleResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
            );
        final LogAnalyzerMainResource mainResource = new LogAnalyzerMainResource();
            final TemplateHealthCheck healthCheck =
                    new TemplateHealthCheck(configuration.getTemplate());
            environment.healthChecks().register("template", healthCheck);            
            environment.jersey().register(new LogAnalysisSummaryResource());
            environment.jersey().register(exampleResource);
            environment.jersey().register(mainResource);
    }
}