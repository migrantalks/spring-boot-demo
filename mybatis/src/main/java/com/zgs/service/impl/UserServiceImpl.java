package com.zgs.service.impl;

import com.zgs.dao.UserMapper;
import com.zgs.domain.User;
import com.zgs.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zgs
 * @since 2019/02/27
 */
@Service
public class UserServiceImpl implements IUserService{

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.selectAll();
    }
}
