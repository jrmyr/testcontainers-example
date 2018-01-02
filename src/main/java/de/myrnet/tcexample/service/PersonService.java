package de.myrnet.tcexample.service;

import de.myrnet.tcexample.dal.model.Person;
import de.myrnet.tcexample.dal.repo.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findValidPersons(String lastname) {
        List<Person> persons = personRepository.findByLastname(lastname);

        return persons.stream()
                .filter(n -> !"müller".equalsIgnoreCase(n.getLastname()))
                .filter(n -> !"schmitz".equalsIgnoreCase(n.getLastname()))
                .collect(Collectors.toList());
    }

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

}
