package com.learn.users.controllers;

import com.learn.users.dto.models.CommentDTO;
import com.learn.users.dto.models.PostDTO;
import com.learn.users.entities.Post;
import com.learn.users.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("posts")
public class Posts {
    @Autowired
    private PostsRepository postsRepository;

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postsRepository.findAll().stream().map(i -> new PostDTO().setTitle(i.getTitle())
                    .setComments(i.getComments().stream()
                        .map(j -> new CommentDTO().setText(j.getText()))
                        .collect(Collectors.toList()))
                ).collect(Collectors.toList());
    }

    @PostMapping
    public Post createPost(@Valid @RequestBody Post post) {
        return postsRepository.save(post);
    }
}
