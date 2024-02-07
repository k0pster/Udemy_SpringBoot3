package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//dodajemy adnotacje @Configuration i okreslamy role,hasla i userów
//spring nie użyje teraz userów z aplication.properties a tej klasy.
@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        //tworzymy przykładowych userów
        UserDetails jan = User.builder()
                .username("jan")
                .password("{noop}kowalski") //tutaj określamy zahashowanie hasła
                .roles("EMPLOYEE")
                .build();
        //maria bedzie rowniez managerem
        UserDetails maria = User.builder()
                .username("maria")
                .password("{noop}test") //tutaj określamy zahashowanie hasła
                .roles("EMPLOYEE", "MANAGER")
                .build();
        //i zuzia posiada wszystkie role nawet admina
        UserDetails zuzia = User.builder()
                .username("zuzia")
                .password("{noop}test") //tutaj określamy zahashowanie hasła
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(jan, maria, zuzia);
    }

    //dodajemy konfiguracje restrykcji dla userów
    //jako configurer .requestMachers określamy jaka metoda HTTP
    //jest dozwolona dla jakiej roli.
    //1.skonfigurujemy poglad userow i usera - GET -dla "EMPLOYE"
    //2.dodwac i aktualizowac nowych userow - POST, PUT - dla "MANAGERA"
    //3.usuwać - DELETE - moze tylko "ADMIN"
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE") //1
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE") //1
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER") //2
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER") //2
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN") //3
        );
        //używamy podstawowej authentykacji http
        http.httpBasic(Customizer.withDefaults());

        //wyłączamy Cross Site Request Forgery (CSRF)
        //nie potrzebna na zwykle REST API, używając tylko POST, PUT, DELETE..
        http.csrf(csrf -> csrf.disable());

        //zwracamy builda
        return http.build();
    }
}
