package com.k0pster.springboot.demo.springcoredemo.common;

import org.springframework.stereotype.Component;

//Tworzę klasę BasketballCoach dziedziczaca od Coach
//Dodaje @Compononent, żeby Spring wiedział, że ma to wstrzyknąć.
@Component
public class BasketballCoach implements Coach {
    @Override
    public String getDailyWorkout()
    {
        return "Do some basket Throws for next 10 minutes.";
    }
}
