package com.tc.train.member.req;

import com.tc.train.common.entity.req.PageReq;
import lombok.Data;

@Data
public class PassengerQueryReq extends PageReq {
    Long memberId;
}
