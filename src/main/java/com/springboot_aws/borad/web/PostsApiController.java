package com.springboot_aws.borad.web;

import com.springboot_aws.borad.service.PostsService;
import com.springboot_aws.borad.web.dto.PostsResponseDto;
import com.springboot_aws.borad.web.dto.PostsSaveRequestDto;
import com.springboot_aws.borad.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto reqeustDto) {
        return postsService.update(id, reqeustDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
