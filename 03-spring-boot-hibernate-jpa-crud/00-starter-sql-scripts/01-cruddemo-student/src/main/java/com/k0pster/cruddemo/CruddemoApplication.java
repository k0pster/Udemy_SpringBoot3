package com.k0pster.cruddemo;

import com.k0pster.cruddemo.dao.StudentDAO;
import com.k0pster.cruddemo.entity.Student;
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
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

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







