<<<<<<< Updated upstream
=======
//Tworzę nową klasę student, która będzie tabelą w bazie danych
>>>>>>> Stashed changes
package com.k0pster.cruddemo.entity;

import jakarta.persistence.*;

<<<<<<< Updated upstream
@Entity
@Table(name="student")
public class Student {

    // define pola dla primary key używamy @Id adnotacji oraz @GeneratedValue jako IDENTITY
    //Okreslamy równiez kolumny
=======
//Musimy użyć adnotacje @Entity oraz @Table,
//aby stworzyć tabele oraz dodajemy pola wymagane w tabeli
@Entity
@Table(name="student")
public class Student
{
    //definiujemy pola
>>>>>>> Stashed changes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

<<<<<<< Updated upstream
    // define constructors
    public Student() {
=======
    //definiujemy konstruktor
    public Student()
    {
>>>>>>> Stashed changes

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
<<<<<<< Updated upstream

    // define getters/setters

=======
    //definiujemy get/settery
>>>>>>> Stashed changes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

<<<<<<< Updated upstream

    // define toString() method

=======
    //definiujemy toString() metode do wyświetlania zawartości tabeli
>>>>>>> Stashed changes
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
