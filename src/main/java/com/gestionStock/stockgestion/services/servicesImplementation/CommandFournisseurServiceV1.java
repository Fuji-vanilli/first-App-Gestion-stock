package com.gestionStock.stockgestion.services.servicesImplementation;

import com.gestionStock.stockgestion.DTOs.CommandFournisseurDTO;
import com.gestionStock.stockgestion.DTOs.LigneCommandFournisseurDTO;
import com.gestionStock.stockgestion.exceptions.EntityNotFoundException;
import com.gestionStock.stockgestion.exceptions.ErrorCode;
import com.gestionStock.stockgestion.exceptions.InvalidEntityException;
import com.gestionStock.stockgestion.models.Article;
import com.gestionStock.stockgestion.models.CommandFournisseur;
import com.gestionStock.stockgestion.models.Fournisseur;
import com.gestionStock.stockgestion.models.LigneCommandFournisseur;
import com.gestionStock.stockgestion.repositories.ArticleRepository;
import com.gestionStock.stockgestion.repositories.CommandFournisseurRepository;
import com.gestionStock.stockgestion.repositories.FournisseurRepository;
import com.gestionStock.stockgestion.repositories.LigneCommandFournisseurRepository;
import com.gestionStock.stockgestion.services.businessService.ICommandFournisseurService;
import com.gestionStock.stockgestion.validators.CommandFournisseurValidator;
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
public class CommandFournisseurServiceV1 implements ICommandFournisseurService {

    private final CommandFournisseurRepository commandFournisseurRepository;
    private final FournisseurRepository fournisseurRepository;
    private final LigneCommandFournisseurRepository ligneCommandFournisseurRepository;
    private final ArticleRepository articleRepository;

    @Override
    public CommandFournisseurDTO create(CommandFournisseurDTO commandFournisseurDTO) {
        List<String> errors= CommandFournisseurValidator.validate(commandFournisseurDTO);

        if(!errors.isEmpty()){
            log.error("The command fournisseur is not valid");
            throw new InvalidEntityException(
                    "Command fournisseur not valid",
                    ErrorCode.COMMAND_FOURNISSEUR_NOT_VALID,
                    errors
            );
        }

        Optional<Fournisseur> fournisseur= fournisseurRepository.findById(commandFournisseurDTO.getFournisseur().getId());

        if(fournisseur.isEmpty()){
            log.warn("The fournisseur doesn't exist on the database");
            throw new EntityNotFoundException(
                    "Fournisseur doesn't exist on the database",
                    ErrorCode.COMMAND_FOURNISSEUR_NOT_FOUND
            );
        }

        List<LigneCommandFournisseurDTO> ligneCommandFournisseurDTOList= new ArrayList<>();
        List<String> articleErrors= new ArrayList<>();

        if((ligneCommandFournisseurDTOList= commandFournisseurDTO.getLigneCommandFournisseur())!= null){
            ligneCommandFournisseurDTOList.forEach(ligne->{
                if(ligne.getArticle()!= null){
                    Optional<Article> article= articleRepository.findById(ligne.getArticle().getId());
                    if(article.isEmpty()){
                        articleErrors.add("Article doesn't exist on the database");
                    }
                }else{
                    articleErrors.add("The article with ID: "+ligne.getArticle().getId()+" doesn't exist on the database");
                }
            });
        }

        if(!articleErrors.isEmpty()){
            log.warn("The article doesn't exist");
            throw new InvalidEntityException(
                    "Article doesn't exist",
                    ErrorCode.COMMAND_FOURNISSEUR_NOT_FOUND,
                    articleErrors
            );
        }

        CommandFournisseur commmand= commandFournisseurRepository
                .save(CommandFournisseurDTO.toEntityCommandFournisseur(commandFournisseurDTO));

        if(commandFournisseurDTO.getLigneCommandFournisseur()!= null){
            commandFournisseurDTO.getLigneCommandFournisseur()
                    .forEach(ligneCommandF->{
                        LigneCommandFournisseur ligneCommandFournisseur= ligneCommandFournisseurRepository
                                .save(LigneCommandFournisseurDTO.toEntityLigneCommandFournisseur(ligneCommandF));
                        ligneCommandFournisseur.setCommandFournisseur(commmand);
                        ligneCommandFournisseurRepository.save(ligneCommandFournisseur);
                    });
        }
        return CommandFournisseurDTO.fromEntityCommandFournisseur(commmand);
    }

    @Override
    public CommandFournisseurDTO getById(Integer id) {
        if(id== null){
            log.error("The id is null");
            return null;
        }

        return commandFournisseurRepository.findById(id)
                .map(CommandFournisseurDTO:: fromEntityCommandFournisseur)
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "The command with the ID: "+id+" doesn't exist on the database",
                                ErrorCode.COMMAND_FOURNISSEUR_NOT_FOUND
                        )
                        );
    }

    @Override
    public CommandFournisseurDTO getByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("The code doesn't null");
            return null;
        }

        return commandFournisseurRepository.findByCode(code)
                .map(CommandFournisseurDTO:: fromEntityCommandFournisseur)
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "The command fournisseur with the code: "+code+" doesn't exist in the database",
                                ErrorCode.COMMAND_FOURNISSEUR_NOT_FOUND
                        )
                );
    }

    @Override
    public List<CommandFournisseurDTO> getAll() {
        return commandFournisseurRepository.findAll()
                .stream()
                .map(CommandFournisseurDTO:: fromEntityCommandFournisseur)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Integer id) {
        if(id== null){
            log.error("The id is null");
            return false;
        }

        commandFournisseurRepository.deleteById(id);
        return true;
    }
}
