package com.gestionStock.stockgestion.service.implementation;

import com.gestionStock.stockgestion.DTOs.mapper.CommandProviderMapping;
import com.gestionStock.stockgestion.DTOs.mapper.LineCommandProviderMapping;
import com.gestionStock.stockgestion.DTOs.request.CommandProviderRequest;
import com.gestionStock.stockgestion.DTOs.request.LineCommandProviderRequest;
import com.gestionStock.stockgestion.DTOs.response.CommandCustomerResponse;
import com.gestionStock.stockgestion.DTOs.response.CommandProviderResponse;
import com.gestionStock.stockgestion.DTOs.response.LineCommandProviderResponse;
import com.gestionStock.stockgestion.DTOs.response.ProviderResponse;
import com.gestionStock.stockgestion.exception.EntityNotFoundException;
import com.gestionStock.stockgestion.exception.ErrorCode;
import com.gestionStock.stockgestion.exception.InvalidEntityException;
import com.gestionStock.stockgestion.models.*;
import com.gestionStock.stockgestion.repositories.ArticleRepository;
import com.gestionStock.stockgestion.repositories.CommandProviderRepository;
import com.gestionStock.stockgestion.repositories.LineCommandProviderRepository;
import com.gestionStock.stockgestion.repositories.ProviderRepository;
import com.gestionStock.stockgestion.service.CommandProviderService;
import com.gestionStock.stockgestion.validator.CommandProviderValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CommandProviderServiceImpl implements CommandProviderService {

    private final CommandProviderRepository commandProviderRepository;
    private final ProviderRepository providerRepository;
    private final ArticleRepository articleRepository;
    private final CommandProviderMapping commandProviderMapping;
    private final LineCommandProviderMapping lineCommandProviderMapping;
    private final LineCommandProviderRepository lineCommandProviderRepository;

    @Override
    public CommandProviderResponse create(CommandProviderRequest commandProviderRequest) {
        List<String> errors= CommandProviderValidator.validate(commandProviderRequest);

        if(!errors.isEmpty()){
            log.error("the command provider is not valid");
            throw new InvalidEntityException(
                    "command provider not valid",
                    ErrorCode.COMMAND_PROVIDER_NOT_VALID,
                    errors
            );
        }

        Optional<Provider> provider= providerRepository.findById(commandProviderRequest.getProvider().getId());

        if(provider.isEmpty()){
            log.warn("the provider with the id:"+commandProviderRequest.getProvider().getId()+"doesn't exist on the database");
            throw new EntityNotFoundException(
                    "provider doesn't exist on the database",
                    ErrorCode.COMMAND_CUSTOMER_NOT_FOUND
            );
        }

        List<String> articleErrors= new ArrayList<>();
        List<LineCommandProviderRequest> line= new ArrayList<>();
        if((line= commandProviderRequest.getLineCommandProviderRequest())!= null){
            line.forEach(lineCommand-> {
                if(lineCommand.getArticle()!= null){
                    Optional<Articles> articles= articleRepository.findById(lineCommand.getArticle().getId());
                    if(articles.isEmpty()){
                        articleErrors.add("article with the id: "+lineCommand.getArticle().getId()+" doesn't exist on the database");
                    }
                }

            });
        }

        if(!articleErrors.isEmpty()){
            log.warn("more article on the command  doesn't exist on the database");
            throw new InvalidEntityException(
                    "more article on the command  doesn't exist on the database",
                    ErrorCode.COMMAND_PROVIDER_NOT_VALID,
                    articleErrors
            );
        }

        CommandProvider commandProvider= commandProviderMapping.commandProviderRequestToCommandProvider(commandProviderRequest);
        commandProvider.setId(UUID.randomUUID().toString());

        if(commandProviderRequest.getLineCommandProviderRequest()!= null){
            commandProviderRequest.getLineCommandProviderRequest().forEach(lineCommand-> {
                LineCommandProvider lineCommandProvider= lineCommandProviderMapping.lineProviderRequestToLineProvider(lineCommand);
                lineCommandProvider.setCommandProvider(commandProvider);
                lineCommandProviderRepository.save(lineCommandProvider);

            });
        }

        return commandProviderMapping.commandProviderToCommandProviderResponse(commandProvider);
    }

    @Override
    public CommandProviderResponse getById(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            return null;
        }

        Optional<CommandProvider> commandProvider= commandProviderRepository.findById(id);

        CommandProviderResponse commandProviderResponse= commandProviderMapping.commandProviderToCommandProviderResponse(commandProvider.get());

        return Optional.of(commandProviderResponse).orElseThrow(
                ()-> new EntityNotFoundException(
                        "command provider with the id: "+id+" doesn't exist in the database",
                        ErrorCode.COMMAND_PROVIDER_NOT_FOUND
                )
        );
    }

    @Override
    public CommandProviderResponse getByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("code doesn't null");
            return null;
        }

        Optional<CommandProvider> commandProvider= commandProviderRepository.findByCode(code);

        CommandProviderResponse commandProviderResponse= commandProviderMapping.commandProviderToCommandProviderResponse(commandProvider.get());

        return Optional.of(commandProviderResponse).orElseThrow(
                ()-> new EntityNotFoundException(
                        "command provider with the code: "+code+" doesn't exist in the database",
                        ErrorCode.COMMAND_PROVIDER_NOT_FOUND
                )
        );
    }

    @Override
    public List<CommandProviderResponse> getAll() {
        return commandProviderRepository.findAll()
                .stream()
                .map(commandProvider -> commandProviderMapping.commandProviderToCommandProviderResponse(commandProvider))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            return false;
        }
        commandProviderRepository.deleteById(id);
        return true;
    }
}
