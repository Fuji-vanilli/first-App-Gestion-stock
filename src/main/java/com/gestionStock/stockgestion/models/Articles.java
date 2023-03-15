package com.gestionStock.stockgestion.models;

import io.swagger.annotations.ApiKeyAuthDefinition;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
//@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
@Table(name = "article")
public class Articles extends AbstractEntity{

    private String codeArticle;

    @Column(nullable = false)
    private String designation;

    @Column(nullable = false)
    private BigDecimal priceUnitHT;

    private BigDecimal priceUnitTTC;

    private BigDecimal TVA;

    private String picture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategory", referencedColumnName = "id")
    private Category category;

}
