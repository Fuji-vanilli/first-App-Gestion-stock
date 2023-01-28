package com.gestionServer.gestionServer.DTOs;

import com.gestionServer.gestionServer.models.Adress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdressDTO {

    private String adress1;

    private String adress2;

    private String ville;

    private String codePostale;

    private String pays;

    public static AdressDTO fromEntityAdress(Adress adress){
        if(adress== null)
            return null;

        return AdressDTO.builder()
                .adress1(adress.getAdress1())
                .adress2(adress.getAdress2())
                .ville(adress.getVille())
                .codePostale(adress.getCodePostale())
                .pays(adress.getPays())
                .build();
    }

    public static Adress toEntityAdress(AdressDTO adressDTO){
        if(adressDTO== null)
            return null;

        return Adress.builder()
                .adress1(adressDTO.getAdress1())
                .adress2(adressDTO.getAdress2())
                .ville(adressDTO.getVille())
                .codePostale(adressDTO.getCodePostale())
                .pays(adressDTO.getPays())
                .build();
    }
}
