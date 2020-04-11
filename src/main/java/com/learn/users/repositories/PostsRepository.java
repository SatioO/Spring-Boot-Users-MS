package com.learn.users.repositories;

import com.learn.users.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostsRepository extends JpaRepository<Post, Long> {
}
