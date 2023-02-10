package com.gestionStock.stockgestion.services.servicesImplementation;

import com.gestionStock.stockgestion.DTOs.RolesDTO;
import com.gestionStock.stockgestion.exceptions.EntityNotFoundException;
import com.gestionStock.stockgestion.exceptions.ErrorCode;
import com.gestionStock.stockgestion.exceptions.InvalidEntityException;
import com.gestionStock.stockgestion.models.Roles;
import com.gestionStock.stockgestion.repositories.RolesRepository;
import com.gestionStock.stockgestion.services.businessService.IRolesService;
import com.gestionStock.stockgestion.validators.RolesValidator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class RolesService implements IRolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public RolesService(
            RolesRepository rolesRepository){
        this.rolesRepository= rolesRepository;
    }

    @Override
    public RolesDTO create(RolesDTO rolesDTO) {
        List<String> errors= RolesValidator.validate(rolesDTO);

        if(!errors.isEmpty()){
            log.error("The roles is not valid");
            throw new InvalidEntityException(
                    "Roles not valid",
                    ErrorCode.ROLES_NOT_VALID,
                    errors
            );
        }
        return null;
    }

    @Override
    public RolesDTO getById(Integer id) {
        if(id== null){
            log.error("The id Role is null");
            return null;
        }

        Optional<Roles> roles= rolesRepository.findById(id);

        return Optional.of(
                RolesDTO.fromEntityRole(roles.get())
        ).orElseThrow(()->
            new EntityNotFoundException(
                    "The roles entity of id: "+id+" doesn't exist on the database",
                    ErrorCode.ROLES_NOT_FOUND
            )
        );
    }

    @Override
    public RolesDTO getByName(String name) {
        if(name== null){
            log.error("The name of roles is null");
            return null;
        }

        Optional<Roles> roles= rolesRepository.findByName(name);

        return Optional.of(
                RolesDTO.fromEntityRole(roles.get())
        ).orElseThrow(()->
            new EntityNotFoundException(
                    "The roles with name: "+name+" doesn't exist on the database",
                    ErrorCode.ROLES_NOT_FOUND
            )
        );
    }

    @Override
    public List<RolesDTO> getAll() {

        return rolesRepository.findAll()
                .stream()
                .map(RolesDTO:: fromEntityRole)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Integer id) {
        if(id== null){
            log.error("The id is null");
            return false;
        }
        rolesRepository.deleteById(id);
        return true;
    }
}
