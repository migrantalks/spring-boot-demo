package com.zgs.service;

import com.zgs.domain.User;

import java.util.List;

/**
 * @author zgs
 * @since 2019/02/27
 */
public interface IUserService {

    List<User> findAllUser();

}
