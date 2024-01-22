//Tworzymy nowy interfejs springcoredemo/New/Java Class/Interface
// i tworzymy interface Coach.
//Następnie nową klasę footballCoach, która implementuje Coach.
//Następnie nowa klasa, która będzie REST controlerem.
//Aplikacja Spring rusza znajduje klasę DemoControler, która jest
//@RestControler-em. Definiuje ona obiekt myCoach klasy Coach.
//(Coach to interfejs klasy posiada tylko metodę getDailyWorkout().)
//oraz mapuje (@GetMapping) na obiekcie myCoach urlo strona/dailyworkout
//wywołanie metody getDailyWorkout(). Teraz klasa FootballCoach implementuje/
//dziedziczy z klasy Coach. Nadpisujemy metodę getDailyWorkout() (@Overide)
//wyplucie Stringa na mappowany URL.
//[Web browser /dailyworkout->SpringcoredemoApp->DemoControler->wywołanie getDailyWorkout()
//->metoda Coach->metoda FootballCoach->DemoControler->Web]

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
