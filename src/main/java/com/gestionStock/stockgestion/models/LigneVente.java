package com.gestionStock.stockgestion.models;

import com.gestionStock.stockgestion.models.AbstractEntity;
import com.gestionStock.stockgestion.models.Ventes;
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
public class LigneVente extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "idVentes")
    private Ventes ventes;

    private BigDecimal quantity;

    private BigDecimal prixUnitaire;
}
