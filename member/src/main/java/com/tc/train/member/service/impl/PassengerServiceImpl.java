package com.tc.train.member.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import com.tc.train.common.util.SnowUtil;
import com.tc.train.member.domain.Passenger;
import com.tc.train.member.mapper.PassengerMapper;
import com.tc.train.member.req.PassengerSaveOrUpdateReq;
import com.tc.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Resource
    private PassengerMapper passengerMapper;
    @Override
    public void save(PassengerSaveOrUpdateReq req) {
        DateTime now = DateTime.now();
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        passenger.setId(SnowUtil.getSnowflakeNextId());
        passenger.setCreateTime(now);
        passenger.setUpdateTime(now);
        passengerMapper.insert(passenger);
    }
}
