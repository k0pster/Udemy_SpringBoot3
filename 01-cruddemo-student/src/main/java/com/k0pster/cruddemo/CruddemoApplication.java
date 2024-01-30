//Aplikacja stworzona z zależnościami DATA JPA i MYSQL
//Należy śledzić na bieżaco w SQL Workbenchu jak sie zmienia
//stan bazy danych

package com.k0pster.cruddemo;

import com.k0pster.cruddemo.dao.StudentDAO;
import com.k0pster.cruddemo.entity.Student;

import org.apache.xmlbeans.impl.tool.CommandLine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			// metoda dodajaca studenta
			// createStudent(studentDAO);

			//metoda dodajaca 3 studentów
			//createMultipleStudents(studentDAO);

			//metoda czytajaca studenta
			// readStudent(studentDAO);

			//metoda czytajaca wszystkich studentów
			//queryForStudents(studentDAO);

			//metoda czytajaca studentów po nazwisku
			//queryForStudentsByLastName(studentDAO);

			//metoda aktualizujaca studenta
			// updateStudent(studentDAO);

			//metoda usuniecia studenta
			// deleteStudent(studentDAO);

			//metoda usuwajaca wszystkich studentów
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		//usuniecie wszystkich studentow
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// sttworzenie 3 studentow
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John", "Rambo", "john@wp.pl");
		Student tempStudent2 = new Student("Mary", "Jane", "mary@interia.pl");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@onet.pl");

		// zapis studentów
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		System.out.println("Saving the students ...");
	}

	//metoda createStudent
	private void createStudent(StudentDAO studentDAO)
	{
		//Tworzenie obiektu student
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Gauman","paulieG@wp.pl");
		//zapisanie obiektu
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		//wyswietlenie id zapisanego studenta
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}

	//metoda odczytujaca obikety student z bazy danych
	private void readStudent(StudentDAO studentDAO)
	{
		//utworzenie i zapisanie tymczasowego studenta
		System.out.println("Creating student...");
		Student tempStudent = new Student("Abraham", "Lincoln","ALincoln55@wp.pl");
		studentDAO.save(tempStudent);
		//wyswietlenie id zapisanego studenta
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+theId);
		//zwrócenie studentow bazujac na id
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent = studentDAO.findById(theId);
		//wyswietlenie
		System.out.println("Foud the student: "+myStudent);
	}
	//metoda odczytynia z bazy danych wszystkich studentów
	//poprzez query i wypisanie ich posortowanych po nazwiskach
	private void queryForStudents(StudentDAO studentDAO)
	{
		//pobranie listy studentów
		List<Student> theStudents = studentDAO.findAll();
		//wyświetlenie listy studentów posor
		for (Student tempStudent : theStudents)
		{
			System.out.println(tempStudent);
		}
	}

	//metoda wyszukujaca i wyswietlajaca liste studentów po nazwisku
	private void queryForStudentsByLastName(StudentDAO studentDAO)
	{
		//pobranie listy studentów
		List<Student> theStudents = studentDAO.findByLastName("Rambo");
		//wyswietlenie listy studentów
		for (Student tempStudent : theStudents)
		{
			System.out.println(tempStudent);
		}
	}

	//metoda updatujaca studenta
	private void updateStudent(StudentDAO studentDAO)
	{
		//wyciagniecie studenta z bazy po id
		int studentId = 1;
		System.out.println("Getting student with id : "+studentId);
		Student myStudent = studentDAO.findById(studentId);
		//zmiana imienia na "Paul"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Paul");
		//updete studenta do bazy
		studentDAO.update(myStudent);
		//wyswietlenie zaktualizowanego studenta
		System.out.println("Updated student: "+myStudent);
	}

	//metoda usuwająca studenta po Id
	private void deleteStudent(StudentDAO studentDAO)
	{
		int studentId = 3;
		System.out.println("Deleting student id: 3");
		studentDAO.delete(studentId);
	}
	//metoda usuwająca wszystkich studentów
	private void delteAllStudents(StudentDAO studentDAO)
	{
		System.out.println("Deleting all students");
		int numRowsDelted = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsDelted);
	}
}

