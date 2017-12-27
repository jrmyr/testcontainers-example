package de.myrnet.tcexample.service;

import de.myrnet.tcexample.dal.model.Person;
import de.myrnet.tcexample.dal.repo.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void findValidPersons() {
        List<Person> pList = personService.findValidPersons("Schmidt");

        assertFalse(pList.isEmpty());
        assertEquals(pList.size(), 1);
    }

}
