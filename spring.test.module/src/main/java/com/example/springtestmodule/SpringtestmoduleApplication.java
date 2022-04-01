package com.example.springtestmodule;

import com.example.springtestmodule.entities.TestClass;
import com.example.springtestmodule.entities.TestClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringtestmoduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringtestmoduleApplication.class, args);
    }

}
