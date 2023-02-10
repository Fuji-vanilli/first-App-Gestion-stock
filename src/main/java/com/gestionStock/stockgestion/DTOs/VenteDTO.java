package com.gestionStock.stockgestion.DTOs;

import com.gestionStock.stockgestion.models.Ventes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VenteDTO {

    private Integer id;

    private String code;

    private Instant dateVente;

    private String comment;

    public static VenteDTO fromEntityVentes(Ventes vente){
        if(vente== null)
            return null;

        return VenteDTO.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .dateVente(vente.getDateVente())
                .comment(vente.getComment())
                .build();
    }

    public static Ventes toEntityVentes(VenteDTO venteDTO){
        if(venteDTO== null)
            return null;

        Ventes ventes= new Ventes();

        ventes.setId(venteDTO.getId());
        ventes.setCode(venteDTO.getCode());
        ventes.setDateVente(venteDTO.getDateVente());
        ventes.setComment(venteDTO.getComment());

        return ventes;
    }
}
