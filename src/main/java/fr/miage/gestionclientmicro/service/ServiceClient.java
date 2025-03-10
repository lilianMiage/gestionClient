package fr.miage.gestionclientmicro.service;

import fr.miage.gestionclientmicro.entities.Client;
import fr.miage.gestionclientmicro.repo.RepoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceClient {

    @Autowired
    private RepoClient repoClient;

    public Client createClient(Client client){
        repoClient.save(client);
        return client;
    }

    public Client getClientById(String id) throws Exception {
        Optional<Client> client = repoClient.findById(id);
        if(client.isEmpty()){
            throw new Exception("Client doesn't exist");
        }
        return client.get();
    }
}
