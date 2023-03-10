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
public class User extends AbstractEntity{

    private String firstName;

    private String lastName;

    private String email;

    private Instant dateOfBirth;

    private String password;

    private Adress adress;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "idEntreprise")
    private Entreprise entreprise;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Roles> roles;

}
