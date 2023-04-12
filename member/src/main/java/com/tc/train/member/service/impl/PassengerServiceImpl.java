package com.tc.train.member.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.tc.train.common.context.LoginMemberContext;
import com.tc.train.common.util.SnowUtil;
import com.tc.train.member.domain.Passenger;
import com.tc.train.member.domain.PassengerExample;
import com.tc.train.member.mapper.PassengerMapper;
import com.tc.train.member.req.PassengerQueryReq;
import com.tc.train.member.req.PassengerSaveOrUpdateReq;
import com.tc.train.member.resp.PassengerQueryResp;
import com.tc.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Resource
    private PassengerMapper passengerMapper;
    @Override
    public void save(PassengerSaveOrUpdateReq req) {
        DateTime now = DateTime.now();
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        passenger.setId(SnowUtil.getSnowflakeNextId());
        passenger.setMemberId(LoginMemberContext.getId());
        passenger.setCreateTime(now);
        passenger.setUpdateTime(now);
        passengerMapper.insert(passenger);
    }

    @Override
    public List<PassengerQueryResp> queryList(PassengerQueryReq req) {
        PassengerExample passengerExample = new PassengerExample();
        PassengerExample.Criteria criteria = passengerExample.createCriteria();
        if(ObjectUtil.isNotNull(req.getMemberId())){
            criteria.andMemberIdEqualTo(req.getMemberId());
        }
        PageHelper.startPage(req.getPage(),req.getSize());
        List<Passenger> passengers = passengerMapper.selectByExample(passengerExample);
        List<PassengerQueryResp> passengerQueryRespList = BeanUtil.copyToList(passengers, PassengerQueryResp.class);
        return passengerQueryRespList;
    }



}
