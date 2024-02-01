package com.jaeryong.webservice.service;

import com.jaeryong.webservice.domain.dto.PostSaveReqeustDto;
import com.jaeryong.webservice.domain.posts.Posts;
import com.jaeryong.webservice.domain.posts.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostsServiceTest {

    private final PostsRepository postsRepository;

    @Autowired
    public PostsServiceTest(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 데이터가_posts테이블에_저장된다(){
        //given
        PostSaveReqeustDto dto = PostSaveReqeustDto.builder()
                .title("안녕")
                .author("조재룡")
                .content("jpa 신기하다.")
                .build();

        //when
        postsRepository.save(dto.toEntity());

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
    }
}