package com.brahma.loganalyzer;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.brahma.loganalyzer.resources.LogAnalyzerMainResource;
import com.brahma.loganalyzer.health.TemplateHealthCheck;

public class LogAnalyzerApplication extends Application<LogAnalyzerConfiguration> {
    public static void main(String[] args) throws Exception {
        new LogAnalyzerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<LogAnalyzerConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(LogAnalyzerConfiguration configuration,
                    Environment environment) {
        final LogAnalyzerMainResource resource = new LogAnalyzerMainResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
            );
            final TemplateHealthCheck healthCheck =
                    new TemplateHealthCheck(configuration.getTemplate());
            environment.healthChecks().register("template", healthCheck);            
            environment.jersey().register(resource);
    }
}
