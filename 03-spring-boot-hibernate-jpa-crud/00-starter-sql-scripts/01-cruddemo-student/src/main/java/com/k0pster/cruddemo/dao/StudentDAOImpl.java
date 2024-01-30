//klasa student implementujaca interfejs StudentDAO
package com.k0pster.cruddemo.dao;
import com.k0pster.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Na klasie oznaczamy adnotacje @Repository
@Repository
public class StudentDAOImpl implements StudentDAO {

    // Definiujemy EntityManagera
    private EntityManager entityManager;

    // wstrzykujemy managera, metoda konstruktora
    @Autowired
    public StudentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    // metoda save, używamy adnotacji @Transactional,
    // któa jest niezbędna jeżeli updatujemy coś na bazie danych
    @Override
    @Transactional
    public void save(Student theStudent)
    {
        entityManager.persist(theStudent);
    }
    //metoda wyszukiwania studenta po Id
    @Override
    public Student findById(Integer id)
    {
        return entityManager.find(Student.class, id);
    }
    //metoda wyszukująca wszystkich studentów
    @Override
    public List<Student> findAll() {
        // stworzenie query poprzez createQuery i w argumencie podajemy Student czyli nazwę klasy
        // z entity(encji) anie nazwe tabeli bazy danych.
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // zwracamy przygotowane query
        return theQuery.getResultList();
    }
    //metoda wyszukujaca po nazwisku
    @Override
    public List<Student> findByLastName(String theLastName) {
        // tworze query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                                        "FROM Student WHERE lastName=:theData", Student.class);

        // ustaw parametry theData to nazwisko w query, theLastName przekazywany parametr.
        theQuery.setParameter("theData", theLastName);

        // zwracam query
        return theQuery.getResultList();
    }
    //metoda aktualizujaca Studenta
    @Override
    @Transactional
    public void update(Student theStudent)
    {
        entityManager.merge(theStudent);
    }
    //metoda usuwająca studenta
    @Override
    @Transactional
    public void delete(Integer id)
    {
        // wyciagnij studenta po id z bazy danych
        Student theStudent = entityManager.find(Student.class, id);

        // usun go
        entityManager.remove(theStudent);
    }
    //metoda usun wszystkich studentów i zwróc ilosc usunietych pozycji
    @Override
    @Transactional
    public int deleteAll()
    {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }
}










