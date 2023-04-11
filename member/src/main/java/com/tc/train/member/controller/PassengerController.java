package com.tc.train.member.controller;

import com.tc.train.common.entity.resp.CommonResp;
import com.tc.train.member.req.PassengerSaveOrUpdateReq;
import com.tc.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
