package fr.miage.gestionclientmicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GestionClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionClientApplication.class, args);
    }

}
