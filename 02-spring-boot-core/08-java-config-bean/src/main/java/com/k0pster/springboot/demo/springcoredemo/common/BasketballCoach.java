package com.k0pster.springboot.demo.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {
    //Tworze klase konstruktor ktora wyprintuje nazwe klasy
    public BasketballCoach()
    {
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout()
    {
        return "Do some basket Throws for next 10 minutes.";
    }
}
