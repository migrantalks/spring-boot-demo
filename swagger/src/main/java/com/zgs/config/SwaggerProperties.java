package com.zgs.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * @author zgs
 */
@ConfigurationProperties(prefix = "swagger")
@Data
public class SwaggerProperties implements Serializable{

    private Boolean enable;
    private ApiInfoProperties apiInfo;
    private DocketProperties docket;
}
