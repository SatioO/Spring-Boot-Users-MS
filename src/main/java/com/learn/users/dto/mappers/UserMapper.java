package com.learn.users.dto.mappers;

import com.learn.users.dto.models.UserDto;
import com.learn.users.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto().setName(user.getName())
                .setGender(user.getGender())
                .setUserId(user.getUserId());
    }
}
