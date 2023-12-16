package com.example.springmvcencryptdecrypt.demos.web;

import com.example.springmvcencryptdecrypt.pojo.RespBean;
import com.example.springmvcencryptdecrypt.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDecryptRequestController {


    @PostMapping("/decrypt")
    public RespBean decrypt(@RequestBody User user){
        System.out.println(user);
        return RespBean.ok("ok", user);
    }
}
