package com.k0pster.springboot.demo.springcoredemo.common;
//Tworzę kolejną pochodna od klasy coach TennisCoach

import org.springframework.stereotype.Component;


@Component
public class TennisCoach implements Coach{
    //Tworze klase konstruktor ktora wyprintuje nazwe klasy
    public TennisCoach()
    {
        System.out.println("In constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice foreheands voley for next 15 minutes";
    }
}
