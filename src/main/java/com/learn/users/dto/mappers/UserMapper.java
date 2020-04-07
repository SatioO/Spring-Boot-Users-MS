package com.learn.users.dto.mappers;

import com.learn.users.dto.models.UserDTO;
import com.learn.users.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDTO toUserDto(User user) {
        return new UserDTO().setName(user.getName())
                .setGender(user.getGender())
                .setUserId(user.getUserId());
    }
}
