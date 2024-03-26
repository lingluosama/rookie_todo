package com.study.todo_service.mapper;

import com.study.todo_service.mapper.model.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    public Integer QueryUserByLogin(String name,String password);
    public user GetUserById(Integer id);

    public  Integer CreateUser(user user);
    public  Integer QueryUserExist(String name);

}
