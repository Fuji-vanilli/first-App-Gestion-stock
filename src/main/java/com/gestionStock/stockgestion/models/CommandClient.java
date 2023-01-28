package com.gestionServer.gestionServer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class CommandClient extends AbstractEntity{

    private String reference;

    private Instant dateCommande;

    @ManyToOne
    @JoinColumn(name= "idClient")
    private Client client;

    @OneToMany(mappedBy = "commandClient", fetch = FetchType.LAZY)
    private List<LigneCommandClient> ligneCommandClientList;
}
