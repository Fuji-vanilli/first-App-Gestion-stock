package com.gestionStock.stockgestion.service;

import com.gestionStock.stockgestion.DTOs.request.UserRequest;
import com.gestionStock.stockgestion.DTOs.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(UserRequest userRequest);
    UserResponse getById(String id);
    UserResponse getByEmail(String email);
    List<UserResponse> getAll();
    boolean delete(String id);
}
