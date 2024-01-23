package com.k0pster.springboot.demo.springcoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach()
    {
        System.out.println("In constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Go swim ten pools as a warmup";
    }
}
