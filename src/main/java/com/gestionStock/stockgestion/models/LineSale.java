package com.gestionStock.stockgestion.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
//@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LineSale extends AbstractEntity{

    private BigDecimal quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Articles articles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSale", referencedColumnName = "id")
    private Sale sale;
}
