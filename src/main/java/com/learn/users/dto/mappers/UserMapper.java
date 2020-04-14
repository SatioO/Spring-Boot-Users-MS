package com.learn.users.dto.mappers;

import com.learn.users.dto.models.UserDTO;
import com.learn.users.entities.User;

public class UserMapper {
    public static UserDTO toUserDTO(User user) {
        return new UserDTO()
                .id(user.id())
                .firstName(user.firstName())
                .lastName(user.lastName())
                .gender(user.gender())
                .email(user.email());
    }

    public static User toUserEntity(UserDTO user) {
        return new User()
                .id(user.id())
                .firstName(user.firstName())
                .lastName(user.lastName())
                .gender(user.gender())
                .email(user.email());
    }
}
