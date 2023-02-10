package com.gestionStock.stockgestion.services.servicesImplementation;

import com.gestionStock.stockgestion.DTOs.VenteDTO;
import com.gestionStock.stockgestion.exceptions.EntityNotFoundException;
import com.gestionStock.stockgestion.exceptions.ErrorCode;
import com.gestionStock.stockgestion.exceptions.InvalidEntityException;
import com.gestionStock.stockgestion.repositories.VentesRepository;
import com.gestionStock.stockgestion.services.businessService.IVenteService;
import com.gestionStock.stockgestion.validators.VenteValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class VenteService implements IVenteService {

    private final VentesRepository ventesRepository;

    @Override
    public VenteDTO create(VenteDTO venteDTO) {
        List<String> errors= VenteValidator.valdiate(venteDTO);

        if(!errors.isEmpty()){
            log.error("The vente does not valid");
            throw new InvalidEntityException(
                    "Vente not valid",
                    ErrorCode.VENTE_NOT_VALID,
                    errors
            );
        }

        return VenteDTO.fromEntityVentes(
                ventesRepository.save(VenteDTO.toEntityVentes(venteDTO))
        );
    }

    @Override
    public VenteDTO getById(Integer id) {
        if(id== null){
            log.error("The error does not null");
            return null;
        }

        return ventesRepository.findById(id)
                .map(VenteDTO:: fromEntityVentes)
        .orElseThrow(()->
                new EntityNotFoundException(
                        "Vente with the id: "+id+" does not exist ont the databasse",
                        ErrorCode.VENTE_NOT_FOUND
                )
                );
    }

    @Override
    public VenteDTO getByCode(String code) {
        if(code== null){
            log.error("The code does not null");
            return null;
        }

        return ventesRepository.findByCode(code)
                .map(VenteDTO:: fromEntityVentes)
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "The vente with the code: "+code+" does not exist in the database",
                                ErrorCode.VENTE_NOT_FOUND
                        )
                );
    }

    @Override
    public List<VenteDTO> getAll() {
        return ventesRepository.findAll()
                .stream()
                .map(VenteDTO:: fromEntityVentes)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Integer id) {
        if(id== null){
            log.error("The code does not null");
            return false;
        }
        ventesRepository.deleteById(id);
        return true;
    }
}
