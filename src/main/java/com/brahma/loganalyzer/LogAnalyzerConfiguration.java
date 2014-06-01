package com.brahma.loganalyzer;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class LogAnalyzerConfiguration extends Configuration {
    @NotEmpty
    private String uploadLocation;

    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    public String getUploadLocation() {
        return uploadLocation;
    }

    @JsonProperty
    public void setUploadLocation(String uploadLocation) {
        this.uploadLocation = uploadLocation;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }
}
