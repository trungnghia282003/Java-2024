package com.example.DemoSpring;

import com.example.DemoSpring.model.Person;
import java.util.NoSuchElementException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(PersonRepository repository) {
//        return args -> {
//            Person person = new Person();
//            person.setId(1);
//            person.setName("John");
//
//            repository.save(person);
////            Person saved = repository.findById(person.getId()).orElseThrow(NoSuchElementException::new);
//        };
//    }
}
