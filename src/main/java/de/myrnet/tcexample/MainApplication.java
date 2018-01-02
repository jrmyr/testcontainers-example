package de.myrnet.tcexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

    @Bean
    public String getStringBean() throws Exception {

	    // Sleep a second to let the context load: ALTERNATIVELY, set a debug point to the return and debug
        // The important thing here is that we wait a bit. Then the datasource is available when the tests start
	    Thread.sleep(3 * 1000);

	    return "StringBEAN";
    }

}
