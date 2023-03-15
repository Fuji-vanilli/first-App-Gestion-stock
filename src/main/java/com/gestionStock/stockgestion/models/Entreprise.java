package com.gestionStock.stockgestion.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.desktop.UserSessionEvent;
import java.util.List;

@Entity
//@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Entreprise extends AbstractEntity{

    private String code;

    private String name;

    private String description;

    private String codeFiscal;

    private String email;

    @Embedded
    private Adress adress;

    private String tel;

    private String site;

    @OneToMany(mappedBy = "entreprise", fetch = FetchType.LAZY)
    private List<Users> users;


}
