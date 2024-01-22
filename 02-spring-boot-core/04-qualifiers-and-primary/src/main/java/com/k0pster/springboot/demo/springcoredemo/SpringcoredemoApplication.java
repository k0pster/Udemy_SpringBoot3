//Teraz w DemoControlerze ustawimy zarządzaniem w przypadku
//kiedy mamy więcej niż jedną klasę obiektu Coach
//np.FootballCoach, BasketballCoach itd. inaczej Spring
//nie będzie wiedział co wstrzyknąć. Bez ustawień dostaniemy info
//po kompilowaniu failed z powodu "required a single bean, but 4 were found"
//do tego służy adnotacja @Qualifier. Możemy też określic adnotacja
//@Primary w klasie coach co ma sie wykonywac.


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
