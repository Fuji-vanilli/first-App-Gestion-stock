package com.gestionStock.stockgestion.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
//@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sale extends AbstractEntity{

    private String code;

    private Instant dateOfSale;

    private String comment;

    @OneToMany(mappedBy = "sale", fetch = FetchType.LAZY)
    private List<LineSale> lineSales;
}
