package com.k0pster.springboot.demo.springcoredemo.common;

import org.springframework.stereotype.Component;

//dodajemy adnotacje @Component aby spring mógł znaleźć tą zaleznosc
@Component
public class FootballCoach implements Coach{
    //Tworze klase konstruktor ktora wyprintuje nazwe klasy
    public FootballCoach()
    {
        System.out.println("In constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice shots on goal in next 15 minutes :)";
    }
}
