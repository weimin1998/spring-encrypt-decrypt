package com.example.springmvcencryptdecrypt.demos.web;

import com.example.springmvcencryptdecrypt.pojo.RespBean;
import com.example.springmvcencryptdecrypt.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEncryptResponseController {

    @RequestMapping("/encrypt")
    private RespBean user() {
        User user = new User();
        user.setName("weimin");
        user.setAge(666);
        return RespBean.ok("ok", user);
    }
}

