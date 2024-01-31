//package com.jaeryong.webservice.domain.posts;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//class PostsRepositoryTest {
//
//    private final PostsRepository postsRepository;
//
//    @Autowired
//    public PostsRepositoryTest(PostsRepository postsRepository) {
//        this.postsRepository = postsRepository;
//    }
//
//    @AfterEach
//    public void cleanup() {
//        postsRepository.deleteAll();
//    }
//
//    @Test
//    public void 게시글저장하기() {
//        //given
//        postsRepository.save(Posts.builder()
//                .title("테스트입니다.")
//                .content("테스트 본문")
//                .author("frogs6225")
//                .build());
//        // when
//        List<Posts> list = postsRepository.findAll();
//
//        // then
//        Posts posts = list.get(0);
//        assertThat(posts.getTitle()).isEqualTo("테스트입니다.");
//        assertThat(posts.getContent()).isEqualTo("테스트 본문");
//        assertThat(posts.getAuthor()).isEqualTo("frogs6225");
//    }
//
//    @Test
//    public void BaseTimeEntity_확인 (){
//        // given
//        LocalDateTime now = LocalDateTime.now();
//        postsRepository.save(Posts.builder()
//                .title("테스트 게시글")
//                .content("테스트 본문")
//                .author("frogs6225")
//                .build());
//        // when
//        List<Posts> list = postsRepository.findAll();
//        int cnt=0;
//
//        // then
//        Posts posts = list.get(list.size()-1);
//        assertThat(posts.getCreatedTime()).isAfter(now);
//        assertThat(posts.getModifiedDate()).isAfter(now);
//    }
//
//}
