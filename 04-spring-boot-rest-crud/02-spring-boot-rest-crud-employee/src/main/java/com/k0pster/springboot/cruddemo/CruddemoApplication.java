//Aplikacja CRUD zarządzania pracownikami
//Tworzymy obiekt w /entity Employee następnie interfejs DAO(EmployeeDAO),
//klase dziedziczaca(EmployeeDAOJpaImpl) po interfejsie
//oraz REST controller do zarzadzania DAO(EmployeeRestController)
//Nastepnie dodamy warstwe servicowa(@Service) pomiedzy REST controler a EpmployeeDAO
//Aby móc w przyszłosci dodać jakiś inny DAO np.PayrollDAO itp.
package com.k0pster.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

}
