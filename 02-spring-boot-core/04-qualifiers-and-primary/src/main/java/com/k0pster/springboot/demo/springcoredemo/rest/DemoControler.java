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
    //Do przekazania Springowi instruckji, jakiego wstrzyknięcia pochodnej
    //klasy Coach sluzy adnotacja @Qualifier, dodajemy jako argument
    //klasy DemoControler, należy jednak pamietac, ze nazwy klas.
    //sa od malych liter. Przekazujemy np. basketballCoach chcac wstrzyknac
    //metode z klasy BasketballCoach.
    //zakomentowane, zeby przeciwiczyc adnotacje @Primary w klasie
    //TrackCoach i metode w niej Spring wstrzyknie.
    @Autowired
    public DemoControler(/*@Qualifier("basketballCoach")*/ Coach theCoach)
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
