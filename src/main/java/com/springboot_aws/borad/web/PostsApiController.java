package com.springboot_aws.borad.web;

import com.springboot_aws.borad.service.PostsService;
import com.springboot_aws.borad.web.dto.PostsListResponseDto;
import com.springboot_aws.borad.web.dto.PostsResponseDto;
import com.springboot_aws.borad.web.dto.PostsSaveRequestDto;
import com.springboot_aws.borad.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @GetMapping("/api/v1/posts/list")
    public List<PostsListResponseDto> findAllDesc() {
        return postsService.findAllDesc();
    }
}
