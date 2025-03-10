package fr.miage.gestionclientmicro.controller;

import fr.miage.gestionclientmicro.entities.Client;
import fr.miage.gestionclientmicro.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;

@RestController
@RequestMapping("/api/client")
public class ControllerClient {

    @Autowired
    private ServiceClient serviceClient;

    @PostMapping("/createClient")
    public Client createClient(@RequestBody Client client){
        return serviceClient.createClient(client);
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable String id) throws Exception {
        return serviceClient.getClientById(id);
    }

}
