package com.gestionStock.stockgestion.controllers.apiImplementation;

import com.gestionStock.stockgestion.DTOs.CommandFournisseurDTO;
import com.gestionStock.stockgestion.controllers.api.CommandFournisseurApi;
import com.gestionStock.stockgestion.services.servicesImplementation.CommandFournisseurServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommanDFournisseurController implements CommandFournisseurApi {

    private final CommandFournisseurServiceV1 commandFournisseurService;

    @Override
    public CommandFournisseurDTO create(CommandFournisseurDTO commandFournisseurDTO) {
        return commandFournisseurService.create(commandFournisseurDTO);
    }

    @Override
    public CommandFournisseurDTO getById(Integer id) {
        return commandFournisseurService.getById(id);
    }

    @Override
    public CommandFournisseurDTO getByCode(String code) {
        return commandFournisseurService.getByCode(code);
    }

    @Override
    public List<CommandFournisseurDTO> getAll() {
        return commandFournisseurService.getAll();
    }

    @Override
    public boolean delete(Integer id) {
        return commandFournisseurService.delete(id);
    }
}
