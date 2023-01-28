package com.gestionServer.gestionServer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
