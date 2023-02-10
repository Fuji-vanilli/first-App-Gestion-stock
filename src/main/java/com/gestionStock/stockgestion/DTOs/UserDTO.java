package com.gestionStock.stockgestion.DTOs;

import com.gestionStock.stockgestion.models.Roles;
import com.gestionStock.stockgestion.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private Instant dateOfBirth;

    private AdressDTO adress;

    private String photo;

    private EntrepriseDTO entreprise;

    private List<RolesDTO> roles;

    public static UserDTO fromEntityUser(User user){
        if(user== null)
            return null;
        List<RolesDTO> rolesDTOS= new ArrayList<>();

        user.getRoles().forEach(role -> {
            rolesDTOS.add(RolesDTO.fromEntityRole(role));
        });
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .dateOfBirth(user.getDateOfBirth())
                .adress(AdressDTO.fromEntityAdress(user.getAdress()))
                .photo(user.getPhoto())
                .entreprise(EntrepriseDTO.fromEntityEntreprise(user.getEntreprise()))
                .roles(rolesDTOS)
                .build();
    }

    public static User toEntityUser(UserDTO userDTO){
        if(userDTO== null)
            return null;

        List<Roles> roles1= new ArrayList<>();
        userDTO.getRoles().forEach(rolesDTO -> {
            roles1.add(RolesDTO.toEntityRoles(rolesDTO));
        });
        User user= new User();

        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setAdress(AdressDTO.toEntityAdress(userDTO.getAdress()));
        user.setPhoto(user.getPhoto());
        user.setEntreprise(EntrepriseDTO.toEntityEntreprise(userDTO.getEntreprise()));
        user.setRoles(roles1);

        return user;
    }
}
