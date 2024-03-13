package com.kopster.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//dodajemy adnotacje Controller do klasy kontrolera
@Controller
public class HelloWorldController
{
    //stworzenie kontrolera metod do inicjalizacji formularza HTML
    //na http://localhost:8080/showForm
    //Używając @RequestMapping otwieramy się na wszystkie metody
    //SPecyfikujemy tylko na GET używając GETMapping();
    @GetMapping("/showForm")
    public String showForm()
    {
        return "helloworld-form";
    }
    //stworzenie kontrolera do procesowania formularza HTML
   @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloworld";
    }
    //dodanie kontrolera metod do odczytywania danych z formularza
    //i dodanie ich do modelu. Np. Stworzymy model zwiekszający litery
    //imitujący krzyk.

    //metoda krzyczaca pobierajaca request i model
    @RequestMapping("/processFormVersionTwo")
    public String letShout(HttpServletRequest request, Model model)
    {
        //wczytanie parametrów formularza HTML
        String theName = request.getParameter("studentName");
        //konwersja na duże litery
        theName = theName.toUpperCase();
        //utworzenie wiadomości
        String result = "Yo! "+ theName;
        //dodanie jej do modelu
        model.addAttribute("message", result);

        return "helloworld";
    }
    //teraz to samo ale przy pomocy auto bindowania Stringa

    //zamiast requestu używamy @RequestParam zczytyjac studentName do Stringa theName
    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model)
    {
        //zostaje nam jedynie manipulacja
        //konwersja na duże litery
        theName = theName.toUpperCase();
        //utworzenie wiadomości
        String result = "Spring teraz wita z ver.3: "+ theName;
        //dodanie jej do modelu
        model.addAttribute("message", result);

        return "helloworld";
    }
}
