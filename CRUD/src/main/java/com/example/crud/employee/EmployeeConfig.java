package com.example.crud.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            Employee rowan = new Employee(
                    "Rowan",
                    "Whitethorn",
                    "Jr.",
                    LocalDate.of(1999, JANUARY, 1),
                    "Married",
                    "British"
            );
            Employee aelin = new Employee(
                    "Aelin Ashryver",
                    "Galathynius",
                    null,
                    LocalDate.of(1999, SEPTEMBER, 7),
                    "Married",
                    "American"
            );
            Employee leon = new Employee(
                    "Leon Scott",
                    "Kennedy",
                    null,
                    LocalDate.of(1997, FEBRUARY, 14),
                    "Single",
                    "American"
            );
            Employee claire = new Employee(
                    "Claire",
                    "Redfield",
                    null,
                    LocalDate.of(1999, MARCH, 15),
                    "Single",
                    "American"
            );
            Employee ethan = new Employee(
                    "Ethan",
                    "Winters",
                    null,
                    LocalDate.of(1995, APRIL, 19),
                    "Married",
                    "Swedish"
            );

            repository.saveAll(
                    List.of(rowan, aelin, leon, claire, ethan)
            );

        };
    }
}
