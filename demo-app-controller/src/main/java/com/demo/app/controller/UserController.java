package com.demo.app.controller;

import com.demo.app.dto.req.UserRequest;
import com.demo.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Object login(UserRequest userRequest, HttpServletRequest httpRequest){

        return userService.login(userRequest,httpRequest);
    }
    @RequestMapping(value = "/out",method = RequestMethod.GET)
    public Object out(long id,HttpServletRequest httpRequest){
        return userService.out(id,httpRequest);
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Object add(UserRequest userRequest, HttpServletRequest request){
        return userService.addUser(userRequest,request);
    }

}
