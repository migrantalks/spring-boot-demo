package com.zgs.config;

import com.zgs.domain.Contact;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zgs
 */
@Data
public class ApiInfoProperties implements Serializable{

    private String title;
    private String description;
    private String termsOfServiceUrl;
    private Contact contact;
    private String license;
    private String licenseUrl;
    private String version;
}
