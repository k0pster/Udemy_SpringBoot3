<<<<<<< Updated upstream
//klasa student implementujaca interfejs StudentDAO
package com.k0pster.cruddemo.dao;
=======
//klasa StudentDAOImpl dziedziczaca po StudentDAO
package com.k0pster.cruddemo.dao;

>>>>>>> Stashed changes
import com.k0pster.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

<<<<<<< Updated upstream
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
=======
//Używamy specjalnej adnotacji @Repository
@Repository
public class StudentDAOImpl implements StudentDAO{

    //definiujemy pole dla entityManagera
    private EntityManager entityManager;
    //wstrzykniecie entity managera używając konstruktora
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implementacja metody save z adnotacja @Tansactional
    //która zapisze obiekt Student w bazie danych.
>>>>>>> Stashed changes
    @Override
    @Transactional
    public void save(Student theStudent)
    {
        entityManager.persist(theStudent);
    }
<<<<<<< Updated upstream
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
=======

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
>>>>>>> Stashed changes
    @Override
    @Transactional
    public void update(Student theStudent)
    {
        entityManager.merge(theStudent);
    }
<<<<<<< Updated upstream
    //metoda usuwająca studenta
=======
    //Metoda usuwająca studenta po id
>>>>>>> Stashed changes
    @Override
    @Transactional
    public void delete(Integer id)
    {
<<<<<<< Updated upstream
        // wyciagnij studenta po id z bazy danych
        Student theStudent = entityManager.find(Student.class, id);

        // usun go
        entityManager.remove(theStudent);
    }
    //metoda usun wszystkich studentów i zwróc ilosc usunietych pozycji
=======
        //wyciagniecie studenta po id
        Student theStudent = entityManager.find(Student.class,id);
        //usuniecie studenta po id
        entityManager.remove(theStudent);
    }
    //metoda usuwająca wszystkich studentów
>>>>>>> Stashed changes
    @Override
    @Transactional
    public int deleteAll()
    {
<<<<<<< Updated upstream

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }
}










=======
        int numRowsDelted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDelted;
    }


}
>>>>>>> Stashed changes
