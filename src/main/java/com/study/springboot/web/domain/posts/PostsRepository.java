package com.study.springboot.web.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    //디비에 접근하는 객체 , 기본 CRUD 자동 생성됨
}