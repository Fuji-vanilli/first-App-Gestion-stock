package com.gestionStock.stockgestion.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
