package fr.miage.gestionclientmicro.controller;

import fr.miage.gestionclientmicro.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;

@RestController
@RequestMapping("/api/client")
public class ControllerClient {

    @Autowired
    private ServiceClient serviceClient;


}
