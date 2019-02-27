package com.zgs.domain;

import lombok.Data;

/**
 * @author zgs
 */
@Data
public class Contact {

    private String name;
    private String url;
    private String email;
    public Contact(){}

    public Contact(String name, String url, String email) {
        this.name = name;
        this.url = url;
        this.email = email;
    }
}
