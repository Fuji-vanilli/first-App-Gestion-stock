package com.gestionStock.stockgestion.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
//@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LineCommandProvider extends AbstractEntity{

    private BigDecimal quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idArticles", referencedColumnName = "id")
    private Articles articles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCommandProvider", referencedColumnName = "id")
    private CommandProvider commandProvider;
}
