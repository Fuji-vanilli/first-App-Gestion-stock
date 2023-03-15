package com.gestionStock.stockgestion.DTOs.response;

import com.gestionStock.stockgestion.models.MvtStock;
import com.gestionStock.stockgestion.models.TypeMvtStock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MvtStockRepsonse {

    private String id;

    private Instant dateMvt;

    private TypeMvtStock typeMvtStock;

    private BigDecimal quantity;

    private ArticleResponse article;

}
