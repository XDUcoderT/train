package com.tc.train.member.req;

import com.tc.train.common.entity.constants.ValidationConstant;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberRegisterReq {

    @NotBlank(message = ValidationConstant.MOBILE_NOT_NULL)
    private String mobile;

}
