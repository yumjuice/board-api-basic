package com.study.springboot.web;

import com.study.springboot.web.dto.PostsResponseDto;
import com.study.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
//페이지 뷰 관련 컨트롤러
public class IndexController {

    private final PostsService postsService; //의존성 주입 , @RequiredArgsConstructor로 인해 자동 생성됨

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
        //머스테치 스타터로 인해 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정됨
        //"index" => "src/main/resources/templates/index.mustache" 로 전환되어 view Resolver가 처리함
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto=postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }


}
