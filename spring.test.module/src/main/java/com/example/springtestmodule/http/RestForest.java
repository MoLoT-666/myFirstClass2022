package com.example.springtestmodule.http;

import com.example.springtestmodule.entities.TestClass;
import com.example.springtestmodule.entities.TestClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestForest {

    @Autowired
    public TestClassRepository repository;

    @GetMapping("/save")
    public String greeting(@RequestParam(value = "name", defaultValue = "no name") String name,
                           @RequestParam(value = "idname", defaultValue = "0") int idname){
        TestClass testClass = new TestClass();
        testClass.setName(name);
        testClass.setIdname(idname);

        try {
            repository.save(testClass);
        } catch (Exception e) {
            return "Error muther fucker!";
        }

        return "This is SPARTA!!!!";
    }

    @GetMapping("/find")
    public List<TestClass> find() {
        return repository.findAll();
    }
}