package com.study.springboot.service.posts;

import com.study.springboot.web.domain.posts.Posts;
import com.study.springboot.web.domain.posts.PostsRepository;
import com.study.springboot.web.dto.PostsListResponseDto;
import com.study.springboot.web.dto.PostsResponseDto;
import com.study.springboot.web.dto.PostsSaveRequestDto;
import com.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor//생성자를 통한 의존성 주입을 위해 필요
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    //게시글 저장(=생성)
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    //글 수정
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts);//엔티티를 가져와서 삭제
        //deleteById 메소드를 이용하면 id로 바로 삭제할 수도 있음
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new) // new PostsListResponseDto(posts)
                .collect(Collectors.toList()); //List로 변환
    }

}
