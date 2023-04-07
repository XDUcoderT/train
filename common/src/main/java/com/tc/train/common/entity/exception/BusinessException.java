package com.tc.train.common.entity.exception;

import com.tc.train.common.entity.enums.BusinessExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException{
    private BusinessExceptionEnum e;

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
