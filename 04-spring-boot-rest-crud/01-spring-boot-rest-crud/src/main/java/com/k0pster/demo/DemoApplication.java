//Aplikacja REST CRUD oraz nauka aplikacji POSTMan
//Tworze odrebny package w projekcie o nazwie rest
//nastepnie umieszczam w nim klase DemoRestController
//na adresie localhost:8080/test/hello uzyskuje powitanie
//aplikacja bedzie REST servicem studentow.

//JSON Data Binding to konwersja JSON <-> Java POJO
//w Springu zajmuje się tym Jackson Project
//Tworzymy obiekt Student, w packagu entity.
//Oraz StudentRestControler w packagu rest.

//definijuemy endpoint dla każdego indexu studenta "/students/{studentId}"
//korzystamy z adnotacji @PathVariable i binudjemy po studentId
//oraz przygotowujemy odpowiednia klase StudentErrorResponse
//przechwytujaca możliwe błedy dostepu StudentNotFoundException
//lub do endpointa (np.error przekroczenia zakresu)
//Aby lepiej nimi zarzadzac globalnie wykorzystamy adnotacje @ControlerAdvice
//i w klasie StudentRestExceptionHandler umieścimy nasze stworzone
//exception handlery.


package com.k0pster.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
