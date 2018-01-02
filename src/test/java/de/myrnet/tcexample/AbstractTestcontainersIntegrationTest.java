package de.myrnet.tcexample;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.ImageFromDockerfile;

import static org.testcontainers.containers.BindMode.READ_ONLY;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = AbstractTestcontainersIntegrationTest.Initializer.class)
public abstract class AbstractTestcontainersIntegrationTest {

    @ClassRule
    public static GenericContainer preparedPostgres =
            new GenericContainer(new ImageFromDockerfile().withFileFromClasspath("Dockerfile", "tc-org/Dockerfile"))
                    .withClasspathResourceMapping(
                            "tc-org/ddl_init.sql", "/docker-entrypoint-initdb.d/ddl_init.sql", READ_ONLY)
                    .withClasspathResourceMapping(
                            "tc-org/dml_person.csv", "/docker-entrypoint-initdb.d/dml_person.csv", READ_ONLY)
        ;

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            EnvironmentTestUtils.addEnvironment("testcontainers", configurableApplicationContext.getEnvironment(),
                    "tc.datasource.host=" + preparedPostgres.getContainerIpAddress(),
                    "tc.datasource.port=" + preparedPostgres.getMappedPort(5432)
            );
        }
    }

}
