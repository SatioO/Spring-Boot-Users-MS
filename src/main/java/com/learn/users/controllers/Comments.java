package com.learn.users.controllers;

import com.learn.users.dto.models.CommentDTO;
import com.learn.users.dto.models.PostDTO;
import com.learn.users.entities.Comment;
import com.learn.users.entities.Post;
import com.learn.users.exceptions.ResourceNotFoundException;
import com.learn.users.repositories.CommentsRepository;
import com.learn.users.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<Comment> getComments() {
        return commentsRepository.findAll()
                .stream()
                .map(i -> {
                    Post p = new Post();
                    p.setId(i.getPost().getId());
                    p.setTitle(i.getPost().getTitle());

                    Comment c = new Comment();
                    c.setId(i.getId());
                    c.setText(i.getText());
                    c.setPost(p);
                    return c;
                }).collect(Collectors.toList());
    }

    @PostMapping("/{postId}")
    public CommentDTO createComment(@PathVariable (value = "postId") Long postId,
                                    @Valid @RequestBody Comment comment) {
        return postsRepository.findById(postId).map(post -> {
            post.add(comment);
            commentsRepository.save(comment);
            return new CommentDTO().setText(comment.getText());
        }).orElseThrow(() -> new ResourceNotFoundException(""));
    }

}
