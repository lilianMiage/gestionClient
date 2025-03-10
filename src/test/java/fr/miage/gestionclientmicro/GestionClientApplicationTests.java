package fr.miage.gestionclientmicro;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.miage.gestionclientmicro.entities.Client;
import fr.miage.gestionclientmicro.repo.RepoClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = GestionClientApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
class GestionClientApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private RepoClient repoCompte;
    private Client client;

    @BeforeEach
    void setUp() {

        client = new Client("MyID","Jean","Dupont");
        client = repoCompte.save(client);
    }

    @Test
    void testGet() throws Exception {
        // on teste que le client est bien créé
        MvcResult result = mvc.perform(get("/api/client/MyID"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(client.getId())))
                .andExpect(jsonPath("$.nom", is(client.getNom())))
                .andExpect(jsonPath("$.prenom", is(client.getPrenom())))
                .andReturn();
        System.out.println("Response: " + result.getResponse().getContentAsString());
    }

    @Test
    void testPostClient() throws Exception {
        Client client1 = new Client("MyID","ROUX","Lilian");
        ObjectMapper om = new ObjectMapper();
        String clientJson = om.writeValueAsString(client1);
        // on teste que le client est bien créé
        MvcResult result = mvc.perform(post("/api/client/createClient")
                        .contentType("application/json")
                        .content(clientJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(client1.getId())))
                .andExpect(jsonPath("$.nom", is(client1.getNom())))
                .andExpect(jsonPath("$.prenom", is(client1.getPrenom())))
                .andReturn();
        System.out.println("Response: " + result.getResponse().getContentAsString());
    }

}
