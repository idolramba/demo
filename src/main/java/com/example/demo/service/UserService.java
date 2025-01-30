package com.example.demo.service;

import com.example.demo.dto.FavrDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserVo> getUserList() {
        return userMapper.getUserList();
    }

    // 사용자 삭제 로직
    public void deleteUsers(List<Long> userIds) {
        // 전달된 ID 목록을 기반으로 사용자 삭제
        userMapper.deleteUsersByIds(userIds);
    }

    public List<FavrDto> getFavrList() {
        return userMapper.getFavrList();
    }

    public List<FavrDto> getAprvListById(Long id) {
        return userMapper.getAprvListById(id);
    }

    // 즐겨찿기 삭제 로직
    public void delFavrByIds(List<Long> userIds) {
        // 전달된 ID 목록을 기반으로 사용자 삭제
        userMapper.delFavrByIds(userIds);
    }

}


