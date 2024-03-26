package com.study.todo_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegiterResponse {
    private BaseStatus baseStatus;
    private Integer user_id;
    private String token;
}
