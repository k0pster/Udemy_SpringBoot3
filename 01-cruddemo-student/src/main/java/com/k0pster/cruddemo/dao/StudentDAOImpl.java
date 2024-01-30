
//klasa student implementujaca interfejs StudentDAO
package com.k0pster.cruddemo.dao;


import com.k0pster.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//Używamy specjalnej adnotacji @Repository
@Repository
public class StudentDAOImpl implements StudentDAO{

    //definiujemy pole dla entityManagera
    private EntityManager entityManager;
    //wstrzykniecie entity managera używając konstruktora
    @Autowired
    public StudentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    //implementacja metody save z adnotacja @Tansactional
    //która zapisze obiekt Student w bazie danych.

    @Override
    @Transactional
    public void save(Student theStudent)
    {
        entityManager.persist(theStudent);
    }

    //metoda odczytujaca studentów z bazy danych
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }
    //metoda listujaca wszystkich studentow z bazy danych
    //posortowanych po nazwiskach
    @Override
    public List<Student> findAll()
    {
        //utworzenie query SQL
        //jako string w createQuery() używamy nazwy klasy
        //z package entity(Student) a nie nazwy tabeli jaki jest w bazie danych(student)
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc",Student.class);
        //zwrócenie rezultatów query
        return  theQuery.getResultList();
    }
    //metoda wyszukujaca studenta po nazwisku
    @Override
    public List<Student> findByLastName(String theLastName)
    {
        //utwozrenie query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        //zastosowanie parametrów (theData= użyty w query, theLastName=przekazywany do metody)
        theQuery.setParameter("theData",theLastName);
        //zwrócenie rezultatów
        return theQuery.getResultList();
    }
    //metoda updatetujaca dane studenta w bazie danych

    @Override
    @Transactional
    public void update(Student theStudent)
    {
        entityManager.merge(theStudent);
    }

    //metoda usuwająca studenta

    //Metoda usuwająca studenta po id

    @Override
    @Transactional
    public void delete(Integer id)
    {

        // wyciagnij studenta po id z bazy danych
        Student theStudent = entityManager.find(Student.class, id);

        // usun go
        entityManager.remove(theStudent);
    }
    //metoda usuwająca wszystkich studentów

    @Override
    @Transactional
    public int deleteAll()
    {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }
}













