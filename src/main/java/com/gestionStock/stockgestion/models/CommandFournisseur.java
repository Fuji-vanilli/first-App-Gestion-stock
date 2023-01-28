package com.gestionServer.gestionServer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class CommandFournisseur extends AbstractEntity {

    private String code;

    private Instant dateCommand;

    @ManyToOne
    @JoinColumn(name= "idFournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commandFournisseur", fetch = FetchType.LAZY)
    private List<LigneCommandFournisseur> ligneCommandFournisseur;
}
