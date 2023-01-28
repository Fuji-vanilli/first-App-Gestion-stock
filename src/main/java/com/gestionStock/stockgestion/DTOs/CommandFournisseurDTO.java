package com.gestionServer.gestionServer.DTOs;

import com.gestionServer.gestionServer.models.CommandFournisseur;
import com.gestionServer.gestionServer.models.LigneCommandFournisseur;
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
public class CommandFournisseurDTO{

    private Integer id;

    private String code;

    private Instant dateCommand;

    private FournisseurDTO fournisseur;

    private List<LigneCommandFournisseurDTO > ligneCommandFournisseur;

    public static CommandFournisseurDTO fromEntityCommandFournisseur(CommandFournisseur commandFournisseur){
        if(commandFournisseur== null)
            return null;

        List<LigneCommandFournisseurDTO> ligneCommandFournisseurDTOS= new ArrayList<>();
        commandFournisseur.getLigneCommandFournisseur().forEach(ligneCommandFournisseur1 -> {
            ligneCommandFournisseurDTOS.add(LigneCommandFournisseurDTO.fromEntityLigneCommandFournisseur(ligneCommandFournisseur1));
        });

        return CommandFournisseurDTO.builder()
                .id(commandFournisseur.getId())
                .code(commandFournisseur.getCode())
                .dateCommand(commandFournisseur.getDateCommand())
                .fournisseur(FournisseurDTO.fromEntityFournisseur(commandFournisseur.getFournisseur()))
                .ligneCommandFournisseur(ligneCommandFournisseurDTOS)
                .build();
    }

    public static CommandFournisseur toEntityCommandFournisseur(CommandFournisseurDTO commandFournisseurDTO){
        if(commandFournisseurDTO== null)
            return null;

        List<LigneCommandFournisseur> ligneCommandFournisseurs= new ArrayList<>();
        commandFournisseurDTO.getLigneCommandFournisseur().forEach(ligneCommandFournisseurDTO -> {
            ligneCommandFournisseurs.add(LigneCommandFournisseurDTO.toEntityLigneCommandFournisseur(ligneCommandFournisseurDTO));
        });
        CommandFournisseur commandFournisseur= new CommandFournisseur();

        commandFournisseur.setId(commandFournisseurDTO.getId());
        commandFournisseur.setCode(commandFournisseurDTO.getCode());
        commandFournisseur.setDateCommand(commandFournisseur.getDateCommand());
        commandFournisseur.setFournisseur(FournisseurDTO.toEntityFournisseur(commandFournisseurDTO.getFournisseur()));
        commandFournisseur.setLigneCommandFournisseur(ligneCommandFournisseurs);

        return commandFournisseur;
    }
}
