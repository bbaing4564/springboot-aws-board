package com.springboot_aws.borad.service;

import com.springboot_aws.borad.domain.posts.PostsRepository;
import com.springboot_aws.borad.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostsRepository postRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();

    }
}
