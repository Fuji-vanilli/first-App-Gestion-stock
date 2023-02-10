package com.gestionStock.stockgestion.services.servicesImplementation;

import com.gestionStock.stockgestion.DTOs.EntrepriseDTO;
import com.gestionStock.stockgestion.exceptions.EntityNotFoundException;
import com.gestionStock.stockgestion.exceptions.ErrorCode;
import com.gestionStock.stockgestion.exceptions.InvalidEntityException;
import com.gestionStock.stockgestion.models.Entreprise;
import com.gestionStock.stockgestion.repositories.EntrepriseRepository;
import com.gestionStock.stockgestion.services.businessService.IEntrepriseService;
import com.gestionStock.stockgestion.validators.EntrepriseValidator;
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
public class EntrepriseService implements IEntrepriseService {

    private final EntrepriseRepository entrepriseRepository;

    @Override
    public EntrepriseDTO create(EntrepriseDTO entrepriseDTO) {
        List<String> errors= EntrepriseValidator.validate(entrepriseDTO);

        if(!errors.isEmpty()){
            log.error("The entreprise is not valid");
            throw new InvalidEntityException(
                    "Entreprise entity not valid",
                    ErrorCode.ENTREPRISE_NOT_VALID,
                    errors
            );
        }
        return EntrepriseDTO.fromEntityEntreprise(
                entrepriseRepository.save(EntrepriseDTO.toEntityEntreprise(entrepriseDTO))
        );
    }

    @Override
    public EntrepriseDTO getById(Integer id) {
        if(id== null){
            log.error("The id is null");
            return null;
        }

        Optional<Entreprise> entreprise= entrepriseRepository.findById(id);

        return Optional.of(
                EntrepriseDTO.fromEntityEntreprise(entreprise.get())
        ).orElseThrow(()->
                new EntityNotFoundException(
                        "The entreprise with the id "+id+" doesn't exist in the database",
                        ErrorCode.ENTREPRISE_NOT_FOUND
                )
        );
    }

    @Override
    public EntrepriseDTO getByName(String name) {
        if(name== null){
            log.error("The name of the entreprise is null");
            return null;
        }

        Optional<Entreprise> entreprise= entrepriseRepository.findByName(name);

        return Optional.of(
                EntrepriseDTO.fromEntityEntreprise(entreprise.get())
        ).orElseThrow(()->
                new EntityNotFoundException(
                        "The entreprise of the name: "+name+" doesn't exist in the database",
                        ErrorCode.ENTREPRISE_NOT_FOUND
                )
        );
    }

    @Override
    public List<EntrepriseDTO> getAll() {
        return entrepriseRepository.findAll()
                .stream()
                .map(EntrepriseDTO:: fromEntityEntreprise)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Integer id) {
        if(id== null){
            log.error("the id is null");
            return false;
        }
        entrepriseRepository.deleteById(id);
        return true;
    }
}
