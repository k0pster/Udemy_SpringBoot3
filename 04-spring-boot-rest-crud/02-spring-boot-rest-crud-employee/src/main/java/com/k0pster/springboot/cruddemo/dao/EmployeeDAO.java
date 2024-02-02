package com.k0pster.springboot.cruddemo.dao;

import com.k0pster.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO
{
    //metoda zwracajaca liste pracownikow
    List<Employee> findAll();

    //metoda zwracajaca pracownika po Id
    Employee findById(int theId);
    //atkualizowanie obiektu
    Employee save(Employee theEmploye);
    //usuniecie obiektu
    void deleteById(int theId);

}
