package com.itgmd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itgmd.pojo.Users;

public interface UserMapper extends BaseMapper<Users> {
    IPage<Users> queryUserMoney(IPage<Users> page,Integer money);
}
