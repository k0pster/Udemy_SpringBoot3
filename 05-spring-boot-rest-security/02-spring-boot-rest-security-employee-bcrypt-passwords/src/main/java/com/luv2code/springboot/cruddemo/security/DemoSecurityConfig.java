package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

//dodajemy adnotacje @Configuration i okreslamy role,hasla i userów
//spring nie użyje teraz userów a z bazdy danych.Dodatkowo użyjemy Bcrypt
//do zahaszhowania haseł użytkowników.
//aby nie używać plain text. Musimy tylko pamietać, żeby zwiększyc limit
//znaków w naszych tabelach SQL. W users musimy zwiekszyc limit znakow na 68
//bcrypt takich używa (`password` char(68) NOT NULL,). 
//Do tego forma hashowania w haslach zmieniamy,
//z {noop} na {bcrypt}. W bazie danych zmieniamy również hasła na hash wygenerowany
//przez kalkulator (https://www.bcryptcalculator.com/)
@Configuration
public class DemoSecurityConfig {

    //Dodatkowowo oczywiście możemy zcustomizować te tabele. Wtedy dopasowujemy
    //nazwy tabel i ról (defaultowo: users, authentication) na takie jakie chcemy.
    //musimy jednak zmienić Spring Security scheme.
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource)
    {
        //możemy strzowyć własne
        //JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        //definiujemy query customowego usera(takie tabele muszą byc w naszej bazie danych)
        //dla zakomentowanego przykładu userzy przechowywani być w members a role w roles
        //[members:user_id, pw, active],[roles:user_id,role]
        //theUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, activate from members where user_id=?");
        //oraz query authentykacje odpowiednich rol
        //theUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return new JdbcUserDetailsManager(dataSource);
    }
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

        http.httpBasic(Customizer.withDefaults());


        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    //Teraz nie musimy hardcodować userów, spring wykona to za nas wiec
    //zakomentowujemy ta sekcje i przenosimy na doł
    /*
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
    */
}
