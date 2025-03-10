package fr.miage.gestionclientmicro.entities;

import com.mongodb.client.internal.ClientEncryptionImpl;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@Jacksonized
@Document(collection = "client")
public class Client {

    @Id
    private String id;

    private String nom;

    private String prenom;

    public Client(){

    }

    public Client(String id,String nom,String prenom){
        this.id = id;
        this.nom= nom;
        this.prenom=prenom;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
