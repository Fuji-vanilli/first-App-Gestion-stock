package com.gestionStock.stockgestion.services.servicesImplementation;

import com.gestionStock.stockgestion.DTOs.FournisseurDTO;
import com.gestionStock.stockgestion.exceptions.EntityNotFoundException;
import com.gestionStock.stockgestion.exceptions.ErrorCode;
import com.gestionStock.stockgestion.exceptions.InvalidEntityException;
import com.gestionStock.stockgestion.models.Fournisseur;
import com.gestionStock.stockgestion.repositories.FournisseurRepository;
import com.gestionStock.stockgestion.services.businessService.IFournisseurService;
import com.gestionStock.stockgestion.validators.FournisseurValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j

public class FournisseurService implements IFournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    public FournisseurService(
            FournisseurRepository fournisseurRepository){
        this.fournisseurRepository= fournisseurRepository;
    }

    @Override
    public FournisseurDTO create(FournisseurDTO fournisseurDTO) {
        List<String> errors= FournisseurValidator.validate(fournisseurDTO);

        if(!errors.isEmpty()){
            log.error("The fournisseur is not valid");
            throw new InvalidEntityException(
                    "The fournisseur is not valid",
                    ErrorCode.FOURNISSEUR_NOT_VALID,
                    errors
            );
        }
        return FournisseurDTO.fromEntityFournisseur(
                fournisseurRepository.save(FournisseurDTO.toEntityFournisseur(fournisseurDTO))
        );
    }

    @Override
    public FournisseurDTO getById(Integer id) {
        if(id== null){
            log.error("The id is null");
            return null;
        }

        Optional<Fournisseur> fournisseur= fournisseurRepository.findById(id);

        return Optional.of(
                FournisseurDTO.fromEntityFournisseur(fournisseur.get())
        ).orElseThrow(()->
                new EntityNotFoundException(
                        "The fournisseur of id: "+id+" doesn't exist in the database",
                        ErrorCode.FOURNISSEUR_NOT_FOUND
                )
        );
    }

    @Override
    public FournisseurDTO getByFirstName(String firstName) {
        if(firstName== null){
            log.error("The firstname is null");
            return null;
        }

        Optional<Fournisseur> fournisseur= fournisseurRepository.findByFirstName(firstName);

        return Optional.of(
                FournisseurDTO.fromEntityFournisseur(fournisseur.get())
        ).orElseThrow(()->
                new EntityNotFoundException(
                        "The fournisseur of firstname: "+firstName+" doesn't exist in the database",
                        ErrorCode.FOURNISSEUR_NOT_FOUND
                )
        );
    }

    @Override
    public List<FournisseurDTO> getAll() {

        return fournisseurRepository.findAll()
                .stream()
                .map(FournisseurDTO:: fromEntityFournisseur)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Integer id) {
        if(id== null){
            log.error("The id is null");
            return false;
        }
        fournisseurRepository.deleteById(id);

        return true;
    }
}
