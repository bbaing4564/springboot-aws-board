package com.springboot_aws.borad.service;

import com.springboot_aws.borad.domain.posts.Posts;
import com.springboot_aws.borad.domain.posts.PostsRepository;
import com.springboot_aws.borad.web.dto.PostsResponseDto;
import com.springboot_aws.borad.web.dto.PostsSaveRequestDto;
import com.springboot_aws.borad.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto reqeustDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        posts.update(reqeustDto.getTitle(), reqeustDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }
}
