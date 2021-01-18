package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 어노테이션 활성화
@SpringBootApplication ///스프링 부트의 자동 설정, 스프링 빈 읽기와 생성이 자동 설정
public class Application {//메인 클래스
     public static void main(String[] args){

          SpringApplication.run(Application.class,args);//내장 WAS실행
     }
}
