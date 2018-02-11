package com.demo.app.service;

import com.demo.app.dto.req.UserRequest;
import com.demo.app.dto.resp.UserResponse;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {

    UserResponse login(UserRequest userRequest, HttpServletRequest request);

    boolean out(long userId,HttpServletRequest request);

    UserResponse addUser(UserRequest userRequest, HttpServletRequest request);
}
