package com.tc.train.member.req;


import com.tc.train.common.entity.constants.ValidationConstant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MemberSendCodeReq {
    @NotBlank(message = ValidationConstant.MOBILE_NOT_NULL)
    @Pattern(regexp = "^1\\d{10}$", message = ValidationConstant.MOBILE_PATTERN_ERROR)
    private String mobile;
}
