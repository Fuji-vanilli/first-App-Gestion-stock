package com.gestionStock.stockgestion.DTOs;

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
public class MvtStockDTO {

    private Integer id;

    private ArticleDTO article;

    private Instant dateMvt;

    private TypeMvtStock typeMvtStock;

    private BigDecimal quantity;

    public static MvtStockDTO fromEntityMvtStock(MvtStock mvtStock){
        if(mvtStock== null)
            return null;

        return MvtStockDTO.builder()
                .id(mvtStock.getId())
                .article(ArticleDTO.fromEntityArticle(mvtStock.getArticle()))
                .dateMvt(mvtStock.getDateMvt())
                .typeMvtStock(mvtStock.getTypeMvtStock())
                .quantity(mvtStock.getQuantity())
                .build();


    }

    public static MvtStock toEntityMvtStock(MvtStockDTO mvtStockDTO){
        if(mvtStockDTO== null)
            return null;

        MvtStock mvtStock= new MvtStock();

        mvtStock.setId(mvtStockDTO.getId());
        mvtStock.setArticle(ArticleDTO.toEntityArticle(mvtStockDTO.getArticle()));
        mvtStock.setDateMvt(mvtStockDTO.getDateMvt());
        mvtStock.setTypeMvtStock(mvtStockDTO.getTypeMvtStock());
        mvtStock.setQuantity(mvtStockDTO.getQuantity());

        return mvtStock;
    }
}
