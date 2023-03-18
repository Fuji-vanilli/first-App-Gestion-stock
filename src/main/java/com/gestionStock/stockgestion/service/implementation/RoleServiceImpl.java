package com.gestionStock.stockgestion.service.implementation;

import com.gestionStock.stockgestion.DTOs.mapper.RoleMapping;
import com.gestionStock.stockgestion.DTOs.request.RoleRequest;
import com.gestionStock.stockgestion.DTOs.response.RoleResponse;
import com.gestionStock.stockgestion.exception.ErrorCode;
import com.gestionStock.stockgestion.exception.InvalidEntityException;
import com.gestionStock.stockgestion.models.Roles;
import com.gestionStock.stockgestion.repositories.RolesRepository;
import com.gestionStock.stockgestion.service.RoleService;
import com.gestionStock.stockgestion.validator.RoleValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RolesRepository rolesRepository;
    private final RoleMapping roleMapping;

    @Override
    public RoleResponse create(RoleRequest roleRequest) {
        List<String> errors= RoleValidator.validate(roleRequest);

        if(!errors.isEmpty()){
            log.error("role not valid");
            throw new InvalidEntityException(
                    "role not valid",
                    ErrorCode.ROLES_NOT_VALID,
                    errors
            );
        }

        Roles role= roleMapping.roleRequestToRole(roleRequest);
        role.setId(UUID.randomUUID().toString());

        return roleMapping.roleToRoleResponse(
                rolesRepository.save(role)
        );
    }
}
