package com.gestionServer.gestionServer.DTOs;

import com.gestionServer.gestionServer.models.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolesDTO {

    private Integer id;

    private String name;

    private UserDTO user;

    public static RolesDTO fromEntityRole(Roles role){
        if(role== null)
            return null;

        return RolesDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .user(UserDTO.fromEntityUser(role.getUser()))
                .build();
    }

    public static Roles toEntityRoles(RolesDTO rolesDTO){
        if(rolesDTO== null)
            return null;

        Roles roles= new Roles();

        roles.setId(rolesDTO.getId());
        roles.setName(roles.getName());
        roles.setUser(UserDTO.toEntityUser(rolesDTO.getUser()));

        return roles;
    }
}
