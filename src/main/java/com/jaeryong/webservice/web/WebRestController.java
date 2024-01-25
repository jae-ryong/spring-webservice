package com.jaeryong.webservice.web;

import com.jaeryong.webservice.domain.dto.PostSaveReqeustDto;
import com.jaeryong.webservice.domain.posts.PostsRepository;
import com.jaeryong.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;
    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostSaveReqeustDto dto){

        return postsService.save(dto);
    }

}
