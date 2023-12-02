package com.example.seminar.controller;


import com.example.seminar.dto.PostRequest;
import com.example.seminar.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    //Valid를 사용한 경우에는 앞에다가 어노테이션을 붙여줘야함
    public ResponseEntity<Void> createPost(@Valid @RequestBody PostRequest request) {
        postService.create(request);
        return ResponseEntity.ok().build();
    }
}