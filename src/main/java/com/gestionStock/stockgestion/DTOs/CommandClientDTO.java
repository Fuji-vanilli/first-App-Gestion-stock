package com.gestionServer.gestionServer.DTOs;


import com.gestionServer.gestionServer.models.CommandClient;
import com.gestionServer.gestionServer.models.LigneCommandClient;
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
public class CommandClientDTO {

    private Integer id;

    private String reference;

    private Instant dateCommande;

    private ClientDTO client;

    private List<LigneCommandClientDTO> ligneCommandClientList;

    public static CommandClientDTO fromEntityCommandClient(CommandClient commandClient){
        if(commandClient== null)
            return null;
        List<LigneCommandClientDTO> ligneCommandClientDTOS= new ArrayList<>();

        commandClient.getLigneCommandClientList().forEach(ligneCommandClient -> {
            ligneCommandClientDTOS.add(LigneCommandClientDTO.fromEntityLigneCommandClient(ligneCommandClient));
        });
        return CommandClientDTO.builder()
                .id(commandClient.getId())
                .reference(commandClient.getReference())
                .dateCommande(commandClient.getDateCommande())
                .client(ClientDTO.fromEntityClient(commandClient.getClient()))
                .ligneCommandClientList(ligneCommandClientDTOS)
                .build();
    }

    public static CommandClient toEntityCommandClient(CommandClientDTO commandClientDTO){
        if(commandClientDTO== null)
            return null;
        List<LigneCommandClient> ligneCommandClient= new ArrayList<>();

        commandClientDTO.getLigneCommandClientList().forEach(ligneCommandClientDTO -> {
            ligneCommandClient.add(LigneCommandClientDTO.toEntityCommandClient(ligneCommandClientDTO));
        });
        CommandClient commandClient= new CommandClient();

        commandClient.setId(commandClientDTO.getId());
        commandClient.setReference(commandClientDTO.getReference());
        commandClient.setDateCommande(commandClientDTO.getDateCommande());
        commandClient.setClient(ClientDTO.toEntityClient(commandClientDTO.getClient()));
        commandClient.setLigneCommandClientList(ligneCommandClient);

        return commandClient;
    }
}
