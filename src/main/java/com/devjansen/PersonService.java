package com.devjansen;


import com.devjansen.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    //metodo para lista person
    public List<Person> findAll() {
        logger.info("Finding all People!");

        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }
    //metodo para lista um person
    public Person findById(String id) {
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Jhonata");
        person.setLastName("Jansen");
        person.setAddress("Santa Catarina - Brasil");
        person.setGender("Male");
        return person;
    }

    //metodo create
    public Person create(Person person) {
        logger.info("Creating one Person!");
        return person;
    }

    //metodo para atualiza dados de person
    public Person update(Person person) {
        logger.info("Updating one Person!");
        return person;
    }

    //metodo para deleta um person
    public void delete(String id) {
        logger.info("Deleting one Person!");
    }

    //moche de person
    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Some Address in Brasil");
        person.setGender("Male");
        return person;
    }

}
