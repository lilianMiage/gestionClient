package fr.miage.gestionclientmicro.repo;

import fr.miage.gestionclientmicro.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoClient extends MongoRepository<Client,String>{

}
