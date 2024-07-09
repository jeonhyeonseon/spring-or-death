package com.sh.springordeathweb.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRegistDto {
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public MemberDto toMemeberDto() {
        return new MemberDto(null, this.memberEmail, this.memberPassword, this.memberName, LocalDateTime.now());
    }
}
