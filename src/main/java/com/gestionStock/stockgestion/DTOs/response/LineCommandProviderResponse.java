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
public class LineCommandProviderResponse {

    private String id;

    private BigDecimal quantity;

    private ArticleResponse article;

    private CommandProviderResponse commandProvider;

}
