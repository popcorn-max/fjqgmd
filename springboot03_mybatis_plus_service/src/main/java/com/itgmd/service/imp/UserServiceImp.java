package com.itgmd.service.imp;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itgmd.mapper.UserMapper;
import com.itgmd.pojo.Users;
import com.itgmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp extends ServiceImpl<UserMapper, Users> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Users login(String userName, String password) {
        return null;
    }

    @Override
    public List<Users> queryUserMoney(Integer pageNum, Integer money) {
        IPage<Users> page=new Page<>(pageNum,2);
        userMapper.queryUserMoney(page,money);
        return page.getRecords();
    }

}
