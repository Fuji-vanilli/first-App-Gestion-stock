package com.gestionStock.stockgestion.models;

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
public class Entreprise extends AbstractEntity{

    private String name;

    private String description;

    private Adress adress;

    private String codeFiscal;

    private String email;

    private String tel;

    private String site;

    @OneToMany(mappedBy = "entreprise", fetch = FetchType.LAZY)
    private List<User> users;

}
