package com.gestionStock.stockgestion.DTOs;

import com.gestionStock.stockgestion.models.Entreprise;
import com.gestionStock.stockgestion.models.User;
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
public class EntrepriseDTO {

    private Integer id;

    private String name;

    private String description;

    private AdressDTO adress;

    private String codeFiscal;

    private String email;

    private String tel;

    private String site;

    private List<UserDTO> users;

    public static EntrepriseDTO fromEntityEntreprise(Entreprise entreprise){
        if(entreprise== null)
            return null;

        List<UserDTO> entrepriseDTOS= new ArrayList<>();
        entreprise.getUsers().forEach(user -> {
            entrepriseDTOS.add(UserDTO.fromEntityUser(user));
        });

        return EntrepriseDTO.builder()
                .id(entreprise.getId())
                .name(entreprise.getName())
                .description(entreprise.getDescription())
                .adress(AdressDTO.fromEntityAdress(entreprise.getAdress()))
                .codeFiscal(entreprise.getCodeFiscal())
                .email(entreprise.getEmail())
                .tel(entreprise.getTel())
                .site(entreprise.getSite())
                .users(entrepriseDTOS)
                .build();
    }

    public static Entreprise toEntityEntreprise(EntrepriseDTO entrepriseDTO){
        if(entrepriseDTO== null)
            return null;

        List<User> users= new ArrayList<>();
        entrepriseDTO.getUsers().forEach(userDTO -> {
            users.add(UserDTO.toEntityUser(userDTO));
        });
        Entreprise entreprise= new Entreprise();

        entreprise.setId(entrepriseDTO.getId());
        entreprise.setName(entrepriseDTO.getName());
        entreprise.setDescription(entrepriseDTO.getDescription());
        entreprise.setAdress(AdressDTO.toEntityAdress(entrepriseDTO.getAdress()));
        entreprise.setCodeFiscal(entrepriseDTO.codeFiscal);
        entreprise.setEmail(entrepriseDTO.getEmail());
        entreprise.setTel(entrepriseDTO.getTel());
        entreprise.setSite(entrepriseDTO.getSite());
        entreprise.setUsers(users);

        return entreprise;
    }
}
