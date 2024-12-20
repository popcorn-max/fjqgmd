package com.itgmd.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itgmd.mapper.UserMapper;
import com.itgmd.pojo.Users;
import com.itgmd.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Resource
    UserMapper userMapper;

    //查询所有用户
    @GetMapping("/query")
    public String queryUsers(Model model,  @RequestParam(defaultValue = "1") int pageNum,
                             @RequestParam(defaultValue = "4") int pageSize){
        Page<Users> page=new Page<>(pageNum,pageSize);
        userMapper.selectPage(page,null);
        List<Users> usersList =page.getRecords();

        model.addAttribute("usersList",usersList);

        model.addAttribute("pageNum",pageNum+1);
        model.addAttribute("pageNumLine",pageNum-1);

        return "index";
    }

    //增加用户
    @PostMapping("/add")
    public String addUsers(Users users) {
        boolean fig = userService.save(users);
        if (fig) {
            return "redirect:query";//转发
        } else {
            return "error";
        }
    }

    //回血效果
    @GetMapping("/queryId")
    public String queryId(int id,Model model)
    {
        Users users=userService.queryUsersId(id);

        model.addAttribute("users",users);

        return "update";
    }

    //修改用户
    @PostMapping("/update")
    public String updateUsers(Users users)
    {
        boolean fig=userService.saveOrUpdate(users);
        if(fig)
        {
            return "redirect:query";
        }else
        {
            System.out.println("Error updating user: " + users);
            return "error";
        }
    }

    //删除用户
    @GetMapping("/delete")
    public String deleteUsers(String id) {
        boolean fig = userService.removeById(id);
        if (fig) {
            return "redirect:query";//转发
        } else {
            return "error";
        }
    }


}
