//Scope beanow defaultowo to singelton, czyli odwoluja sie do tego
//obiektu (referencji) sprawdzmy to. W rezultacie po zbudowaniu projektu
//uzyskamy potwierdzenie na endpoincie stron/check myCoach == anotherCoach, true
//klasy wskazuja na te same obiekty. Aby to zmienić musimy zmienić domyślny
//scope z Singeltona na Prototyp w klasie.



package com.k0pster.springboot.demo.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
