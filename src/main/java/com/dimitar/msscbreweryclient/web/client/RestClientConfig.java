package com.dimitar.msscbreweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Component for holding the rest client config.
 * Reading the config from the properties file.
 */
@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class RestClientConfig {
    public static final String BEER_PATH_V1 = "/api/v1/beer/"; //! end with /
    public static final String CUSTOMER_PATH_V1 = "/api/v1/customer/"; //! end with /

    private String apiHost;

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public String getApiHost() {
        return apiHost;
    }
}
