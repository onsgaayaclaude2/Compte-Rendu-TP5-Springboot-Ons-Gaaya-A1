package com.app.tp5keycloak.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
@ConfigurationProperties(prefix = "token.converter")
public class TokenConverterProperties {

    private String resourceId;          // = medical-client
    private String principalAttribute;  // = preferred_username

    public String getResourceId() {
        return resourceId;
    }

    public Optional<String> getPrincipalAttribute() {
        return Optional.ofNullable(principalAttribute);
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public void setPrincipalAttribute(String principalAttribute) {
        this.principalAttribute = principalAttribute;
    }
}