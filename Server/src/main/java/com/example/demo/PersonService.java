package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;


    public Person create(Person person) {
        return personRepository.save(person);

    }

    public void saveOrUpdate(Person person) {
        personRepository.save(person);
    }


    public boolean login(Person person) {
       Person x =  personRepository.findPeopleByUserName(person.getUserName());

        if (person.getPassword() == x.getPassword() || x != null){
            return true;
        }else {
            return  false;
        }
    }

    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        people = personRepository.findAll();
        return people;
    }
}
