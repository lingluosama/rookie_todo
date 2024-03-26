package com.study.todo_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUploadIconResponse {
    BaseStatus baseStatus;
    String icon_url;
}
