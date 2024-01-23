package com.k0pster.springboot.demo.springcoredemo.rest;

import com.k0pster.springboot.demo.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//dodajemy adnotacje @RestControler
@RestController
public class DemoControler
{
    //Tworzymy konstruktor klasy do wstrzyknięcia.
    //w tym celu tworzymy prywatne pole dla dependecji
    private Coach myCoach;
    //Tworzymy przykładowa nowa zmienna innego trenera,
    //ktora bedzie korzystac z tego samego beana
    private Coach anotherCoach;
    //uzwględniam go w argumetach konstruktora

    //wstrzykuje swimCoacha
    @Autowired
    public DemoControler(@Qualifier("aquatic") Coach theCoach)
    {
        System.out.println("In constructor: "+getClass().getSimpleName());
        myCoach = theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout()
    {
        return myCoach.getDailyWorkout();
    }

}
