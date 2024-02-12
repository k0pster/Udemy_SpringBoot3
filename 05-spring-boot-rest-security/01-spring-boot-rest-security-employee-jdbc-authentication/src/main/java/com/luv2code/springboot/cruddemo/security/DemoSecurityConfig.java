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
//spring nie użyje teraz userów z aplication.properties a tej klasy.
@Configuration
public class DemoSecurityConfig {

    //dodajemy wsparcie dla JDBC, więc nie musimy wpisywać i kododwać recznie userow
    //zakomentowana sekcja na dole. Teraz w UserDetailsManagerze po prostu
    //zwracamy datasource poprzez JdbcUserDetailsManager.
    //Wcześniej jednak w bazie danych musimy miec przygotowany odpowiedni
    //układ tabel: users[username,password,enabled], authorities[username,authority]
    //gdzie określamy userów i ich role jak poprzednio jednak teraz dzieje
    //się to automatycznie bazując na danych w badzie danych. Nie musimy restartować
    //cały czas aplikacji.
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource)
    {
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
