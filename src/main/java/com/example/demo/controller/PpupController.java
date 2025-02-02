package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class PpupController {
    // HTML 텍스트 반환
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    // HTML 텍스트 반환
    @RequestMapping("/content")
    public String content() {
        return "content";
    }

    // HTML 텍스트 반환
    @RequestMapping("/content2")
    public String content2() {
        return "content2";
    }

    @GetMapping("/index")
    public String index(@RequestParam("id") String id, Model model) {

        model.addAttribute("id", id);

        return "index";
    }
}
