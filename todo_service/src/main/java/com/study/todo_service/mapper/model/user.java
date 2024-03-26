package com.study.todo_service.mapper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class user {
    private String iconurl;
    private Integer id;
    private String name;
    private String password;
    private event[] events;
}
