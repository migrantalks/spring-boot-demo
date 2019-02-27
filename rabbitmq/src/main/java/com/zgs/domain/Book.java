package com.zgs.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zgs
 */
@Data
public class Book implements Serializable{
    private int id;
    private String name;
}
