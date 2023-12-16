package com.example.springmvcencryptdecrypt.config;

import com.example.springmvcencryptdecrypt.pojo.RespBean;
import com.example.springmvcencryptdecrypt.utils.AESUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class EncryptResponse implements ResponseBodyAdvice<RespBean> {
    private ObjectMapper om = new ObjectMapper();

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.out.println(returnType);
        System.out.println(converterType);
        return true;
    }

    @Override
    public RespBean beforeBodyWrite(RespBean body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        try {
            if (body.getMsg() != null) {
                body.setMsg(AESUtil.encrypt(body.getMsg().getBytes(), "weimin1234567890".getBytes()));
            }
            if (body.getObj() != null) {
                body.setObj(AESUtil.encrypt(om.writeValueAsBytes(body.getObj()), "weimin1234567890".getBytes()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }
}