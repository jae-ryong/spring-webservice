package com.jaeryong.webservice.domain.dto;

import com.jaeryong.webservice.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostSaveReqeustDto {

    private String title;
    private String content;
    private String author;

    @Override
    public String toString() {
        return "PostSaveReqeustDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
