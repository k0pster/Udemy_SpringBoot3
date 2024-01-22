//Tworzymy paczkę dla mycoolapp z klasą FunRestControler
//w której zaimplementowany zostanie prosty REST Controler
//Kontroler to miejsca są wystawiane przez serwer aplikacyjny
//pod konkretnymi adresami URL.
//Jeśli użytkownik wyśle zapytanie pod zdefiniowany wcześniej end-point
//to automatycznie jego zapytanie jest procesowane przez nasz kod,
//a na sam koniec zostaje zwracana odpowiedź.
//REST (representational state transfer) jest sposobem komunikacji
//opartym o protokół HTTP.

package com.k0pster.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Dopisujemy adnotację @RestControler nad klasą a nad metodą w środku
//adnotację @GetMapping()
@RestController
public class FunRestControler {

    //expose "/" that return "Hello World"
    @GetMapping
    public String sayHello()
    {
        return "Hello World!";
    }

    //dodajemy nowy endpoint "workout" aby był dostępny pod http://localhost:8080/workout
    @GetMapping("/workout")
    public String getDailyWorkout()
    {
        return "Run Forest Run!";
    }

    //kolejny przykład endpointa "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune()
    {
        return "Today is your lucky day!";
    }

    //wstrzyknięcie inject zmiennej properties customowej coach.name
    @Value("${coach.name}")
    private String coachName;

    //expose new endpoint do wyświetlenia "teaminfo" aby przetestować
    //działanie
    @GetMapping("/teaminfo")
    public String getTeamInfo()
    {
        return "Coach: "+coachName;
    }
}
