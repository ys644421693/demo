package com.demo.app.dao;

import com.demo.app.entity.UserVo;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<UserVo,Long> {

    UserVo findByUserNameAndPassword(String userName,String password);
}
