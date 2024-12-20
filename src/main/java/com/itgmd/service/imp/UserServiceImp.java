package com.itgmd.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itgmd.mapper.UserMapper;
import com.itgmd.pojo.Users;
import com.itgmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp extends ServiceImpl<UserMapper, Users> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Users queryUsersId(int id) {

        return userMapper.queryUsersId(id);
    }
}
