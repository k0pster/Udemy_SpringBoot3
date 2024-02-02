package com.k0pster.springboot.cruddemo.dao;

import com.k0pster.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//klasa dziedziczaca po EmployeDAO z adnotacja @Repository
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO
{
    //definiujemy pole dla entity managera
    private EntityManager entityManager;
    //ustawiamy wstrzykniecie przez konstruktor
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager)
    {
        entityManager=theEntityManager;
    }
    @Override
    public List<Employee> findAll()
    {
        //tworze query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        //wykonuje przygotowane query aby otrzymac liste
        List<Employee> employees = theQuery.getResultList();
        //zwracam gotowa liste
        return employees;
    }
    @Override
    public Employee findById(int theId)
    {
        //pobieram konkretnego pracownika z entytiymangera
        Employee theEmployee = entityManager.find(Employee.class,theId);
        //zwracam pracownika
        return theEmployee;
    }
    @Override
    public Employee save(Employee theEmployee) {
        //save pracownika metoda merge gdy isnieteje jakiś rekord
        //jesli nie robimu insert/update
        Employee dbEmployee = entityManager.merge(theEmployee);
        //zwrocenie dbEmployee
        return dbEmployee;
    }
    @Override
    public void deleteById(int theId)
    {
        //znajdz pracownika po Id
        Employee theEmployee = entityManager.find(Employee.class,theId);
        //usun pracownika z entityManagera
        entityManager.remove(theEmployee);
    }
}



