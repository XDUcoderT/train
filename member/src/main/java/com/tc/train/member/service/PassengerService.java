package com.tc.train.member.service;

import com.tc.train.common.entity.resp.PageResp;
import com.tc.train.member.req.PassengerQueryReq;
import com.tc.train.member.req.PassengerSaveOrUpdateReq;
import com.tc.train.member.resp.PassengerQueryResp;

public interface PassengerService {
    public void save(PassengerSaveOrUpdateReq req);

    public PageResp<PassengerQueryResp> queryList(PassengerQueryReq req);
}
