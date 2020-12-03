package com.cnhqd.properties;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author afj
 */
@Data
@SpringBootConfiguration
@ConfigurationProperties(prefix = "ops")
public class OpsProperties {

    private SwaggerProperties swagger = new SwaggerProperties();

    private int maxBatchInsertNum = 1000;

}
