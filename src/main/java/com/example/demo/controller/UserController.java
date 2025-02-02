package com.example.demo.controller;

import com.example.demo.dto.FavrDto;
import com.example.demo.service.UserService;
import com.example.demo.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "index";  // 응답할 뷰 이름 또는 데이터
    }

    /*
    @GetMapping("/userList")
    public String getUserList(Model model) {
        List<UserVo> userList = userService.getUserList();
        model.addAttribute("list", userList);

        log.info("userList {}", userList);
        return "userList";
    }
    */
    // HTML 페이지를 반환하는 메소드
    @GetMapping("/userList")
    public String getUserListPage() {
        // HTML 템플릿을 반환 (Thymeleaf 템플릿)
        return "userList";
    }

    @GetMapping("/api/userList")
    @ResponseBody
    public List<UserVo> getUserList(Model model) {
        List<UserVo> userList = userService.getUserList();
        model.addAttribute("list", userList);

        log.info("userList {}", userList);
        return userList;
    }

    // 사용자 삭제 요청 처리
    @PostMapping("/deleteUsers")
    public ResponseEntity<String> deleteUsers(@RequestBody List<Long> ids) {
        log.info("Received ids: {}", ids);
        try {
            if (ids == null || ids.isEmpty()) {
                return ResponseEntity.badRequest().body("삭제할 사용자를 선택해주세요.");
            }
            userService.deleteUsers(ids); // 사용자 삭제
            return ResponseEntity.ok("삭제가 완료되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("삭제 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("/favrList")
    @ResponseBody
    public List<FavrDto> getFavrList(@RequestParam("id") Long id) {
        log.info("id = {}", id);

        List<FavrDto> favrList = userService.getFavrList(id);
        //model.addAttribute("list", favrList);

        log.info("userList = {}", favrList);
        return favrList;
    }

    @GetMapping("/apvrList")
    @ResponseBody
    public List<FavrDto> getAprvListById(@RequestParam("id") Long id) {
        List<FavrDto> favrList = userService.getAprvListById(id);
        //model.addAttribute("list", favrList);

        //
        if (favrList != null) {
            favrList = favrList.stream()            // 리스트를 스트림으로 변환
                    .filter(Objects::nonNull)       // null이 아닌 값만 필터링
                    .collect(Collectors.toList());  // 필터링된 결과를 리스트로 수집
        }

        log.info("favrList {}", favrList);
        return favrList;
    }

    // 즐겨찿기 삭제
    @PostMapping("/deleteFavr")
    public ResponseEntity<String> delFavrByIds(@RequestBody List<Long> ids) {
        log.info("Received ids: {}", ids);
        try {
            if (ids == null || ids.isEmpty()) {
                return ResponseEntity.badRequest().body("삭제할 즐겨찿기를 선택해주세요.");
            }
            userService.delFavrByIds(ids); // 사용자 삭제
            return ResponseEntity.ok("삭제가 완료되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("삭제 중 오류가 발생했습니다.");
        }
    }
}
