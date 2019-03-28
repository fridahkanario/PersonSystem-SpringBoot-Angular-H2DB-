package com.example.demo;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class PersonController {

    @Autowired
    public PersonService personService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/person/findAll")
    public ResponseEntity<Object> list() {
        List<Person> p = personService.findAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("users", p);
        return new ResponseEntity<>(jsonObject, HttpStatus.OK);
    }


    @PostMapping("/person")
    public ResponseEntity<Object> create(@RequestBody Person person){
        personService.create(person);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","User created successfully");
        return  new ResponseEntity<>(jsonObject, HttpStatus.CREATED);
    }
    @PostMapping("/person/login")
    public ResponseEntity<Object> login(@RequestBody Person person){
        boolean valid = personService.login(person);
        System.out.println(valid);
        if(valid){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message","User login successfully");
            return  new ResponseEntity<>(jsonObject, HttpStatus.OK);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","Error");
        return  new ResponseEntity<>(jsonObject, HttpStatus.OK);
    }


}
