package de.myrnet.tcexample.service;

import de.myrnet.tcexample.dal.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

    @Test
    public void countTest() {
        List<Person> pList = personService.getAllPersons();
        assertEquals(4, pList.size());
    }

}
