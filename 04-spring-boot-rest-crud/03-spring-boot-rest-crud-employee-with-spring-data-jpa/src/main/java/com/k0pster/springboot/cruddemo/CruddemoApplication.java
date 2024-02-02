//Aplikacja CRUD zarządzania pracownikami
//Jak poprzednio jednak korzystając z Spring Data JPA
//tworzenia automatycznego DAO. Tworzymy nowy interfejs EmployeeRepository
//który bedziesz dziedziczyć z JpaRepository. Zmieniamy tylko
//EmployeeServiceImpl kierujac na EmployeeRepository.
package com.k0pster.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

}
