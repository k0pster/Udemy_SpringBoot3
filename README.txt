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

# 03-spring-boot-hibernate-jpa-crud
Prosta aplikacja CRUD (Create,Read,Upload,Delete) bazy danych studentów.
Bazując na Query do bazy danych.
Konfiguracja bazy danych do MySQL serwera z użyciem użytkownika z dostępem.

# 04-spring-boot-rest-crud
    ##01-spring-boot-rest-crud - Aplikacja RESTowa CRUD do zarzadzania studentami. 
    REST Client <-> REST Service.Zapoznanie z aplikacją Postman. Przykład bindowania endpointów z @PathVariable po indeksie studenta.("/students/{studentId}" zwróci odpowiedniego studenta). 
    Zabezpieczenie się przed przed nie istniejącymi endpointami i przechwycenie możliwych errorów @ExceptionHandler. 
    Określając je w klasie z adnotacją @ControllerAdvice jako globalny exception handler.
    ##02-spring-boot-rest-crud-employee - Prosta aplikacja CRUD bazy danych pracowników w standardzie JPA API. Użycie warstwy @Service.
    ##03-spring-boot-rest-crud-employee-with-spring-data-jpa - Spring sam może utworzyć automatycznie nam DAO CRUDa jak zrobione to zostało dla pracownika (Employee) manualnie.
    Korzystamy w tym celu z zaleźności Spring JPA DATA.Wystarczy dziedziczyć po klasie JpaRepository.
    ##04-spring-boot-rest-crud-employee-with-spring-data-REST -To samo tylko konfigurowanie wszystkich endpointów można uzyskać przy pomocy Springa zależnością Spring DATA REST. 
    Tutaj odbywa się jeszcze mniej wymagań. Potrzebna encja (Entity), dziedziczenie po Intefejsie JpaRepository oraz dodanie w POM zależności:spring-boot-starter-data-rest. 
    Dzieje się to lotnie i żaden kod więcej nie jest wymagany. Odpowiedzi zapytaniach REST otrzymujemy w formacie z metadanymi w formacie HATEOS(Hypermedia as the Engine od Application State), 
    co możemy konifgurować. Używany jest tutaj format HAL(Hypertext Application Language).Zaawansowanie możemy scustomizować query poprzez JPQL i QueryDSL.
# 05-spring-boot-rest-security
    ##00-spring-boot-rest-security-employee-starter-code - Poprzednia aplikacja REST, z różnymi restrykcjami dostępów. Każdy user posiada inne role (EMPLOYEE,MANAGER,ADMIN) mogący używać tylko określonych metod HTTP, wg nadanych restrykcji.
    ##01-spring-boot-rest-security-employee-jdbc-authentication - Poprzednia aplikacja REST, z różnymi restrykcjami dostępów. Teraz jednak nie hardcodujemy w aplikacji userów i ich ról (EMPLOYEE,MANAGER,ADMIN). Dzieki JdbcUserDetailsManager i odpowiednio przygotowanej bazie danych, userzy i role(restrykcje) nadają się zgodnie z tymi, które przchowujemy w bazie danych w oodpowiednich tabelach. Nie jest przez to wymagany np. ciągły restart aplikacji.

