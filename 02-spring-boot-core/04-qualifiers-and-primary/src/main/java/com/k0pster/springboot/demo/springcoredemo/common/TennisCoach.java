package com.k0pster.springboot.demo.springcoredemo.common;
//Tworzę kolejną pochodna od klasy coach TennisCoach

import org.springframework.stereotype.Component;


@Component
public class TennisCoach implements Coach{
    //nadpisujemy metodę z interfejsu Coach
    @Override
    public String getDailyWorkout() {
        return "Practice foreheands voley for next 15 minutes";
    }
}
