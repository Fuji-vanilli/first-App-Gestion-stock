package com.gestionStock.stockgestion.DTOs;

import com.gestionStock.stockgestion.models.LigneCommandClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommandClientDTO {

    private Integer id;

    private ArticleDTO article;

    private CommandClientDTO commandClient;

    private BigDecimal quantity;

    private BigDecimal prixUnitaire;

    public static LigneCommandClientDTO fromEntityLigneCommandClient(LigneCommandClient ligneCommandClient){
        if(ligneCommandClient== null)
            return null;

        return LigneCommandClientDTO.builder()
                .id(ligneCommandClient.getId())
                .article(ArticleDTO.fromEntityArticle(ligneCommandClient.getArticle()))
                .commandClient(CommandClientDTO.fromEntityCommandClient(ligneCommandClient.getCommandClient()))
                .quantity(ligneCommandClient.getQuantity())
                .prixUnitaire(ligneCommandClient.getPrixUnitaire())
                .build();
    }

    public static LigneCommandClient toEntityCommandClient(LigneCommandClientDTO ligneCommandClientDTO){
        if(ligneCommandClientDTO== null)
            return null;

        LigneCommandClient ligneCommandClient= new LigneCommandClient();

        ligneCommandClient.setId(ligneCommandClientDTO.getId());
        ligneCommandClient.setArticle(ArticleDTO.toEntityArticle(ligneCommandClientDTO.getArticle()));
        ligneCommandClient.setCommandClient(CommandClientDTO.toEntityCommandClient(ligneCommandClientDTO.getCommandClient()));
        ligneCommandClient.setQuantity(ligneCommandClientDTO.getQuantity());
        ligneCommandClient.setPrixUnitaire(ligneCommandClientDTO.getPrixUnitaire());

        return ligneCommandClient;
    }
}
