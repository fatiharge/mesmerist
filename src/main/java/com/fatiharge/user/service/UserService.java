package com.fatiharge.user.service;

import com.fatiharge.shared.user.dto.user.CreateUserRequest;
import com.fatiharge.shared.user.dto.user.UserResponse;
import com.fatiharge.user.domain.User;
import com.fatiharge.user.mapper.UserMapper;
import com.fatiharge.user.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;
    @Inject
    UserMapper userMapper;


    public UserResponse createUser(CreateUserRequest createUserRequest) {
        User user = userRepository.createUser(userMapper.toEntity(createUserRequest));
        return userMapper.toResponse(user);
    }

    public UserResponse getUserById(Long id) {
        return userMapper.toResponse(userRepository.getUserById(id));
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}