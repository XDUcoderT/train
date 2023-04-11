package com.tc.train.common.context;


import com.tc.train.common.resp.MemberGlobalInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginMemberContext {
    private static final Logger LOG = LoggerFactory.getLogger(LoginMemberContext.class);

    private static final ThreadLocal<MemberGlobalInfo> member = new ThreadLocal<>();

    public static MemberGlobalInfo getMember() {
        return member.get();
    }

    public static void setMember(MemberGlobalInfo member) {
        LoginMemberContext.member.set(member);
    }

    public static Long getId() {
        try {
            return member.get().getId();
        } catch (Exception e) {
            LOG.error("获取登录会员信息异常", e);
            throw e;
        }
    }

}
