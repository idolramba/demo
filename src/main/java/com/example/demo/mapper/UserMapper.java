package com.example.demo.mapper;

import com.example.demo.dto.FavrDto;
import com.example.demo.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserVo> getUserList();
    void deleteUsersByIds(List<Long> userIds);
    List <FavrDto> getFavrList(Long id);
    List <FavrDto> getAprvListById(Long id);
    void delFavrByIds(List<Long> favrId);
}
