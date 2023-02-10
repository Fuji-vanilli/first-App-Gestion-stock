package com.gestionStock.stockgestion.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Fournisseur extends AbstractEntity{

    private String firstName;
    private String lastName;

    @Embedded
    private Adress adress;
    private String photo;
    private String email;
    private String tel;

    @OneToMany(mappedBy = "fournisseur", fetch = FetchType.LAZY)
    private List<CommandFournisseur> commandFournisseurs;
}
