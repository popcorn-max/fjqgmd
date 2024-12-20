package com.itgmd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itgmd.pojo.Users;

import java.util.List;

public interface UserService extends IService<Users>{
    Users queryUsersId(int id);
}
