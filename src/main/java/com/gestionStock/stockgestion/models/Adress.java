package com.gestionServer.gestionServer.models;

import lombok.*;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Embeddable
@Builder
public class Adress {

    private String adress1;

    private String adress2;

    private String ville;

    private String codePostale;

    private String pays;
}
