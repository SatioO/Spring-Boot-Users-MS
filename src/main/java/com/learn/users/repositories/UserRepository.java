package com.learn.users.repositories;

import com.learn.users.dto.UserDto;
import com.learn.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("Select new com.learn.users.dto.UserDto(u.name, u.gender, u.userId) from UserEntity u")
    List<UserDto> findUsers();
    @Query("Select new com.learn.users.dto.UserDto(u.name, u.gender, u.userId) from UserEntity u where u.userId = ?1")
    UserDto findUserById(String id);
}
