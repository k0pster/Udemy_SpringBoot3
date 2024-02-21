package com.kopster.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//zaimportowanie ui.Model
import org.springframework.ui.Model;

@Controller
public class Democontroller
{
    //tworzenie mapping dla /hello z użyciem modelu w którym
    //za pomocą atrybutu theDate stworzymy date by potem wyświetlić
    //skorzystać z niej i wyświetlic ja w pliku stworzonej templatce
    //HTML helloworld.html
    @GetMapping("/hello")
    public String sayHello(Model theModel)
    {
        //dodajemy atrybut daty jako theDate
        theModel.addAttribute("theDate", new java.util.Date());

        return "helloworld";
    }
}
