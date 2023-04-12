package com.tc.train.member.controller;

import com.tc.train.common.context.LoginMemberContext;
import com.tc.train.common.entity.resp.CommonResp;
import com.tc.train.member.req.PassengerQueryReq;
import com.tc.train.member.req.PassengerSaveOrUpdateReq;
import com.tc.train.member.resp.PassengerQueryResp;
import com.tc.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Resource
    private PassengerService passengerService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody PassengerSaveOrUpdateReq req){
        passengerService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<List<PassengerQueryResp>> queryList(@Valid PassengerQueryReq req){
        req.setMemberId(LoginMemberContext.getId());
        List<PassengerQueryResp> list = passengerService.queryList(req);
        return new CommonResp<>(list);
    }
}
