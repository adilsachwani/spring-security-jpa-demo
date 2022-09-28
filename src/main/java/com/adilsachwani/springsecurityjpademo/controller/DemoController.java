package com.adilsachwani.springsecurityjpademo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping
    public String main(){
        return "Main Api";
    }

    @GetMapping("/user")
    public String user(){
        return "User Api";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Admin Api";
    }

}
