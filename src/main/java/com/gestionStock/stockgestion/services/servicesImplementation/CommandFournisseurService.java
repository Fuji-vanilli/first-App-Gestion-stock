package com.gestionStock.stockgestion.services.servicesImplementation;

import com.gestionStock.stockgestion.DTOs.ArticleDTO;
import com.gestionStock.stockgestion.DTOs.CommandFournisseurDTO;
import com.gestionStock.stockgestion.DTOs.LigneCommandFournisseurDTO;
import com.gestionStock.stockgestion.exceptions.EntityNotFoundException;
import com.gestionStock.stockgestion.exceptions.ErrorCode;
import com.gestionStock.stockgestion.exceptions.InvalidEntityException;
import com.gestionStock.stockgestion.models.Article;
import com.gestionStock.stockgestion.models.Fournisseur;
import com.gestionStock.stockgestion.models.LigneCommandFournisseur;
import com.gestionStock.stockgestion.repositories.*;
import com.gestionStock.stockgestion.services.businessService.ICommandFournisseurService;
import com.gestionStock.stockgestion.validators.CommandFournisseurValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CommandFournisseurService implements ICommandFournisseurService {

    private final CommandFournisseurRepository commandFournisseurRepository;
    private final FournisseurRepository fournisseurRepository;
    private final ArticleRepository articleRepository;
    private final LigneCommandFournisseurRepository ligneCommandFournisseur;

    @Override
    public CommandFournisseurDTO create(CommandFournisseurDTO commandFournisseurDTO) {
        List<String> errors= CommandFournisseurValidator.validate(commandFournisseurDTO);

        if(!errors.isEmpty()){
            log.error("The command of the fournisseur is not valid");
            throw new InvalidEntityException(
                    "Command fournisseur not valid",
                    ErrorCode.COMMAND_FOURNISSEUR_NOT_VALID,
                    errors
            );
        }

        Optional<Fournisseur> fournisseur= fournisseurRepository.findById(commandFournisseurDTO.getFournisseur().getId());

        if(fournisseur.isEmpty()){
            log.warn("The fournisseur does not exist in the database");
            throw new EntityNotFoundException(
                    "Fournisseur does exist in the database",
                    ErrorCode.COMMAND_FOURNISSEUR_NOT_FOUND
            );
        }

        List<String> articlesErrors= new ArrayList<>();

        commandFournisseurDTO.getLigneCommandFournisseur()
                .forEach(ligne->{
                    /*
                    Optional<Article> article= articleRepository.findById(ligne.getArticle().getId());
                    if(article.isEmpty()){
                        articlesErrors.add("Article with ID: "+ligne.getArticle().getId()+" does not exist in the database");
                    }
                     */

                    ArticleDTO article= ligne.getArticle();
                    if(article!= null){
                        Optional<Article> article1= articleRepository.findById(article.getId());
                        if(article1.isEmpty()){
                            articlesErrors.add("Article with ID: "+ligne.getArticle().getId()+" does not exist in the database");
                        }
                    }else{
                        articlesErrors.add("Don't article exist in the Ligne de command");
                    }

                });

        if(!articlesErrors.isEmpty()){
            log.warn("The article doesn't exist");
            throw new InvalidEntityException(
                    "Article doesn't exist",
                    ErrorCode.COMMAND_FOURNISSEUR_NOT_FOUND,
                    articlesErrors
            );
        }

        CommandFournisseurDTO command=
                CommandFournisseurDTO.fromEntityCommandFournisseur(
                        commandFournisseurRepository.save(CommandFournisseurDTO.toEntityCommandFournisseur(commandFournisseurDTO)));

        commandFournisseurDTO.getLigneCommandFournisseur()
                .forEach(ligne->{
                    LigneCommandFournisseur commands= ligneCommandFournisseur.save(
                            LigneCommandFournisseurDTO.toEntityLigneCommandFournisseur(ligne));
                    commands.setCommandFournisseur(CommandFournisseurDTO.toEntityCommandFournisseur(command));
                    ligneCommandFournisseur.save(commands);
                });

        return command;
    }

    @Override
    public CommandFournisseurDTO getById(Integer id) {
        return null;
    }

    @Override
    public CommandFournisseurDTO getByCode(String code) {
        return null;
    }

    @Override
    public List<CommandFournisseurDTO> getAll() {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
