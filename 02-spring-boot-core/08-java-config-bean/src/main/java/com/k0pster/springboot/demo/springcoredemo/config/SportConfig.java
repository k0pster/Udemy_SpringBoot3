package com.k0pster.springboot.demo.springcoredemo.config;

import com.k0pster.springboot.demo.springcoredemo.common.Coach;
import com.k0pster.springboot.demo.springcoredemo.common.SwimCoach;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//dodajemy adnotacje @Configuaration
@Configuration
public class SportConfig
{

    //tworzymy beana z id mala litera i nazwa jak ma nasza metoda
    @Bean("aquatic") // jeśli dodamy tutaj customo id beana i go wywoływać
    public Coach swimCoach()
    {
        return new SwimCoach();
    }
}
