package com.study.todo_service.handler.impl;

import com.study.todo_service.handler.UserHandler;
import com.study.todo_service.mapper.UserMapper;
import com.study.todo_service.mapper.model.user;
import com.study.todo_service.middleware.RedisUtils;
import com.study.todo_service.models.BaseStatus;
import com.study.todo_service.models.UserLoginResponse;
import com.study.todo_service.models.UserRegiterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHandlerImpl implements UserHandler {
    @Autowired
    private UserMapper dao;
    @Autowired
    RedisUtils redisUtils;
    @Override
    public UserLoginResponse LoginHandler(String user_name, String password) {
        UserLoginResponse res=new UserLoginResponse();
        Integer user_id = dao.QueryUserByLogin(user_name, password);
        if(user_id==null) {
            res.setBaseStatus(new BaseStatus(400,"Cant find user"));
        }else{
            res.setBaseStatus(new BaseStatus(200,"Accepted"));
            res.setUser_id(user_id);
        }
        return res;
    }

    @Override
    public UserRegiterResponse RegiterHandler(String user_name, String password) {
        UserRegiterResponse res=new UserRegiterResponse();
        Integer exist = dao.QueryUserExist(user_name);
        if(exist!=null){
            res.setBaseStatus(new BaseStatus(400,"Username Exist"));
            res.setUser_id(null);
            return res;
        }
        user User= new user();
        User.setName(user_name);User.setPassword(password);
        Integer id = dao.CreateUser(User);


        if (id==null){
            res.setBaseStatus(new BaseStatus(400,"Database Create WA"));
            res.setUser_id(null);
        }else {
            res.setBaseStatus(new BaseStatus(200,"Accepted"));
            res.setUser_id(id);
            redisUtils.set("user_id:"+res.getUser_id(),res);
        }
        return res;
    }
}
