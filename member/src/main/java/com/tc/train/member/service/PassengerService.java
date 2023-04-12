package com.tc.train.member.service;

import com.tc.train.member.req.PassengerQueryReq;
import com.tc.train.member.req.PassengerSaveOrUpdateReq;
import com.tc.train.member.resp.PassengerQueryResp;

import java.util.List;

public interface PassengerService {
    public void save(PassengerSaveOrUpdateReq req);

    public List<PassengerQueryResp> queryList(PassengerQueryReq req);
}
