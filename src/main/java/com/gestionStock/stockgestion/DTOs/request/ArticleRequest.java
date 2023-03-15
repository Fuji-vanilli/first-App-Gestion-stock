package com.gestionStock.stockgestion.DTOs.request;


import com.gestionStock.stockgestion.DTOs.response.CategoryResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {

    private String codeArticle;

    private String designation;

    private BigDecimal priceUnitHT;

    private BigDecimal TVA;

    private BigDecimal priceUnitTTC;

    private String picture;

    private CategoryResponse categoryResponse;

}
