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

    //denfiniowanie metody init z wykorzystaniem
    //adnotacji @PostConstruct, która odpali się od razu przy budowie/inicjalizaji
    @PostConstruct
    public void doMyStartupStuff()
    {
        System.out.println("In doMyStartupStuff(): "+getClass().getSimpleName());
    }
    //definiowanie metody destroy
    //adnotacji @PreDestroy, dzięki której metoda odpali sie gdy stopujemy
    //uruchomiona aplikacje
    @PreDestroy
    public void doMyCleanupStuff()
    {
        System.out.println("In doMyCleanupStuff(): "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout()
    {
        return "Do some basket Throws for next 10 minutes.";
    }
}
