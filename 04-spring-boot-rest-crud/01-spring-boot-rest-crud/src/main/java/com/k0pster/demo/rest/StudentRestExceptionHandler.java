package com.k0pster.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//okreslamy klase za pomoca adnotacji @ControllerAdvice
//i przenosimy tutaj nasze wczesniej napisane ExceptionHandlery.
@ControllerAdvice
public class StudentRestExceptionHandler
{
    //Dodajemy exception hanlder za pomoca adnotacji @ExceptionHandler
    //Adnotacja określa, że na metodzie typ zwrotny(StudentErrorResponse)
    //i co zamierzamy przechwycić(StudentNotFoundException) jeśli taki wystąpi
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
    {
        //tworzymy StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        //ustawiam na tym błędzie status wystapienie 404
        error.setStatus(HttpStatus.NOT_FOUND.value());
        //jaka ma byc wiadomosc
        error.setMessage(exc.getMessage());
        //oraz timestamp
        error.setTimeStamp(System.currentTimeMillis());

        //zwracam ResponseEntity jako body podaje error
        //jako status code na 404
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
        //dostaniemy dzieki temu nie error 505 serwera tylko
        //nasza sformatowana wiadomosc ze takiego student id nie ma
        //w naszej bazie
    }

    //dodajemy kolejny exception handler łapiący już wszystkie inne wyjatki
    //np podanie liter zamiast int w iD

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc)
    {
        //tworze StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        //ustawiam status,message oraz timestamp
        //ale dla statusu Bad request 400
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Adres nie znaleziony. Wyamagana wartość int"); //możemy modyfikować
        error.setTimeStamp(System.currentTimeMillis());
        //zwracamy ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
        //w efekcje przy podaniu endpointa "/students/jakasliter"
        //zamiast znaku int otrzymamy poprawny JSON error.
    }
    //Zostały one tutaj przeniesione z wczesniejszej klasy StudentRestController
}