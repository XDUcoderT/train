package com.tc.train.member.service.impl;

import com.tc.train.member.mapper.MemberMapper;
import com.tc.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;
    @Override
    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }
}
