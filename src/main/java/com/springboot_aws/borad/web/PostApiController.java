package com.springboot_aws.borad.web;

import com.springboot_aws.borad.service.PostService;
import com.springboot_aws.borad.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public long save(@RequestBody PostsSaveRequestDto requestDto){
        return postService.save(requestDto);
    }

}
