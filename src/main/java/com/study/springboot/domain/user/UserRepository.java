package com.study.springboot.web.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email); //이메일을 통해 이미 생성된 유저인지 처음 가입하는 사용자인지 판별
}
