package com.study.springboot.web.domain.user;


import com.study.springboot.web.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //JPA에서는 프록시를 생성하기 위해 기본 생성자를 반드시 하나 생성해야 한다.
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING) //Enum값을 어떤 형태로 저장할지 결정 기본적으로 int, 숫자로 저장되면 데이터베이스로 확인할 때 그값이 무슨 뜻인지 바로 알 수 없으므로 문자열로 변경
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role){
        this.name=name;
        this.email=email;
        this.picture=picture;
        this.role=role;
    }

    public User update(String name, String picture){
        this.name=name;
        this.picture=picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
