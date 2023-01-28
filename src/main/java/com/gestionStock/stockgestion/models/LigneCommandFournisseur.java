package com.gestionServer.gestionServer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class LigneCommandFournisseur extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name= "idArticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name= "idCommandFournisseur")
    private CommandFournisseur commandFournisseur;

    private BigDecimal quantity;

    private BigDecimal prixUnitaire;
}
