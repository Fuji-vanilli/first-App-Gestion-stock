package com.gestionServer.gestionServer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
