package com.learn.users.repositories;

import com.learn.users.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
}
