package com.fatiharge.mapper;


import com.fatiharge.shared.user.dto.user.CreateUserRequest;
import com.fatiharge.shared.user.dto.user.UserResponse;
import com.fatiharge.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", constant = "user")
    @Mapping(target = "password", expression = "java(io.quarkus.elytron.security.common.BcryptUtil.bcryptHash(createUserRequest.password))")
    User toEntity(CreateUserRequest createUserRequest);

    UserResponse toResponse(User user);
}
