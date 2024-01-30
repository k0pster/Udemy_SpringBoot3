
//Interfejs StudentDAO dla obiektu Student

//Tworzymy nowy Interfejs StudentDAO do zapis/odczyt obiektu
//z/do bazy danych oraz klase dziedziczaca StudentDAOImpl

package com.k0pster.cruddemo.dao;

import com.k0pster.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    //metoda dodajaca studenta
    void save(Student theStudent);
    //metoda szukajaca studenta po podanym id
    Student findById(Integer id);
    //metoda szukajaca wszystkich studentow
    List<Student> findAll();
    //metoda szukajaca studenta po nazwisku
    List<Student> findByLastName(String theLastName);
    //metoda updatujaca studenta
    void update(Student theStudent);
    //metoda usuwajaca studenta po id
    void delete(Integer id);
    //metoda usuwajaca wszystkich studentow
    int deleteAll();
}
