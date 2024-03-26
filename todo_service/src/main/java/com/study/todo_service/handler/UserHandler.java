package com.study.todo_service.handler;

import com.study.todo_service.models.UserRegiterResponse;
import com.study.todo_service.models.UserLoginResponse;

public interface UserHandler {
    public UserLoginResponse LoginHandler(String user_name, String password);
    public UserRegiterResponse RegiterHandler(String user_name,String password);

}
