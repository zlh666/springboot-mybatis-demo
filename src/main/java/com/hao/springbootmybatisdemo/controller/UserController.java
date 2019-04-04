package com.hao.springbootmybatisdemo.controller;


import com.hao.springbootmybatisdemo.model.User;
import com.hao.springbootmybatisdemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/8/16.
 */
@RestController
@RequestMapping(value = "/user")
@Api(value = "用户中心", consumes = "application/json", produces = "application/json", protocols = "http",tags = "用户中心")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="添加用户", notes="添加用户")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public int addUser(User user){
        return userService.addUser(user);
    }

    @ApiOperation(value="分页查询用户", notes="分页查询用户")
    @RequestMapping(value = "/all/{pageNum}/{pageSize}",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "pageNum", value = "页码", required = true, dataType = "Int"),
            @ApiImplicitParam(paramType = "path", name = "pageSize", value = "记录数", required = true, dataType = "Int")
    })
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }

    @ApiOperation(value="查询所有用户", notes="查询所有用户")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public Object findAllUsers(){
        return userService.findAllUsers();
    }


}