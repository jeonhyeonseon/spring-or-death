package com.sh.springordeathweb.member.model.service;

import com.sh.springordeathweb.member.model.dao.MemberMapper;
import com.sh.springordeathweb.member.model.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberCommandService {
    private final MemberMapper memberMapper;

    public int insertMember(MemberDto memberDto) {
        return memberMapper.insertMember(memberDto);
    }

    public int checkDuplicateEmail(String memberEmail){
        return memberMapper.checkDuplicateEmail(memberEmail);
    }
}
