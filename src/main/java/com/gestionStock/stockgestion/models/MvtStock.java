package com.gestionServer.gestionServer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
