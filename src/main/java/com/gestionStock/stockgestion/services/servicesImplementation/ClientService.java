package com.gestionStock.stockgestion.services.servicesImplementation;

import com.gestionStock.stockgestion.DTOs.ClientDTO;
import com.gestionStock.stockgestion.exceptions.EntityNotFoundException;
import com.gestionStock.stockgestion.exceptions.ErrorCode;
import com.gestionStock.stockgestion.exceptions.InvalidEntityException;
import com.gestionStock.stockgestion.models.Client;
import com.gestionStock.stockgestion.repositories.ClientRepository;
import com.gestionStock.stockgestion.services.businessService.IClientService;
import com.gestionStock.stockgestion.validators.ClientValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

    @Override
    public ClientDTO create(ClientDTO clientDTO) {
        List<String> errors= ClientValidator.validate(clientDTO);

        if(!errors.isEmpty()){
            log.error("The client is not valid");
            throw new InvalidEntityException(
                    "client not valid",
                    ErrorCode.CLIENT_NOT_VALID,
                    errors);
        }
        return ClientDTO.fromEntityClient(
                clientRepository.save(ClientDTO.toEntityClient(clientDTO))
        );
    }

    @Override
    public ClientDTO getById(Integer id) {
        if(id== null){
            log.error("The id is null");
            return null;
        }

        Optional<Client> client= clientRepository.findById(id);

        return Optional.of(
                ClientDTO.fromEntityClient(client.get()))
                        .orElseThrow(()->
                                new EntityNotFoundException(
                                        "the client of id "+id+" isn't exist in the database",
                                        ErrorCode.CLIENT_NOT_FOUND
                                )
        );
    }

    @Override
    public ClientDTO getByFirstName(String firstName) {
        if(firstName== null){
            log.error("the first name doesn't null");
            return null;
        }

        Optional<Client> client= clientRepository.findByFirstName(firstName);

        return Optional.of(
                ClientDTO.fromEntityClient(client.get())
        ).orElseThrow(()->
                new EntityNotFoundException(
                        "The client with the firstname"+firstName+" doesn't exist on the database",
                        ErrorCode.CLIENT_NOT_FOUND)
                );
    }

    @Override
    public List<ClientDTO> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(ClientDTO:: fromEntityClient)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Integer id) {
        if(id== null){
            log.error("The id doesn't null");
            return false;
        }
        clientRepository.deleteById(id);
        return true;
    }
}
