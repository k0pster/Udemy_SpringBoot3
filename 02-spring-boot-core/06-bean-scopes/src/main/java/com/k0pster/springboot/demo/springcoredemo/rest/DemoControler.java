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
    @Autowired
    public DemoControler(
            @Qualifier("basketballCoach") Coach theCoach,
            @Qualifier("basketballCoach") Coach theAnotherCoach)
    {

        System.out.println("In constructor: "+getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout()
    {
        return myCoach.getDailyWorkout();
    }

    //dodajemy nowy endpoint
    @GetMapping("/check")
    public String check()
    {
        return  "Comparing beans: myCoach == anotherCoach, "+ (myCoach==anotherCoach);
    }
}
