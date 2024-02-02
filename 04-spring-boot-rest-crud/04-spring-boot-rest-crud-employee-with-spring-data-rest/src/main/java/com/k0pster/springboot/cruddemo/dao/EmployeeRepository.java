package com.k0pster.springboot.cruddemo.dao;

import com.k0pster.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Aby załadować automatycznie DAO i metody RESTowe w taki sam sposób,
//wystarczy intefejs dziedziczyć po JpaRepository podajac
// tylko Entity type - Employee oraz typ dla Primary Key - Integer
//@RepositoryRestResource(path="members") - gdybysmy to dodali endpoint byłby /members
//zamiast /employees
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
    //to wystarczy do generowania automatycznego wszystkich metod :)
    //Metody CRUD poprzednie zostana wstrzyknięte w tle.
}
