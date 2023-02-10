package com.gestionStock.stockgestion.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
