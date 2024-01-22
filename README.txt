# Udemy_SpringBoot3
[NEW] Spring Boot 3, Spring 6 & Hibernate for Beginners from Udemy

# 01-spring-boot-overview
Ogólny start aplikacji ze Spring Bootem poprzez https://start.spring.io/. 
Hierarchia plików projektu. Poznanie najważniejszych plików konfiguracyjnych. 
Adnotacje @RestController oraz @GetMapping jako tworzenie endpointów i przegląd 
najważniejszych z nich.(/helth, /info, /mappings, /beans)
Wstępny przegląd zależności SPRING BOOT:
-DEVTOOLS
-ACTUATOR
-SECURITY
Dodawanie własnych properties do aplikacji za pomocą adnotacji @Value i przegląd 
tych najczęściej używanych.

# 02-spring-boot-core
Zasada działania Springa jako wstrzykiwanie zależności. Wstrzykiwanie metodami 
konstruktora (dependency injection) oraz setterem(setter injection).
Przećwiczcenie jak Spring skanuje w tle i wstrzykuje metody odpowiednio do podklas trenerów
np. FooballCoach z klasy pochodzącej z głównej/interfejsowej Coach. Przećwiczenie przypadku,
wyboru i zarządzania, która klasę Spring ma wstrzyknąć jeśli jest kilka metodami z 
użyciem adnotacji @Qualifiers albo @Primary.
