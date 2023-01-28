package com.gestionServer.gestionServer.DTOs;

import com.gestionServer.gestionServer.models.Client;
import com.gestionServer.gestionServer.models.CommandClient;
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
public class ClientDTO {

    private Integer id;

    private String firstName;

    private String lastName;

    private AdressDTO adress;

    private String photo;

    private String email;

    private String tel;

    private List<CommandClientDTO> commandClientList;

    public static ClientDTO fromEntityClient(Client client){
        if(client== null)
            return null;
        List<CommandClientDTO> commandClientDTOS= new ArrayList<>();
        client.getCommandClientList().forEach(command->{
            commandClientDTOS.add(CommandClientDTO.fromEntityCommandClient(command));
        });
        return ClientDTO.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .adress(AdressDTO.fromEntityAdress(client.getAdress()))
                .photo(client.getPhoto())
                .email(client.getEmail())
                .tel(client.getTel())
                .commandClientList(commandClientDTOS)
                .build();
    }
    public static Client toEntityClient(ClientDTO clientDTO){
        if(clientDTO== null)
            return null;

        List<CommandClient> commandClient= new ArrayList<>();
        clientDTO.getCommandClientList().forEach(command->{
            commandClient.add(CommandClientDTO.toEntityCommandClient(command));
        });
        Client client= new Client();

        client.setId(clientDTO.getId());
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setAdress(AdressDTO.toEntityAdress(clientDTO.getAdress()));
        client.setPhoto(clientDTO.getPhoto());
        client.setEmail(clientDTO.getEmail());
        client.setTel(clientDTO.getTel());
        client.setCommandClientList(commandClient);

        return client;
    }
}
