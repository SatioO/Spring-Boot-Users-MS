package com.learn.users.controllers;

import com.learn.users.entities.Comment;
import com.learn.users.entities.Post;
import com.learn.users.exceptions.ResourceNotFoundException;
import com.learn.users.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postRequest) {
        return postsRepository.findById(postId).map(post -> {
            post.setTitle(postRequest.getTitle());
            return postsRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return postsRepository.findById(postId).map(post -> {
            postsRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
}
