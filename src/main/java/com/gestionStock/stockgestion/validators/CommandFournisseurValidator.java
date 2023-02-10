package com.gestionStock.stockgestion.validators;

import com.gestionStock.stockgestion.DTOs.CommandClientDTO;
import com.gestionStock.stockgestion.DTOs.CommandFournisseurDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CommandFournisseurValidator {

    public static List<String> validate(CommandFournisseurDTO commandFournisseurDTO){
        List<String> errors= new ArrayList<>();

        if(commandFournisseurDTO== null){
            Stream.of(
                    "Verifie the command reference",
                    "Verifie the date of the command"
            ).forEach(error->{
                errors.add(error);
            });
        }
        if(!StringUtils.hasLength(commandFournisseurDTO.getCode())){
            errors.add("The reference of the commandclient is null");
        }
        if(!StringUtils.hasLength(String.valueOf(commandFournisseurDTO.getDateCommand()))){
            errors.add("The date of the command is null");
        }
        if(commandFournisseurDTO.getFournisseur()== null){
            errors.add("The client does not exist");
        }
        if(commandFournisseurDTO.getLigneCommandFournisseur()== null){
            errors.add("The ligne command client does not exist");
        }

        return errors;
    }
}
