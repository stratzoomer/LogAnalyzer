package com.brahma.loganalyzer;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.views.ViewBundle;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

import com.brahma.loganalyzer.resources.*;
import com.brahma.loganalyzer.health.TemplateHealthCheck;
import com.brahma.loganalyzer.core.Contact;

public class LogAnalyzerApplication extends Application<LogAnalyzerConfiguration> {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogAnalyzerApplication.class);
	private Contact contact;

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
    }

    @Override
    public void run(LogAnalyzerConfiguration configuration,
                    Environment environment) {
    	LOGGER.info("Inside run of LogAnalyzer");
        final DropWizardExampleResource exampleResource = new DropWizardExampleResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
            );
        contact = new Contact(100, "Brahma", "Koodallur", "555-555-5555");
        final LogAnalyzerMainResource mainResource = new LogAnalyzerMainResource(contact);
            final TemplateHealthCheck healthCheck =
                    new TemplateHealthCheck(configuration.getTemplate());
            environment.healthChecks().register("template", healthCheck);            
            environment.jersey().register(new LogAnalysisSummaryResource());
            environment.jersey().register(exampleResource);
            environment.jersey().register(mainResource);
    }
}