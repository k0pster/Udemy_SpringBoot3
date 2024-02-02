package com.k0pster.springboot.cruddemo.service;

import com.k0pster.springboot.cruddemo.dao.EmployeeRepository;
import com.k0pster.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//dodajemy klasie dziedziczacej adnotacje @Service
@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeRepository employeeRepository;
    //wstrzykujemy zmienna konstruktorem
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository)
    {
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll()
    {
        return employeeRepository.findAll();
    }
    //Uzycie typu kodowania "Optional" zgodnie z JpaRepository
    @Override
    public Employee findById(int theId)
    {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;

        if (result.isPresent())
        {
            theEmployee = result.get();
        }
        else
        {
            throw new RuntimeException("Did not find employe id - "+ theId);
        }
        return theEmployee;
    }
    //notacja @Transactional, która odpowiada za aktualizację
    //nie jest juz potrzebna zostanie wstrzyknieta automatycznie
    @Override
    public Employee save(Employee theEmploye)
    {
        return employeeRepository.save(theEmploye);
    }
    //notacja @Transactional, która odpowiada za aktualizację
    //nie jest juz potrzebna zostanie wstrzyknieta automatycznie
    @Override
    public void deleteById(int theId)
    {
        employeeRepository.deleteById(theId);
    }
}
