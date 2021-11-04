package com.lf.test.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author lufeifan
 * @date 2021/11/04 14:54
 **/
@Data
@Component
public class Student {

    @Value("tom")
    private String name;
    @Value("20")
    private Integer age;
}
