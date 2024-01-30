<<<<<<< Updated upstream
=======
//Aplikacja stworzona z zależnościami DATA JPA i MYSQL
//Należy śledzić na bieżaco w SQL Workbenchu jak sie zmienia
//stan bazy danych
>>>>>>> Stashed changes
package com.k0pster.cruddemo;

import com.k0pster.cruddemo.dao.StudentDAO;
import com.k0pster.cruddemo.entity.Student;
<<<<<<< Updated upstream
=======
import org.apache.xmlbeans.impl.tool.CommandLine;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
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
			// queryForStudents(studentDAO);

			//metoda czytajaca studentów po nazwisku
			// queryForStudentsByLastName(studentDAO);

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

	private void deleteStudent(StudentDAO studentDAO) {
		//usuniecie studenta o podanym id
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// zwrocenie studenta o podany id
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// zmiana imienia studenta
		System.out.println("Updating student ...");
		myStudent.setFirstName("John");

		// aktualizajca studenta
		studentDAO.update(myStudent);

		// wyswieltenie zaktualizwonaego studenta
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// pobranie listy studentow z nazwiskiem
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		// wyswietlenie pozadanych studentow
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// pobranie listy studentow z bazy
		List<Student> theStudents = studentDAO.findAll();

		// wyswietlenie studentow z bazy
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// tworze obiekt student
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@wp.pl");

		// zapis do bazy
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// wyswietlenie id
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// zwrocenie odpowiedniego studenta
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// wyswietlenie studenta
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// sttworzenie 3 studentow
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John", "Rambo", "john@wp.pl");
		Student tempStudent2 = new Student("Mary", "Jane", "mary@interia.pl");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@onet.pl");

		// zapis studentów
		System.out.println("Saving the students ...");
=======
		//podpniemy się do bazy danych
		//poprzez zdefiniowanie nowego beana dla aplikacji commandLineRunner
		//gdzie zwracamy metodą lambda zwyklego printa Helo World do konsoli

		//Po utworzeniu Iterfejsu i obiektu Student umieszczamy go jako
		//Po uruchomieniu utworzymy w bazie danych tymczasowego studenta

		@Bean
		public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
		{
			return runner -> {
				//tworzę metodę createStudent() do tworzenia studenta
				//createStudent(studentDAO);

				//tworzę metodę createMultipleStudents() do tworzenia 3 studentów
				createMultipleStudents(studentDAO);

				//metoda do odczytywania studentów
				//readStudent(studentDAO);

				//nowa metoda zapytania do bazy danych o listę studentów
				//queryForStudents(studentDAO);

				//metoda wyszukująca studenta po nazwisku.
				//queryForStudentsByLastName(studentDAO);

				//metoda updateujaca studenta
				//updateStudent(studentDAO);

				//metoda usuwajaca studenta po id
				//deleteStudent(studentDAO);

				//metoda usuwająca wszystkich studentów
				//delteAllStudents(studentDAO);
			};
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
	private void createMultipleStudents(StudentDAO studentDAO)
	{
		//Tworzenie 3 obiektów student
		System.out.println("Creating 3 students object...");
		Student tempStudent1 = new Student("Paul", "Gauman","paulieG@wp.pl");
		Student tempStudent2 = new Student("John", "Cena","JC@wp.pl");
		Student tempStudent3 = new Student("Amanda", "Applebaum","bonita@wp.pl");
		//zapisanie obiektów
		System.out.println("Saving the students...");
>>>>>>> Stashed changes
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
<<<<<<< Updated upstream

	private void createStudent(StudentDAO studentDAO) {

		// utworz obiekt Student
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "pauliD@wp.pl");

		// zapis
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// wyswietlenie obiektu
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}







=======
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
		List<Student> theStudents = studentDAO.findByLastName("Cena");
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
>>>>>>> Stashed changes
