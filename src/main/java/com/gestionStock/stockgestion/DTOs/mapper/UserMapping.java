package com.gestionStock.stockgestion.DTOs.mapper;

import com.gestionStock.stockgestion.DTOs.request.UserRequest;
import com.gestionStock.stockgestion.DTOs.response.UserResponse;
import com.gestionStock.stockgestion.models.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapping {
    UserResponse userToUserResponse(Users users);
    Users userRequestToUser(UserRequest userRequest);
}
