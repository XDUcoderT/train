package com.tc.train.member.service;

import com.tc.train.member.req.MemberLoginReq;
import com.tc.train.member.req.MemberRegisterReq;
import com.tc.train.member.req.MemberSendCodeReq;
import com.tc.train.member.resp.MemberLoginResp;

public interface MemberService {
    public int count();

    public long register(MemberRegisterReq mobile);

    public void sendCode(MemberSendCodeReq req);

    public MemberLoginResp login(MemberLoginReq req);
}
