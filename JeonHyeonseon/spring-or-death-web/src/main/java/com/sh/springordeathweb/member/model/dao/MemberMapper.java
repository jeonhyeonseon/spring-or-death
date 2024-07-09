package com.sh.springordeathweb.member.model.dao;

import com.sh.springordeathweb.member.model.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int insertMember(MemberDto memberDto);
    int checkDuplicateEmail(String memberEmail);
}
