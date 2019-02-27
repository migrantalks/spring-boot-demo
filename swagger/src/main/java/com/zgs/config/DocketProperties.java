package com.zgs.config;


import lombok.Data;

import java.io.Serializable;

/**
 * @author zgs
 */
@Data
public class DocketProperties implements Serializable{

    private String groupName;
    private String basePackage;
}
