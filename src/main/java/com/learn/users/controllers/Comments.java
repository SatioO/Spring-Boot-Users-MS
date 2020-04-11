package com.learn.users.controllers;

import com.learn.users.entities.Comment;
import com.learn.users.entities.Post;
import com.learn.users.exceptions.ResourceNotFoundException;
import com.learn.users.repositories.CommentsRepository;
import com.learn.users.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "comments")
public class Comments {
    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private PostsRepository postsRepository;

    @GetMapping("/{postId}/comments")
    public Page<Comment> getAllCommentsByPostId(@PathVariable (value = "postId") Long postId,
                                                Pageable pageable) {
        return commentsRepository.findByPostId(postId, pageable);
    }

    @PostMapping("/{postId}/comments")
    public Comment createComment(@PathVariable (value = "postId") Long postId,
                                 @Valid @RequestBody Comment comment) {
        return postsRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentsRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

}
