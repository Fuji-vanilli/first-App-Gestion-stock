package com.gestionStock.stockgestion.DTOs.request;

import com.gestionStock.stockgestion.DTOs.response.ArticleResponse;
import com.gestionStock.stockgestion.DTOs.response.CommandCustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LineCommandCustomerRequest{

    private BigDecimal quantity;

    private ArticleResponse article;

    private CommandCustomerResponse commandClient;

}
