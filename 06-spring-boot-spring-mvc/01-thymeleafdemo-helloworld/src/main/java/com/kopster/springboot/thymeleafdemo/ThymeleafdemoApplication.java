//rozpoczynamy od stworzenia controlera packages controller/Democontroller
//następnie tworzymy template dla tymeleafa resources/templates
//i dzieki temu mamy stworzone wyswietlanie czasu na serwerze http://localhost:8080/hello
//nadanie przykładowego stylu za pomoca css /resources/static/css/demo.css
package com.kopster.springboot.thymeleafdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafdemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(ThymeleafdemoApplication.class, args);
	}

}
