package com.tc.train.member.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.tc.train.common.entity.enums.BusinessExceptionEnum;
import com.tc.train.common.entity.exception.BusinessException;
import com.tc.train.common.util.SnowUtil;
import com.tc.train.member.domain.Member;
import com.tc.train.member.domain.MemberExample;
import com.tc.train.member.mapper.MemberMapper;
import com.tc.train.member.req.MemberRegisterReq;
import com.tc.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    @Override
    public long register(MemberRegisterReq req) {
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        if(CollUtil.isNotEmpty((list))){
            //return list.get(0).getId();
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}
