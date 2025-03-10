package fr.miage.gestionclientmicro.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    private Long id;

    private String nom;

    private String prenom;

    private List<Comptes> comptes;
}
