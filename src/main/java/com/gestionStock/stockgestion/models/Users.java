package com.gestionStock.stockgestion.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

@Entity
//@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users extends AbstractEntity{

    private String firstname;

    private String lastname;

    private Instant dateOfBirth;

    private String email;

    private String picture;

    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    private Entreprise entreprise;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Roles> roles;
}
