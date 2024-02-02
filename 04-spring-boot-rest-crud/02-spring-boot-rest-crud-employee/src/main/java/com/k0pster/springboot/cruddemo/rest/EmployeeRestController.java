package com.k0pster.springboot.cruddemo.rest;

import com.k0pster.springboot.cruddemo.entity.Employee;
import com.k0pster.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Klasa rest kontroler z adnotacjami @RestController oraz mapowanie na endpoint
@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
    //laczymy sie za pomoca EmployeeService z EmployeeDAO
    private EmployeeService employeeService;
    //wstrzykuje employee dao
    public EmployeeRestController(EmployeeService theEmployeeService)
    {
        employeeService = theEmployeeService;
    }
    //wystawiam endpoint "/employees" i zwracam liste pracownikow
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }
    //wystawiam endpoint na wyszukanie pojedynczego pracownika "/employee/{employeeId}"
    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null)
        {
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        return theEmployee;
    }

    //mappuje dodanie pracownika - POST /employee - @PostMapping
    //w metodzie requestuje po template ciała obiektu pracownika Employee
    //adnotacja @RequestBody. W efekcie jesli w POSTMANIE wyslemy metoda POST
    //odpowiednie ciało dla naszego Employee, pracownik zostanie utworzony.np.
    //{
    //    "firstName" : "Hektor",
    //    "lastName" : "Gonzales",
    //    "email" : "hekgonz@gmail.com"
    //}
    //Używamy firstName i lastName bo takie zmienne zostały przypisane
    //do kolumny fizycznej w bazie danych w obiekcie/klasie Employee:
    //@Column(name="first_name")
    //private String firstName;
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        //w przypadku kiedy zostanie przekazany równiez id
        //musimy sie na taka ewentualnosc przygotowac
        //opcja save zamiast update
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return  dbEmployee;
    }

    //Metoda aktualizacji danych aktualnego pracownika - PUT /employees -
    //uzywamy adnotacji @PutMapping. Znowu metodą tym razem PUT możemy
    //edytować danego pracownika np. o id=6 dodanego przed chwilą
    //{
    //    "id" : 6,
    //    "firstName" : "Tyomoteusz",
    //    "lastName" : "Puchacz",
    //    "email" : "puchacz@gmail.com"
    //}
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        //po prostu save-uje nowe dane
        Employee dbEmployee = employeeService.save(theEmployee);
        //zwracam dbEmployee
        return dbEmployee;
    }

    //dodaje mapping na usuwanie pracownika po id - DELETE /employee
    //w efekcie przesyłajac DELETE bez żadnego body
    //na api/employees/1 z id pracownika usuniemy go z bazy danych.
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        //wyszukuje pracownika po id
        Employee tempEmployee = employeeService.findById(employeeId);
        //wyrzuc wyjatek jesli nie istnieje taki id
        if(tempEmployee == null)
        {
            throw new RuntimeException("Employee id not found = "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employe id - "+ employeeId;
    }
}
