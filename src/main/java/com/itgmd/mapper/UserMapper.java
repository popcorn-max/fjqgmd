package com.itgmd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itgmd.pojo.Users;

import java.util.List;

public interface UserMapper extends BaseMapper<Users> {

    Users queryUsersId(int id);
}

