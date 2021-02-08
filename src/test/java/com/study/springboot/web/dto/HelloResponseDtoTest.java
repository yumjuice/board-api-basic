package com.study.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest  {

    @Test
    //롬복 Get 메서드와 @RequiredArgsConstructor 검증
    public void 롬복_기능_테스트(){
        String name="test";
        int amount=1000;

        HelloResponseDto dto=new HelloResponseDto(name,amount);

        //asserj 테스트 검증 라이브러리
        //assertThat 검증 메서드
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}