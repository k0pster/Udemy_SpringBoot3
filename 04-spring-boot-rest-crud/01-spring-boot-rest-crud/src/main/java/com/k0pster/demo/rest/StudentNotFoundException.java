package com.k0pster.demo.rest;
//Dziedziczymy po głównej klasie RunTimeException
public class StudentNotFoundException extends RuntimeException
{
    //Tworzymy konstruktory
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
