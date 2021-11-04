package com.lf.test.controller;

import com.lf.test.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lufeifan
 * @date 2021/11/04 14:50
 **/
@RestController
public class CacheController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,Student> redisTemplate;

    @Autowired
    private Student student;

    @GetMapping("/test")
    public void test(){

//        stringRedisTemplate.opsForValue().set("lf","test");
//        stringRedisTemplate.opsForValue().set("stu",student.toString());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setKeySerializer(new GenericJackson2JsonRedisSerializer());

        redisTemplate.opsForValue().set("stu1",student);
        redisTemplate.expire("stu1",2000, TimeUnit.SECONDS);
    }

}
