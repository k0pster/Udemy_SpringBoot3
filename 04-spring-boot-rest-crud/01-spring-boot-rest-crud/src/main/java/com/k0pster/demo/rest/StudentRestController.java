package com.k0pster.demo.rest;

import com.k0pster.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//dodaje adnotacje @RestControler i nadaje ednpoint poprzez @RequestMapping
@RestController
@RequestMapping("/api")
public class StudentRestController
{
    //Tworze pusta Arrayliste do przechowania studentow
    private List<Student> theStudents;

    //Defidniujem @PostConstructor do załadowania danych studentów tylko raz
   @PostConstruct
    public void loadData()
    {
        //Inicjalizujemy pustą tabelę na studentów
        theStudents = new ArrayList<>();
        //dodaje do listy przykladowych studentów
        theStudents.add(new Student("Andrzej","Ziemniak"));
        theStudents.add(new Student("Jarek","Dolas"));
        theStudents.add(new Student("Anita","Kwiat"));
    }
    //definiuje endpoint dla "/students" - zwracający listę studentów
    //dostep do endpointu "/api/students"
    @GetMapping("/students")
    public List<Student> getStudents()
    {
        //dzieki @PostConstructowi metoda getStudents()
        //zwraca tylko liste studentow, która została już załadowana
        return theStudents;
    }

    //definijuemy endpoint dla każdego indexu studenta "/students/{studentId}"
    //korzystamy z adnotacji @PathVariable i binudjemy po studentI
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        //w efekcie na endpoincie "/students/0" otrzymamy tylko pierwszego studenta
        //z listy. Musimy wiec sprawdzic czy studentId jest na liscie
        //i przechwycic ewentualne błedy(StudentErrorRespons,StudetnNotFoundException)

        //Jesli id jest wieksze lub równe rozmiarowi listy studentów,
        //albo lista jest pusta ma być rzucany error.
        if ( (studentId >= theStudents.size()) || (studentId < 0))
        {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        //jesli nie blok if nie przekieruje na blad zwracamy obiekt z listy po odpowiednim Id
        return theStudents.get(studentId);
    }
}





