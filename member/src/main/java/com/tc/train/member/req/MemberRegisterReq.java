package com.tc.train.member.req;


import com.tc.train.common.entity.enums.ValidationEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberRegisterReq {
    @NotBlank(message = ValidationEnum.MOBILE_NOT_NULL)
    private String mobile;
}
