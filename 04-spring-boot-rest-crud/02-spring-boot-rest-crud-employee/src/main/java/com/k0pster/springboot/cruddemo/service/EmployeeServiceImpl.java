package com.k0pster.springboot.cruddemo.service;

import com.k0pster.springboot.cruddemo.dao.EmployeeDAO;
import com.k0pster.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//dodajemy klasie dziedziczacej adnotacje @Service
@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeDAO employeeDAO;
    //wstrzykujemy zmienna konstruktorem
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO)
    {
        employeeDAO = theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll()
    {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId)
    {
        return employeeDAO.findById(theId);
    }
    //aktualizujemy baze danych wiec dodajemy notacje @Transactional
    @Transactional
    @Override
    public Employee save(Employee theEmploye)
    {
        return employeeDAO.save(theEmploye);
    }
    @Transactional
    @Override
    public void deleteById(int theId)
    {
        employeeDAO.deleteById(theId);
    }
}
