//Tworzymy klase Student POJO
package com.k0pster.demo.entity;

//Ddefiniujemy klase obiektu Student
public class Student
{
    //zmienne imie + nazwisko
    private String firstName;
    private String lastName;
    //pusty konstruktor
    public Student()
    {

    }
    //tworzymy konstruktor dla imie+nazwisko
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //tworzymy gettery/settery dla imie+nazwisko
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
}
