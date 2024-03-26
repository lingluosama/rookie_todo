package com.study.todo_service.mapper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class event {
    private  Boolean compelet;
    private String content;
    private String endTime;
    private Integer level;
    private String startTime;
    private String title;
    private Integer userid;

}
