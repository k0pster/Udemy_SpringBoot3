//Tworze w kosntruktorach klas coachów print nazwy klasy
//tak samo robie w kontrolerze.W efekcie po odpaleniu
//Ujrzymy inicjalizację bean-ow kazdej z klas. Nastepnie
//dodam @Lazy do TrackCoach. Aby zmienić to globalnie możemy to
//zrobić w properties


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
