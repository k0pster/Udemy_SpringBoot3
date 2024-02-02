package com.k0pster.springboot.cruddemo.entity;

import jakarta.persistence.*;

//Tworzymy notacje @Entity
@Entity
@Table(name="employee")
public class Employee
{
    //definiuje pola tabeli z odpowiednimi adnotacjami
    //id jako PK @Id @GeneratedValue strategia Identity
    //oraz nazwa columny @Column jakie maja tabele w bazie danych
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
    //definiuje konstruktory zaczynajac od nie argumentowego
    public Employee()
    {

    }
    //w drugim nie uwzgledniam ID poniewaz bedzie sie generowal auto
    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    //definiuje gettery/settery

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

    //definiuje metodę toString
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}