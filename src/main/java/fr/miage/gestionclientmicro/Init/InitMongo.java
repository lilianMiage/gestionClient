package fr.miage.gestionclientmicro.Init;

import fr.miage.gestionclientmicro.entities.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitMongo {

    @Bean
    CommandLineRunner initDatabase(MongoTemplate mongoTemplate) {
        return args -> {
            Client client = new Client();
            client.setId(UUID.randomUUID().toString());
            client.setNom("Dupont");
            client.setPrenom("Jean");

            mongoTemplate.save(client);
            System.out.println("Client inséré dans MongoDB !");
        };
    }
}
