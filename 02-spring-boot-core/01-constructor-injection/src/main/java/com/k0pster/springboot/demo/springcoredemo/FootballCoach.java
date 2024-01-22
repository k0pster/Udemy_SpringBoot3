package com.k0pster.springboot.demo.springcoredemo;

import org.springframework.stereotype.Component;

//dodajemy adnotacje @Component aby spring mógł znaleźć tą zaleznosc
@Component
public class FootballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice shots on goal in next 15 minutes.";
    }
}
