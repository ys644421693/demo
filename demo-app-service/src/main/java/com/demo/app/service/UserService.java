package com.demo.app.service;

import com.demo.app.Constant.SessionConstant;
import com.demo.app.component.MD5Component;
import com.demo.app.dao.IUserDao;
import com.demo.app.dto.req.UserRequest;
import com.demo.app.dto.resp.UserResponse;
import com.demo.app.entity.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    public UserResponse login(UserRequest userRequest, HttpServletRequest request) {
        UserResponse userResponse = new UserResponse();
        HttpSession httpSession = request.getSession();
        UserVo u = (UserVo) httpSession.getAttribute(SessionConstant.USER_SESSION.getDescription());
        if (u != null) {
            BeanUtils.copyProperties(u, userResponse);
            return userResponse;
        }
        u = userDao.findByUserNameAndPassword(userRequest.getUserName(), MD5Component.MD5(userRequest.getPassword()));
        if (null == u) {
            return null;
        }
        httpSession.setAttribute(SessionConstant.USER_SESSION.getDescription(), u);
        BeanUtils.copyProperties(u, userResponse);
        return userResponse;
    }

    public boolean out(long userId, HttpServletRequest request) {
        UserVo u = userDao.findOne(userId);
        if (null == u) {
            return false;
        }
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute(SessionConstant.USER_SESSION.getDescription());
        return true;
    }

    public UserResponse addUser(UserRequest userRequest, HttpServletRequest request) {
        UserResponse userResponse = new UserResponse();
        UserVo userVo = new UserVo();
        //密码校验可以在这里
        userVo.setPassword(MD5Component.MD5(userRequest.getPassword()));
        userVo.setUserName(userRequest.getUserName());
        userVo = userDao.save(userVo);
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute(SessionConstant.USER_SESSION.getDescription());
        if (null == userVo || userVo.getId() <= 0) {
            return null;
        }
        BeanUtils.copyProperties(userVo, userResponse);
        return userResponse;
    }
}
