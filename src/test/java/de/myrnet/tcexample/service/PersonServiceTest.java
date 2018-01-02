package de.myrnet.tcexample.service;

import de.myrnet.tcexample.AbstractTestcontainersIntegrationTest;
import de.myrnet.tcexample.dal.model.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;



public class PersonServiceTest extends AbstractTestcontainersIntegrationTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void stupidTest() {
        assertEquals(4, entityManager.createNativeQuery("select 4").getSingleResult());
    }

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
