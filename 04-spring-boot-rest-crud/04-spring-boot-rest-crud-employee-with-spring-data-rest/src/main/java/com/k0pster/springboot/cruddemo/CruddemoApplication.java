//Aplikacja CRUD zarządzania pracownikami
//Jak poprzednio jednak korzystając również z Spring Data REST
//do generownaia automatycznego endpointów i mappowania ich.
//Należy jedynie dodać w pom.xml projektu zależność
//spring-boot-starter-data-rest. Wiecej kodu nie ma potrzeby umieszczać!
//paczki z rest i service nie sa nam juz wiecej potrzebne!
//endpointy stworza sie po l.mnogiej podanej encji w Entity zmieniajac pierwsza
//litere na mała, więc w naszym przypadku Employees (dodane zostało s = "/localhost:8080/employees")
//Oczywiście możemy to też edytować poprzez dodanie nowego patha
//@RepositoryRestResource(path="members")- dzieki czemu taki byłby endpoint.
// ("/localhost:8080/mebmers")
//możemy konfigurować dodatkowy path w application.properties
//i możemy po ID szukać przez /magic-api/employee/id
//PUT działa podobnie przez /magic-api/employees/id
//DELETE przez /magic-api/employees/id

package com.k0pster.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

}
