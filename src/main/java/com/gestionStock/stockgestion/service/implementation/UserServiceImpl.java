package com.gestionStock.stockgestion.service.implementation;

import com.gestionStock.stockgestion.DTOs.mapper.UserMapping;
import com.gestionStock.stockgestion.DTOs.request.UserRequest;
import com.gestionStock.stockgestion.DTOs.response.SaleResponse;
import com.gestionStock.stockgestion.DTOs.response.UserResponse;
import com.gestionStock.stockgestion.exception.EntityNotFoundException;
import com.gestionStock.stockgestion.exception.ErrorCode;
import com.gestionStock.stockgestion.exception.InvalidEntityException;
import com.gestionStock.stockgestion.models.Sale;
import com.gestionStock.stockgestion.models.Users;
import com.gestionStock.stockgestion.repositories.UserRepository;
import com.gestionStock.stockgestion.service.UserService;
import com.gestionStock.stockgestion.validator.UserValidator;
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
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapping userMapping;

    @Override
    public UserResponse create(UserRequest userRequest) {
        List<String> errors= UserValidator.validate(userRequest);

        if(!errors.isEmpty()){
            log.error("the user not valid");
            throw new InvalidEntityException(
                    "user not valid",
                    ErrorCode.USER_NOT_VALID,
                    errors
            );
        }

        Users user= userMapping.userRequestToUser(userRequest);

        user.setId(UUID.randomUUID().toString());

        return userMapping.userToUserResponse(
                userRepository.save(user)
        );
    }

    @Override
    public UserResponse getById(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            throw new InvalidEntityException(
                    "the id doesn't null",
                    ErrorCode.USER_NOT_VALID
            );
        }

        Optional<Users> user= userRepository.findById(id);

        UserResponse userResponse= userMapping.userToUserResponse(user.get());

        return Optional.of(userResponse)
                .orElseThrow(
                        ()-> new EntityNotFoundException(
                                "the user with the id: "+id+" doesn't exist in the database",
                                ErrorCode.USER_NOT_FOUND
                        )
                );
    }

    @Override
    public UserResponse getByEmail(String email) {
        if(!StringUtils.hasLength(email)){
            log.error("email doesn't null");
            throw new InvalidEntityException(
                    "the email doesn't null",
                    ErrorCode.USER_NOT_VALID
            );
        }

        Optional<Users> user= userRepository.findByEmail(email);

        UserResponse userResponse= userMapping.userToUserResponse(user.get());

        return Optional.of(userResponse)
                .orElseThrow(
                        ()-> new EntityNotFoundException(
                                "the user with the email: "+email+" doesn't exist in the database",
                                ErrorCode.USER_NOT_FOUND
                        )
                );
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(user-> userMapping.userToUserResponse(user))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }
}
