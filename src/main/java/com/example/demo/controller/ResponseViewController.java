package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    // 컨트롤러의 @RequestMapping 경로와 View의 논리적 이름이 같으면 반환을 void로 지정해도 View가 랜더가 된다.
    @RequestMapping("/hello")
    public void responseViewV(Model model) {
        model.addAttribute("data", "hello");
    }

    // HTML 텍스트 반환
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("hello").addObject("data", "hello!");

        return mav;
    }

    // 클래스에 @Controller가 붙어있으면 메서드 return 문자열이 View의 논리 이름이 된다. 뷰 리졸버가 물리 경로로 바꿔준다.
    // 주의! 만약 메서드에 @ResponseBody를 사용하면 View 경로가 단순 응답 텍스트가 된다.
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!!");
        model.addAttribute("name", "Song du ho!!");
        return "hello";
    }

    // HTML 텍스트 반환
    @RequestMapping("/response-view-v3")
    public ModelAndView responseViewV3() {
        ModelAndView mav = new ModelAndView("/hello");

        mav.addObject("data", "hello!!!");
        mav.addObject("name", "Song du ho!!!");

        return mav;
    }

}