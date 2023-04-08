package com.tc.train.member.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import com.tc.train.common.entity.enums.BusinessExceptionEnum;
import com.tc.train.common.entity.exception.BusinessException;
import com.tc.train.common.util.SnowUtil;
import com.tc.train.member.domain.Member;
import com.tc.train.member.domain.MemberExample;
import com.tc.train.member.mapper.MemberMapper;
import com.tc.train.member.req.MemberRegisterReq;
import com.tc.train.member.req.MemberSendCodeReq;
import com.tc.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

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

        //不为空就抛出异常
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

    @Override
    public void sendCode(MemberSendCodeReq req) {
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);

        //如果手机号不存在，插入记录
        if(CollUtil.isEmpty((list))){
            log.info("手机号不存在：{}",mobile);
            Member member = new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(mobile);
            memberMapper.insert(member);
        }else{
            log.info("手机号存在：{}",mobile);
        }

        //生成验证码
        String code = RandomUtil.randomString(4);
        log.info("生成的验证码为:{}",code);

        //保存短信记录表：手机号，短信验证码，有效期，是否已使用，业务类型，发送时间，使用时间
        log.info("保存短信记录表");

        //对接短信通道，发送短信
        log.info("发送短信验证码");
    }
}
