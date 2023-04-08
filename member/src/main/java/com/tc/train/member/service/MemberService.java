package com.tc.train.member.service;

import com.tc.train.member.req.MemberRegisterReq;
import com.tc.train.member.req.MemberSendCodeReq;

public interface MemberService {
    public int count();

    public long register(MemberRegisterReq mobile);

    public void sendCode(MemberSendCodeReq req);
}
