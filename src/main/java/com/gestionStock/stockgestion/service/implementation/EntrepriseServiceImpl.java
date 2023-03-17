package com.gestionStock.stockgestion.service.implementation;

import com.gestionStock.stockgestion.DTOs.mapper.EntrepriseMapping;
import com.gestionStock.stockgestion.DTOs.request.EntrepriseRequest;
import com.gestionStock.stockgestion.DTOs.response.EntrepriseResponse;
import com.gestionStock.stockgestion.exception.EntityNotFoundException;
import com.gestionStock.stockgestion.exception.ErrorCode;
import com.gestionStock.stockgestion.exception.InvalidEntityException;
import com.gestionStock.stockgestion.models.Entreprise;
import com.gestionStock.stockgestion.repositories.EntrepriseRepository;
import com.gestionStock.stockgestion.service.EntrepriseService;
import com.gestionStock.stockgestion.validator.EntrepriseValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;
    private final EntrepriseMapping entrepriseMapping;

    @Override
    public EntrepriseResponse create(EntrepriseRequest entrepriseRequest) {
        List<String> errors= EntrepriseValidator.validate(entrepriseRequest);

        if(!errors.isEmpty()){
            log.error("entreprise not valid");
            throw new InvalidEntityException(
                    "entreprise not valid",
                    ErrorCode.ENTREPRISE_NOT_VALID,
                    errors
            );
        }

        Entreprise entreprise= entrepriseMapping.entrepriseRequestToEntreprise(entrepriseRequest);
        entreprise.setId(UUID.randomUUID().toString());

        return entrepriseMapping.entrepriseToEntrepriseResponse(
                entrepriseRepository.save(entreprise)
        );
    }

    @Override
    public EntrepriseResponse getById(String id) {
        if (!StringUtils.hasLength(id)) {
            log.error("id doesn't null");
            return null;
        }

        Optional<Entreprise> entreprise= entrepriseRepository.findById(id);

        EntrepriseResponse entrepriseResponse= entrepriseMapping.entrepriseToEntrepriseResponse(entreprise.get());

        return Optional.of(entrepriseResponse).orElseThrow(
                ()-> new EntityNotFoundException(
                        "entreprise with the id: "+id+" doesn't exist on the database",
                        ErrorCode.ENTREPRISE_NOT_FOUND
                )
        );
    }

    @Override
    public EntrepriseResponse getByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("code doesn't null");
            return null;
        }

        Optional<Entreprise> entreprise= entrepriseRepository.findByCode(code);

        EntrepriseResponse entrepriseResponse= entrepriseMapping.entrepriseToEntrepriseResponse(entreprise.get());

        return Optional.of(entrepriseResponse).orElseThrow(
                ()-> new EntityNotFoundException(
                        "entreprise with the code: "+code+" doesn't exist on the database",
                        ErrorCode.ENTREPRISE_NOT_FOUND
                )
        );
    }

    @Override
    public List<EntrepriseResponse> getAll() {

        return entrepriseRepository.findAll()
                .stream()
                .map(entreprise-> entrepriseMapping.entrepriseToEntrepriseResponse(entreprise))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            return false;
        }
        entrepriseRepository.deleteById(id);
        return true;
    }
}
