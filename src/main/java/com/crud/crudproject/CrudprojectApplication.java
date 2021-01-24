package com.crud.crudproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.crud.crudproject.repository")
@EnableTransactionManagement
@EntityScan(basePackages="com.crud.crudproject.model")
public class CrudprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudprojectApplication.class, args);
    }

}
