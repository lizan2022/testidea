package com.test.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum JsonResponseStatus {
    SUCCESS(200,"成功"),
    ERROR(100,"失败"),
    DELERROT(101,"删除失败"),
    NULLVALUE(2001,"查不到数据"),
    INSERROT(102,"新增失败"),
    UPDERROT(103,"修改失败"),
    ;
    private Integer code;
    private String msg;
}
