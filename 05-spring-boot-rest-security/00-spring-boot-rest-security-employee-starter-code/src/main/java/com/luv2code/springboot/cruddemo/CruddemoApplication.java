//Po aktywacji Spring Boot Security, defaultowo tworzy sie
//user z dostepem do naszego localhosta. Hasło generuje sie
//w konsoli podczas uruchamiania programu. Żeby je modyfikować
//używamy pliku konfiguracyjnego aplication.properties
//Aby przydzielac userom odpowiednie role, np admin, pracownik
//Tworzymy Springowa @Configuration (security pkg)  notacje i tam określamy odpowiednie role
//userów i hasła. Nastepnie konfigurujemy restrykcje dla userow co mogą robić.
//tworzymy nowa klase SecurityFilterChain.
package com.luv2code.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

}
