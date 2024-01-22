//Utworzone zostały package rest oraz common. Poprzenoszone zostały tam
//pliki, jednak projekt nadal się buduje. Spróbujmy, więc
//sprawdzić jak zarządzać Springiem, kiedy musimy korzystać z plików poza
//defaultowym scopem. Tworzę nowy packgae com.k0pster.util i tam przenosze
//klasy. Teraz Spring nie będzie sprawdzal defaultowo tego folderu.
//Przy próbie zbudowania aplikacji, dostajemy błąd Application failed to start.
//Aby rozszeszyć skanowanie w poszukiwaniu Beanow przez Springa zakresu
//określamy jakie package ma jeszcze scanować roszerzając paramert scanBasePackages.
//w adnotacji @SpringBootAplication. Wracamy jednak do defaultowych ustawień.


package com.k0pster.springboot.demo.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication(
		scanBasePackages = {"com.k0pster.springboot.demo.springcoredemo",
							"com.k0pster.util"})
 */
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
