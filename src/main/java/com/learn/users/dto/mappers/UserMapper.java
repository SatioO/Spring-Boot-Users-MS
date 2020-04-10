package com.learn.users.dto.mappers;

import com.learn.users.dto.models.UserDTO;
import com.learn.users.entities.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class UserMapper {
    public static UserDTO toUserDTO(User user) {
        return new UserDTO()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setGender(user.getGender())
                .setEmail(user.getEmail());
    }

    public static User toUserEntity(UserDTO user) {
        return new User()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setGender(user.getGender())
                .setEmail(user.getEmail());
    }
}
