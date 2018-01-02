package de.myrnet.tcexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainApplicationTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void postgresDriverTest() {
        assertEquals(4, entityManager.createNativeQuery("select 4").getSingleResult());
    }

}
