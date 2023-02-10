package com.gestionStock.stockgestion.services.servicesImplementation;

import com.gestionStock.stockgestion.DTOs.CommandClientDTO;
import com.gestionStock.stockgestion.DTOs.LigneCommandClientDTO;
import com.gestionStock.stockgestion.exceptions.EntityNotFoundException;
import com.gestionStock.stockgestion.exceptions.ErrorCode;
import com.gestionStock.stockgestion.exceptions.InvalidEntityException;
import com.gestionStock.stockgestion.models.Article;
import com.gestionStock.stockgestion.models.Client;
import com.gestionStock.stockgestion.models.CommandClient;
import com.gestionStock.stockgestion.models.LigneCommandClient;
import com.gestionStock.stockgestion.repositories.ArticleRepository;
import com.gestionStock.stockgestion.repositories.ClientRepository;
import com.gestionStock.stockgestion.repositories.CommandClientRepository;
import com.gestionStock.stockgestion.repositories.LigneCommandClientRepository;
import com.gestionStock.stockgestion.services.businessService.ICommandClientService;
import com.gestionStock.stockgestion.validators.CommandClientValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class CommandClientService implements ICommandClientService {

    private final CommandClientRepository commandClientRepository;
    private final LigneCommandClientRepository ligneCommandClientRepository;
    private final ClientRepository clientRepository;
    private final ArticleRepository articleRepository;

    @Override
    public CommandClientDTO create(CommandClientDTO commandClientDTO) {
        List<String> errors= CommandClientValidator.validate(commandClientDTO);

        if(!errors.isEmpty()){
            log.error("The command client is not valid");
            throw new InvalidEntityException(
                    "Command client not valid",
                    ErrorCode.COMMAND_CLIENT_NOT_VALID,
                    errors
            );
        }

        Optional<Client> client= clientRepository.findById(commandClientDTO.getId());

        if(client.isEmpty()){
            log.warn("The client with the ID: {} doesn't exist on the database", commandClientDTO.getId());
            throw new EntityNotFoundException(
                    "The client ID: "+commandClientDTO.getId()+" does not exist int the database",
                    ErrorCode.COMMAND_CLIENT_NOT_FOUND
            );
        }

        List<String> articleErrors= new ArrayList<>();

        List<LigneCommandClientDTO> ligneCommandClientList= new ArrayList<>();

        if((ligneCommandClientList= commandClientDTO.getLigneCommandClientList())!= null){
            ligneCommandClientList.forEach(ligne->{
                if(ligne.getArticle()!= null){
                    Optional<Article> article= articleRepository.findById(ligne.getArticle().getId());
                    if(article.isEmpty()){
                        articleErrors.add("Article doesn't exist in the database");
                    }
                } else{
                    articleErrors.add("Impossible to pass command with null article");
                }
            });
        }

        if(!articleErrors.isEmpty()){
            log.warn("The article doesn't exist on the database");
            throw new InvalidEntityException(
                    "Article not exist on the database",
                    ErrorCode.COMMAND_CLIENT_NOT_VALID,
                    articleErrors
            );
        }

        CommandClient commandClient= commandClientRepository.save(CommandClientDTO.toEntityCommandClient(commandClientDTO));

        if(commandClientDTO.getLigneCommandClientList()!= null){
            commandClientDTO.getLigneCommandClientList()
                    .forEach(ligneCommand->{
                        LigneCommandClient ligneCommandClient= ligneCommandClientRepository
                                .save(LigneCommandClientDTO.toEntityCommandClient(ligneCommand));
                        ligneCommandClient.setCommandClient(commandClient);
                        ligneCommandClientRepository.save(ligneCommandClient);
                    });
        }

        return CommandClientDTO.fromEntityCommandClient(commandClient);
    }

    @Override
    public CommandClientDTO getById(Integer id) {
        if(id== null){
            log.error("The id of the command is null");
            return null;
        }
        return commandClientRepository.findById(id)
                .map(CommandClientDTO:: fromEntityCommandClient)
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "The commmand with the ID: "+id+" doesn't exist in the database",
                                ErrorCode.COMMAND_CLIENT_NOT_FOUND
                        )
                );
    }

    @Override
    public CommandClientDTO getByReference(String reference) {
        if(!StringUtils.hasLength(reference)){
            log.error("The reference of the command is null");
            return null;
        }

        return commandClientRepository.findByReference(reference)
                .map(CommandClientDTO:: fromEntityCommandClient)
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "The command with the reference: "+reference+" doesn't exist in the database",
                                ErrorCode.COMMAND_CLIENT_NOT_FOUND
                        )
                );
    }

    @Override
    public List<CommandClientDTO> getAll() {

        return commandClientRepository.findAll()
                .stream()
                .map(CommandClientDTO:: fromEntityCommandClient)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Integer id) {
        if(id== null){
            log.error("The id of the command is null");
            return false;
        }
        commandClientRepository.deleteById(id);
        return true;
    }
}
