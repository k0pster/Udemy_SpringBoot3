package com.k0pster.springboot.cruddemo.service;

import com.k0pster.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService
{
    //definiuje metody dla interfejsu
    List<Employee> findAll();

    //metoda zwracajaca pracownika po Id
    Employee findById(int theId);
    //atkualizowanie obiektu
    Employee save(Employee theEmploye);
    //usuniecie obiektu
    void deleteById(int theId);
}
