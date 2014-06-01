package com.brahma.loganalyzer.health;

import com.codahale.metrics.health.HealthCheck;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

public class TemplateHealthCheck extends HealthCheck {
    private final String uploadLocation;

    public TemplateHealthCheck(String uploadLocation) {
        this.uploadLocation = uploadLocation;
    }

    @Override
    protected Result check() throws Exception {
    	Path p1 = Paths.get(uploadLocation);
        if (!Files.isReadable(p1)) {
            return Result.unhealthy("Cannot read directory " + uploadLocation + ", needed for file upload operation.");
        }
        if (!Files.isWritable(p1)) {
            return Result.unhealthy("Directory " + uploadLocation + ", needed for file upload operation, is not writeable.");
        }
        return Result.healthy();
    }
}
