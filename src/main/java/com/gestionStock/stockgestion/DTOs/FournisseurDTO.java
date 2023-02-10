package com.gestionStock.stockgestion.DTOs;

import com.gestionStock.stockgestion.models.CommandFournisseur;
import com.gestionStock.stockgestion.models.Fournisseur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FournisseurDTO {

    private Integer id;

    private String firstName;

    private String lastName;

    private AdressDTO adress;

    private String photo;

    private String email;

    private String tel;

    private List<CommandFournisseurDTO> commandFournisseurs;

    public static FournisseurDTO fromEntityFournisseur(Fournisseur fournisseur){
        if(fournisseur== null)
            return null;

        List<CommandFournisseurDTO> commandFournisseurDTOS= new ArrayList<>();

        fournisseur.getCommandFournisseurs().forEach(commandFournisseur -> {
            commandFournisseurDTOS.add(CommandFournisseurDTO.fromEntityCommandFournisseur(commandFournisseur));
        });
        return FournisseurDTO.builder()
                .id(fournisseur.getId())
                .firstName(fournisseur.getFirstName())
                .lastName(fournisseur.getLastName())
                .adress(AdressDTO.fromEntityAdress(fournisseur.getAdress()))
                .photo(fournisseur.getPhoto())
                .email(fournisseur.getEmail())
                .tel(fournisseur.getTel())
                .commandFournisseurs(commandFournisseurDTOS)
                .build();
    }

    public static Fournisseur toEntityFournisseur(FournisseurDTO fournisseurDTO){
        if(fournisseurDTO== null)
            return null;

        List<CommandFournisseur> commandFournisseurList= new ArrayList<>();
        fournisseurDTO.getCommandFournisseurs().forEach(commandFournisseurDTO -> {
            commandFournisseurList.add(CommandFournisseurDTO.toEntityCommandFournisseur(commandFournisseurDTO));
        });
        Fournisseur fournisseur= new Fournisseur();

        fournisseur.setId(fournisseurDTO.getId());
        fournisseur.setFirstName(fournisseurDTO.getFirstName());
        fournisseur.setLastName(fournisseurDTO.getLastName());
        fournisseur.setAdress(AdressDTO.toEntityAdress(fournisseurDTO.getAdress()));
        fournisseur.setPhoto(fournisseurDTO.getPhoto());
        fournisseur.setTel(fournisseurDTO.getTel());
        fournisseur.setCommandFournisseurs(commandFournisseurList);

        return fournisseur;
    }
}
