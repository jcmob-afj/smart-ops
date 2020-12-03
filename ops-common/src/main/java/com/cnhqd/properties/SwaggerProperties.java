package com.cnhqd.properties;

import lombok.Data;

/**
 * @author afj
 */
@Data
public class SwaggerProperties {
    private Boolean isShow;
    private String basePackage;
    private String title;
    private String description;
    private String version;
    private String author;
    private String url;
    private String email;
    private String license;
    private String licenseUrl;
}
