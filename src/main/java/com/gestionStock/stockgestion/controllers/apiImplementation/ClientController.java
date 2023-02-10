package com.gestionStock.stockgestion.controllers.apiImplementation;

import com.gestionStock.stockgestion.DTOs.ClientDTO;
import com.gestionStock.stockgestion.controllers.api.ClientApi;
import com.gestionStock.stockgestion.services.servicesImplementation.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController implements ClientApi {

    private final ClientService clientService;

    @Override
    public ClientDTO create(ClientDTO clientDTO) {
        return clientService.create(clientDTO);
    }

    @Override
    public ClientDTO getById(Integer id) {
        return clientService.getById(id);
    }

    @Override
    public ClientDTO getByFirstName(String firstName) {
        return clientService.getByFirstName(firstName);
    }

    @Override
    public List<ClientDTO> getAll() {
        return clientService.getAll();
    }

    @Override
    public boolean delete(Integer id) {
        return clientService.delete(id);
    }
}
