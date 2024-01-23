package com.k0pster.springboot.demo.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//dodaje adnotacje @Lazy do tej klasy i to nie zostanie zainicjalizowane
//na początku jak reszta.
@Component
@Lazy
public class TrackCoach implements Coach{
    //Tworze klase konstruktor ktora wyprintuje nazwe klasy
    public TrackCoach()
    {
        System.out.println("In constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Run a 5k as fast as you can!";
    }
}
