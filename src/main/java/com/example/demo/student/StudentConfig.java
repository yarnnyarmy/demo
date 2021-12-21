package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
                    Student mariam = new Student(
                            "James Jones",
                            "123@gmail.com",
                            LocalDate.of(1995, Month.MAY,14)
                    );

            Student alex = new Student(
                    "Alex Smith",
                    "alex@gmail.com",
                    LocalDate.of(1965, Month.JANUARY,17)
            );

            repository.saveAll(List.of(mariam, alex));
        };
    }
}
