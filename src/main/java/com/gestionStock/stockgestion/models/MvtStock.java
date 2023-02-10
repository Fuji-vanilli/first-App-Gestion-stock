package com.gestionStock.stockgestion.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class MvtStock extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name= "idArticle")
    private Article article;

    private Instant dateMvt;

    private TypeMvtStock typeMvtStock;

    private BigDecimal quantity;

}
