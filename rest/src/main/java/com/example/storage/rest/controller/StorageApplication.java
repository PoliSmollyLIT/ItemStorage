package com.example.storage.rest.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.storage"})
//@EntityScan(basePackages = {"com.example.storage.persistance.models"})
//@EnableJpaRepositories(basePackages = {"com.example.storage.persistance.repositories"})
@ComponentScan(basePackages = {"com.example.storage"})
@EntityScan(basePackages = {"com.example.storage.persistance.models"})
@EnableJpaRepositories(basePackages = {"com.example.storage.persistance.repositories"})
public class StorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }

}
