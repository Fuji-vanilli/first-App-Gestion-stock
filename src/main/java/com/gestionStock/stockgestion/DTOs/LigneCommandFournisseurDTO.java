package com.gestionStock.stockgestion.DTOs;

import com.gestionStock.stockgestion.models.LigneCommandFournisseur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommandFournisseurDTO {

    private Integer id;

    private ArticleDTO article;

    private CommandFournisseurDTO commandFournisseur;

    private BigDecimal quantity;

    private BigDecimal prixUnitaire;

    public static LigneCommandFournisseurDTO fromEntityLigneCommandFournisseur(LigneCommandFournisseur ligneCommandFournisseur){
        if(ligneCommandFournisseur== null)
            return null;

        return LigneCommandFournisseurDTO.builder()
                .id(ligneCommandFournisseur.getId())
                .article(ArticleDTO.fromEntityArticle(ligneCommandFournisseur.getArticle()))
                .commandFournisseur(CommandFournisseurDTO.fromEntityCommandFournisseur(ligneCommandFournisseur.getCommandFournisseur()))
                .quantity(ligneCommandFournisseur.getQuantity())
                .prixUnitaire(ligneCommandFournisseur.getPrixUnitaire())
                .build();
    }

    public static LigneCommandFournisseur toEntityLigneCommandFournisseur(LigneCommandFournisseurDTO ligneCommandFournisseurDTO){
        if(ligneCommandFournisseurDTO== null)
            return null;

        LigneCommandFournisseur ligneCommandFournisseur= new LigneCommandFournisseur();

        ligneCommandFournisseur.setId(ligneCommandFournisseurDTO.getId());
        ligneCommandFournisseur.setArticle(ArticleDTO.toEntityArticle(ligneCommandFournisseurDTO.getArticle()));
        ligneCommandFournisseur.setCommandFournisseur(CommandFournisseurDTO.toEntityCommandFournisseur(ligneCommandFournisseurDTO.getCommandFournisseur()));
        ligneCommandFournisseur.setQuantity(ligneCommandFournisseurDTO.getQuantity());
        ligneCommandFournisseur.setPrixUnitaire(ligneCommandFournisseurDTO.getPrixUnitaire());

        return ligneCommandFournisseur;
    }
}
