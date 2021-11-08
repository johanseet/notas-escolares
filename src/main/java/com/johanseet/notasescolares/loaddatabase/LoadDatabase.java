package com.johanseet.notasescolares.loaddatabase;

import com.johanseet.notasescolares.repository.StudentRepository;
import com.johanseet.notasescolares.repository.entities.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(StudentRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Student("María", "Gonzalez", 5, "Kinder")));
            log.info("Preloading " + repository.save(new Student("Jorge", "Contreras", 5 , "Kinder")));
        };
    }
}
