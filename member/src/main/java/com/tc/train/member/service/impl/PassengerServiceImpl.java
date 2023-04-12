package com.tc.train.member.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tc.train.common.context.LoginMemberContext;
import com.tc.train.common.entity.resp.PageResp;
import com.tc.train.common.util.SnowUtil;
import com.tc.train.member.domain.Passenger;
import com.tc.train.member.domain.PassengerExample;
import com.tc.train.member.mapper.PassengerMapper;
import com.tc.train.member.req.PassengerQueryReq;
import com.tc.train.member.req.PassengerSaveOrUpdateReq;
import com.tc.train.member.resp.PassengerQueryResp;
import com.tc.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    Logger log = LoggerFactory.getLogger(PassengerServiceImpl.class);
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
    public PageResp<PassengerQueryResp> queryList(PassengerQueryReq req) {
        log.info("查询页码：{}",req.getPage());
        log.info("每页条数：{}",req.getSize());
        PassengerExample passengerExample = new PassengerExample();
        PassengerExample.Criteria criteria = passengerExample.createCriteria();
        if(ObjectUtil.isNotNull(req.getMemberId())){
            criteria.andMemberIdEqualTo(req.getMemberId());
        }
        PageHelper.startPage(req.getPage(),req.getSize());
        List<Passenger> passengers = passengerMapper.selectByExample(passengerExample);
        PageInfo<Passenger> pageInfo = new PageInfo<>(passengers);
        log.info("总行数: {}",pageInfo.getTotal());
        log.info("总页数：{}",pageInfo.getPages());
        List<PassengerQueryResp> list = BeanUtil.copyToList(passengers,PassengerQueryResp.class);
        PageResp<PassengerQueryResp> listPageResp = new PageResp<>();
        listPageResp.setTotal(pageInfo.getTotal());
        listPageResp.setList(list);
        return listPageResp;
    }

}
