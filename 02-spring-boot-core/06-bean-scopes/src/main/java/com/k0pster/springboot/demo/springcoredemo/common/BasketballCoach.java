package com.k0pster.springboot.demo.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Dodaje zasieg poprzez adnotacje @Scope zmieniam
//na PROTOTYPE, co bedzie skutkowac dwoma osobnymi obiektami/beanami klasy
//BasketballCoach przy buowie aplikacji
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
