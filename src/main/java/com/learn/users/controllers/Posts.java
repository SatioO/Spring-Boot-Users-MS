package com.learn.users.controllers;

import com.learn.users.entities.Post;
import com.learn.users.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("posts")
public class Posts {
    @Autowired
    private PostsRepository postsRepository;

    @GetMapping
    public List<Post> getAllPosts() {
        return postsRepository.findAll();
    }

    @PostMapping
    public Post createPost(@Valid @RequestBody Post post) {
        return postsRepository.save(post);
    }
}
