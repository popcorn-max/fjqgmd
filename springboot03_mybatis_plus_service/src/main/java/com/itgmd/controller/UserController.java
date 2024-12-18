package com.itgmd.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itgmd.mapper.UserMapper;
import com.itgmd.pojo.Users;
import com.itgmd.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Resource
    UserMapper userMapper;

    @GetMapping("queryId")
    @ResponseBody
    public String queryId(String id) {

        return userService.getById(id).toString();
    }

    //查询所有
    @GetMapping("queryAll")
    @ResponseBody
    public String queryAll(String pageNum){
        Page<Users> page=new Page<>(Integer.parseInt(pageNum),2l);//1当前页，2每页显示条数
        userMapper.selectPage(page,null);
        return  page.getRecords().toString();
    }
    //条件查询
    @GetMapping("queryIf")
    @ResponseBody
    public String queryIf(){
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        queryWrapper.likeRight("user_name","三");
        queryWrapper.like("user_name","铁");
        queryWrapper.ge("money",3000); //大于三千
        queryWrapper.like("user_name","王")
                    .ge("money",2000)
                    .isNotNull("password");
        return userService.list(queryWrapper).toString();
    }

    @GetMapping("queryName")
    @ResponseBody
    public String queryName(String userName) {
        Map map = new HashMap<>();
        map.put("user_name", "张三");
        return userService.listByMap(map).toString();
    }

    @GetMapping("addUsers")
    @ResponseBody
    public String addUsers() {
        Users users=new Users();
        users.setId(5);
        users.setUserName("铁柱");
        users.setPassword("123456");
        users.setMoney(2000);
        return userService.save(users)+"";
    }
    @GetMapping("addUsersList")
    @ResponseBody
    public String addUsersList() {
        List<Users> usersList=new ArrayList<>();
        Users users1=new Users();
        users1.setId(6);
        users1.setUserName("张三");
        users1.setPassword("123545");
        users1.setMoney(1200);
        usersList.add(users1);
        Users users2=new Users();
        users2.setId(7);
        users2.setUserName("狗蛋");
        users2.setPassword("35311");
        users2.setMoney(3200);
        usersList.add(users2);
        return userService.saveBatch(usersList)+"";

    }

    @GetMapping("updateList")
    @ResponseBody
    public String updateList() {
        List<Users> usersList=new ArrayList<>();
        Users users1=new Users();
        users1.setId(6);
        users1.setUserName("小男孩");
        users1.setPassword("123545");
        users1.setMoney(1200);
        usersList.add(users1);
        Users users2=new Users();
        users2.setId(7);
        users2.setUserName("邱小姐");
        users2.setPassword("35311");
        users2.setMoney(3200);
        usersList.add(users2);
        return userService.updateBatchById(usersList)+"";
    }

    @GetMapping("deleteUser")
    @ResponseBody
    public boolean deleteUser(String id){
        return userService.removeById(id);
    }

    @GetMapping("queryMoney")
    @ResponseBody
    public String queryMoney(String pageNum,String money){
        return userService.queryUserMoney(Integer.parseInt(pageNum),Integer.parseInt(money)).toString();
    }

}
