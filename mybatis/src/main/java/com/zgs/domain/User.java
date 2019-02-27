package com.zgs.domain;

import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author zgs
 */
@Data
@Table(name = "jx_org_user")
public class User implements Serializable {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 密码
     */
    private String pass;

    /**
     * 部门id
     */
    private Long deptId;

    @Transient
    private String deptName;
    @Transient
    private Long roleId;
    @Transient
    private String roleName;

    /**
     * 用户序号
     */
    private Long userNo;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 手机客户端
     */
    private String clientId;

    /**
     * 账号类型
     */
    private String accountType;

    /**
     * 性别 0：男 1：女
     */
    private String userSex;

    /**
     * 主题
     */
    private String theme;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 数据状态 0：无效 1：有效 2：锁定
     */
    private String status;

    /**
     * 公司id
     */
    private Long companyId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 修改人
     */
    private Long modifyUser;
}
