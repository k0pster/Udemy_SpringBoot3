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
    @Autowired
    public DemoControler(@Qualifier("basketballCoach") Coach theCoach)
    {
        //Tworze w kosntruktorach klas coachów print nazwy klasy
        //tak samo robie w kontrolerze.W efekcie po odpaleniu
        //Ujrzymy inicjalizację bean-ow kazdej z klas. Nastepnie
        //dodam @Lazy do TrackCoach
        System.out.println("In constructor: "+getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout()
    {
        return myCoach.getDailyWorkout();
    }
}
