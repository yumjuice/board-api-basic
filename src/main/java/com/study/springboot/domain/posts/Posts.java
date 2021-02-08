package com.study.springboot.web.domain.posts;

import com.study.springboot.web.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity { //실제 디비 테이블과 매칭될 클래스 entity클래스라고 불림

    @Id //PK임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)//pk생성규칙 GenerationType.IDENTITY==auto increment
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition= "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void update(String title, String content){
        this.title= title;
        this.content=content;
    }
}
