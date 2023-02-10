package com.gestionStock.stockgestion.DTOs;

import com.gestionStock.stockgestion.models.LigneVente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LigneVenteDTO {

    private Integer id;

    private VenteDTO ventes;

    private BigDecimal quantity;

    private BigDecimal prixUnitaire;

    public static LigneVenteDTO fromEntityLigneVente(LigneVente ligneVente){
        if(ligneVente== null)
            return null;

        return LigneVenteDTO.builder()
                .id(ligneVente.getId())
                .ventes(VenteDTO.fromEntityVentes(ligneVente.getVentes()))
                .quantity(ligneVente.getQuantity())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .build();
    }

    public static LigneVente toEntityLigneVentes(LigneVenteDTO ligneVenteDTO){
        if(ligneVenteDTO== null)
            return null;

        LigneVente ligneVente= new LigneVente();

        ligneVente.setId(ligneVenteDTO.getId());
        ligneVente.setVentes(VenteDTO.toEntityVentes(ligneVenteDTO.getVentes()));
        ligneVente.setQuantity(ligneVenteDTO.getQuantity());
        ligneVente.setPrixUnitaire(ligneVenteDTO.getPrixUnitaire());

        return ligneVente;
    }
}
