package com.learn.users.controllers;

import com.learn.users.entities.Comment;
import com.learn.users.exceptions.ResourceNotFoundException;
import com.learn.users.repositories.CommentsRepository;
import com.learn.users.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "comments")
public class Comments {
    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private PostsRepository postsRepository;

    @GetMapping
    public List<Comment> getComments() {
        return commentsRepository.findAll();
    }

    @PostMapping("/{postId}")
    public Comment createComment(@PathVariable (value = "postId") Long postId,
                                 @Valid @RequestBody Comment comment) {
        return postsRepository.findById(postId).map(post -> {
            post.add(comment);
            return commentsRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException(""));
    }

}
