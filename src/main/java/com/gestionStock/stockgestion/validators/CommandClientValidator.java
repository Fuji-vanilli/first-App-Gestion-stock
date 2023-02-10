package com.gestionStock.stockgestion.validators;

import com.gestionStock.stockgestion.DTOs.CommandClientDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CommandClientValidator {

    public static List<String> validate(CommandClientDTO commandClientDTO){
        List<String> errors= new ArrayList<>();

        if(commandClientDTO== null){
            Stream.of(
                    "Verifie the command reference",
                    "Verifie the date of the command"
            ).forEach(error->{
                errors.add(error);
            });
        }
        if(!StringUtils.hasLength(commandClientDTO.getReference())){
            errors.add("The reference of the commandclient is null");
        }
        if(!StringUtils.hasLength(String.valueOf(commandClientDTO.getDateCommande()))){
            errors.add("The date of the command is null");
        }
        if(commandClientDTO.getClient()== null){
            errors.add("The client does not exist");
        }
        if(commandClientDTO.getLigneCommandClientList()== null){
            errors.add("The ligne command client does not exist");
        }

        return errors;
    }
}
