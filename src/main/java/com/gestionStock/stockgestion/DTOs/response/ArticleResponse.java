package com.gestionStock.stockgestion.DTOs.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleResponse {

    private String id;

    private String codeArticle;

    private String designation;

    private BigDecimal priceUnitHT;

    private BigDecimal TVA;

    private BigDecimal priceUnitTTC;

    private String picture;

    private CategoryResponse categoryResponse;


}
