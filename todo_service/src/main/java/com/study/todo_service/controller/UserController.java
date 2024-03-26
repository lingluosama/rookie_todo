package com.study.todo_service.controller;
import com.study.todo_service.handler.UserHandler;
import com.study.todo_service.middleware.JwtUtils;
import com.study.todo_service.middleware.MinioUtils;
import com.study.todo_service.middleware.RedisUtils;
import com.study.todo_service.models.BaseStatus;
import com.study.todo_service.models.UserLoginResponse;
import com.study.todo_service.models.UserRegiterResponse;
import com.study.todo_service.models.UserUploadIconResponse;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserHandler userHandler;
    @Autowired
    private MinioUtils minioUtils;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private RedisUtils redisUtils;

    @PostMapping("/reg")
    public UserRegiterResponse UserRegiter(@RequestParam("password")  String password,@RequestParam("user_name") String user_name ){
        UserRegiterResponse res = userHandler.RegiterHandler(user_name, password);
        if(res!=null&&res.getUser_id()!=null){
            res.setToken( jwtUtils.create_token("user_id", res.getUser_id(), 30));
        }
        return res;
    }
    @GetMapping("/login")
    public  UserLoginResponse UserLogin(@RequestParam("password") String password,@RequestParam("user_name") String user_name){
        UserLoginResponse res = userHandler.LoginHandler(user_name, password);
        if(res.getBaseStatus().getStatus_code()==200){
            res.setToken( jwtUtils.create_token("user_id", res.getUser_id(), 30));
        }
        return res;
    }
    @PostMapping("/upload")
    public UserUploadIconResponse UploadIcon(MultipartFile file,Integer user_id,String token){
        String res = minioUtils.upload_icon(file, user_id.toString());
        UserUploadIconResponse resp=new UserUploadIconResponse();
        resp.setBaseStatus(new BaseStatus(400,"Accept"));
        resp.setIcon_url(res);
        return resp;
    }

}
