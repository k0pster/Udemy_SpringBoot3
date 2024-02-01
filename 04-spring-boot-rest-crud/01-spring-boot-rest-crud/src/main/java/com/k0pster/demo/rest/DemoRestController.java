package com.k0pster.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Tworzę rest controller(@RestController oraz @RequestMapping)
@RestController
@RequestMapping("/test")
public class DemoRestController
{
    //dodaje kod dla endopointu /hello
    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hello World!";
    }
}


