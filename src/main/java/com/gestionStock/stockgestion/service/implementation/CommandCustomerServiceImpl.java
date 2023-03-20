package com.gestionStock.stockgestion.service.implementation;

import com.gestionStock.stockgestion.DTOs.mapper.CommandCustomerMapping;
import com.gestionStock.stockgestion.DTOs.mapper.LineCommandCustomerMapping;
import com.gestionStock.stockgestion.DTOs.request.CommandCustomerRequest;
import com.gestionStock.stockgestion.DTOs.request.LineCommandCustomerRequest;
import com.gestionStock.stockgestion.DTOs.response.CommandCustomerResponse;
import com.gestionStock.stockgestion.DTOs.response.LineCommandCustomerResponse;
import com.gestionStock.stockgestion.exception.EntityNotFoundException;
import com.gestionStock.stockgestion.exception.ErrorCode;
import com.gestionStock.stockgestion.exception.InvalidEntityException;
import com.gestionStock.stockgestion.models.Articles;
import com.gestionStock.stockgestion.models.CommandCustomer;
import com.gestionStock.stockgestion.models.Customer;
import com.gestionStock.stockgestion.models.LineCommandCustomer;
import com.gestionStock.stockgestion.repositories.ArticleRepository;
import com.gestionStock.stockgestion.repositories.CommandCustomerRepository;
import com.gestionStock.stockgestion.repositories.CustomerRepository;
import com.gestionStock.stockgestion.repositories.LineCommandCustomerRepository;
import com.gestionStock.stockgestion.service.CommandCustomerService;
import com.gestionStock.stockgestion.validator.CommandCustomerValidator;
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
public class CommandCustomerServiceImpl implements CommandCustomerService {

    private final CommandCustomerRepository commandCustomerRepository;
    private final CustomerRepository customerRepository;
    private final ArticleRepository articleRepository;
    private final CommandCustomerMapping commandCustomerMapping;
    private final LineCommandCustomerMapping lineCommandCustomerMapping;
    private final LineCommandCustomerRepository lineCommandCustomerRepository;

    @Override
    public CommandCustomerResponse create(CommandCustomerRequest commandCustomerRequest) {

        List<String> errors= CommandCustomerValidator.validate(commandCustomerRequest);

        if(!errors.isEmpty()){
            log.error("command customer not valid");
            throw new InvalidEntityException(
                    "command not valid",
                    ErrorCode.COMMAND_CUSTOMER_NOT_VALID,
                    errors
            );
        }

        Optional<Customer> customer= customerRepository.findById(commandCustomerRequest.getCustomer().getId());
        if(customer.isEmpty()){
            log.warn("the customer doesn't exist on the database");
            throw new EntityNotFoundException(
                    "customer unexist on the database",
                    ErrorCode.CUSTOMER_NOT_FOUND
            );
        }

        List<String> errorArticle= new ArrayList<>();

        if(commandCustomerRequest.getLigneCommandCustomer()!= null){
            commandCustomerRequest.getLigneCommandCustomer()
                    .forEach(line-> {
                        if(line.getArticle()!= null){
                            Optional<Articles> article= articleRepository.findById(line.getArticle().getId());
                            if(article.isEmpty())
                                errorArticle.add("article with id: "+line.getArticle().getId()+" doesn't exist on the database");
                        }

                    });
        }

        if(!errorArticle.isEmpty()){
            log.warn("command not valid because more article doesn't exist on the database");
            throw new InvalidEntityException(
                    "article unexist on the database",
                    ErrorCode.ARTICLE_NOT_FOUND,
                    errorArticle
            );
        }

        CommandCustomer command= commandCustomerMapping.commandCustomerRequestToCommandCustomer(commandCustomerRequest);
        command.setId(UUID.randomUUID().toString());

        commandCustomerRepository.save(command);


        List<LineCommandCustomerRequest> line= new ArrayList<>();
        if((line= commandCustomerRequest.getLigneCommandCustomer())!= null){
            line.forEach(lineCommand-> {
                LineCommandCustomer lineCommandCustomer= lineCommandCustomerMapping.lineCustomerRequestToLineCustomer(lineCommand);
                lineCommandCustomer.setCommandCustomer(command);
                lineCommandCustomerRepository.save(lineCommandCustomer);

            });
        }

        return commandCustomerMapping.commandCustomerToCommandCustomerResposnse(command);
    }

    @Override
    public CommandCustomerResponse findById(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            return null;
        }

        Optional<CommandCustomer> commandCustomer= commandCustomerRepository.findById(id);

        CommandCustomerResponse commandCustomerResponse= commandCustomerMapping.commandCustomerToCommandCustomerResposnse(commandCustomer.get());

        return Optional.of(commandCustomerResponse).orElseThrow(
                ()-> new EntityNotFoundException(
                        "command customer with the id: "+id+" doesn't exist in the database",
                        ErrorCode.COMMAND_CUSTOMER_NOT_FOUND
                )
        );
    }

    @Override
    public CommandCustomerResponse findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("code doesn't null");
            return null;
        }

        Optional<CommandCustomer> commandCustomer= commandCustomerRepository.findByCode(code);

        CommandCustomerResponse commandCustomerResponse= commandCustomerMapping.commandCustomerToCommandCustomerResposnse(commandCustomer.get());

        return Optional.of(commandCustomerResponse).orElseThrow(
                ()-> new EntityNotFoundException(
                        "command customer with the code: "+code+" doesn't exist in the database",
                        ErrorCode.COMMAND_CUSTOMER_NOT_FOUND
                )
        );
    }

    @Override
    public List<CommandCustomerResponse> getAll() {
        return commandCustomerRepository.findAll()
                .stream()
                .map(command-> commandCustomerMapping.commandCustomerToCommandCustomerResposnse(command))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            return false;
        }
        commandCustomerRepository.deleteById(id);
        return true;
    }
}
