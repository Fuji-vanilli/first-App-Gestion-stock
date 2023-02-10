package com.gestionStock.stockgestion.controllers.apiImplementation;

import com.gestionStock.stockgestion.DTOs.CommandClientDTO;
import com.gestionStock.stockgestion.controllers.api.CommandClientApi;
import com.gestionStock.stockgestion.repositories.CommandClientRepository;
import com.gestionStock.stockgestion.services.servicesImplementation.CommandClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommandClientController implements CommandClientApi {

    private final CommandClientService commandClientService;

    @Override
    public CommandClientDTO create(CommandClientDTO commandClientDTO) {
        return commandClientService.create(commandClientDTO);
    }

    @Override
    public CommandClientDTO getById(Integer id) {
        return commandClientService.getById(id);
    }

    @Override
    public CommandClientDTO getByReference(String reference) {
        return commandClientService.getByReference(reference);
    }

    @Override
    public List<CommandClientDTO> getAll() {
        return commandClientService.getAll();
    }

    @Override
    public boolean delete(Integer id) {
        return commandClientService.delete(id);
    }
}
