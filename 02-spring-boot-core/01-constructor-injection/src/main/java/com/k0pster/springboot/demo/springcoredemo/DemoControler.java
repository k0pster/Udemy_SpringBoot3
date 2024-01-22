package com.k0pster.springboot.demo.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//dodajemy adnotacje @RestControler
@RestController
public class DemoControler
{
    //Tworzymy konstruktor klasy do wstrzyknięcia.
    //w tym celu tworzymy prywatne pole dla dependecji
    private Coach myCoach;

    //i definiujemy konstruktor
    @Autowired
    public DemoControler(Coach theCoach)
    {
        myCoach = theCoach;
    }
    //Tworzmymy mapowanie na url strony/dailyworkout
    //gdzie wywołujemy metodę gerDailyWorkout()
    @GetMapping("/dailyworkout")
    public String getDailyWorkout()
    {
        return myCoach.getDailyWorkout();
    }
}
