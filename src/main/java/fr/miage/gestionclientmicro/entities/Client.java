package fr.miage.gestionclientmicro.entities;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Jacksonized
@Document(collection = "client")
public class Client {

    @Id
    private String id;

    private String nom;

    private String prenom;
}
