package com.learn.users.dto.mappers;

import com.learn.users.dto.models.UserDTO;
import com.learn.users.entities.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {
    public static UserDTO toUserDTO(User user) {
        return new UserDTO().setName(user.getName())
                .setGender(user.getGender())
                .setUserId(user.getUserId())
                .setBooks(
                    user.getBooks().stream()
                    .map(BookMapper::toBookDTO)
                    .collect(Collectors.toList())
                );
    }
}
