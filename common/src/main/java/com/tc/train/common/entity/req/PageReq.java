package com.tc.train.common.entity.req;

import com.tc.train.common.entity.constants.ValidationConstant;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PageReq {

    @NotNull(message = ValidationConstant.PAGE_NOT_NULL)
    private Integer page;

    @NotNull(message = ValidationConstant.PAGESIZE_NOT_NULL)
    @Max(value = 100, message = ValidationConstant.PAGESIZE_NOT_OVER_100)
    private Integer size;
}
