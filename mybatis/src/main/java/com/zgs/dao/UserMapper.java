package com.zgs.dao;

import com.zgs.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zgs
 */
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.BaseMapper<User>{

    List<User> findAllUser();
}
