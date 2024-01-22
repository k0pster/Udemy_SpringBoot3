package com.k0pster.springboot.demo.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
//Tutaj możemy również użyć adnotacji @Primary,
//wtedy nie powinno jej się używac z adnotacją @Qualifier
//Jeśli więc zakomentujemy @Qualifier w klasie DemoControler
//a dodamy tutaj @Primary, Spring będzie wiedział,
//żeby wstrzyknąc ja przy uzyciu metody z klasu Coach
//można uzywac tylko jednej klasy jako @Primary

@Component
@Primary
public class TrackCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Run a 5k as fast as you can!";
    }
}
