package com.tc.train.member.service;

import com.tc.train.member.req.MemberRegisterReq;

public interface MemberService {
    public int count();

    public long register(MemberRegisterReq mobile);
}
