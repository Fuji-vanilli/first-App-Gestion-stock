package com.gestionStock.stockgestion.services.servicesImplementation;

import com.gestionStock.stockgestion.DTOs.UserDTO;
import com.gestionStock.stockgestion.exceptions.EntityNotFoundException;
import com.gestionStock.stockgestion.exceptions.ErrorCode;
import com.gestionStock.stockgestion.exceptions.InvalidEntityException;
import com.gestionStock.stockgestion.models.User;
import com.gestionStock.stockgestion.repositories.UserRepository;
import com.gestionStock.stockgestion.services.businessService.IUserService;
import com.gestionStock.stockgestion.validators.UserValidator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class UserService implements IUserService {
    private UserRepository userRepository;

    public UserService(
            UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        List<String> errors= UserValidator.validate(userDTO);

        if(!errors.isEmpty()){
            log.error("User is not valid");
            throw new InvalidEntityException(
                    "User not valid",
                    ErrorCode.USER_NOT_VALID,
                    errors
            );
        }
        return UserDTO.fromEntityUser(
                userRepository.save(UserDTO.toEntityUser(userDTO))
        );
    }

    @Override
    public UserDTO getById(Integer id) {
        if(id== null){
            log.error("The id is null");
            return null;
        }

        Optional<User> user= userRepository.findById(id);

        return Optional.of(
                UserDTO.fromEntityUser(user.get())
        ).orElseThrow(()->
                new EntityNotFoundException(
                        "The user with the id: "+id+" doesn't exist on the database",
                        ErrorCode.USER_NOT_FOUND)
                );
    }

    @Override
    public UserDTO getByFirstName(String firstName) {
        if(firstName== null){
            log.error("The firstname is null");
            return null;
        }

        Optional<User> user= userRepository.findByFirstName(firstName);

        return Optional.of(
                UserDTO.fromEntityUser(user.get())
        ).orElseThrow(()->
                new EntityNotFoundException(
                        "The user with the firstname: "+firstName+" doesn't exist on the database",
                        ErrorCode.USER_NOT_FOUND)
        );

    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO:: fromEntityUser)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Integer id) {
        if(id== null){
            log.error("The id is null");
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }
}
