package com.luoziyang.demo.controller;

import com.luoziyang.demo.Service.ActivemqService;
import com.luoziyang.demo.Service.SsmCodeService;
import com.luoziyang.demo.domain.SsmCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author luoziyang
 * @create 2023-06-27
 */
@RestController
@RequestMapping("/Ssms")
public class SsmCodecontroller {
    @Autowired
    private SsmCodeService ssmCodeService;
    @Autowired
    private ActivemqService activemqService;

    @GetMapping("{tel}")
    public String getCode(@PathVariable String tel){
        String mes=ssmCodeService.sendCodeToSMS(tel);
        activemqService.sendMessage(mes);
        return mes;

    }
    @PostMapping
    public Boolean CheckCode(SsmCode ssmCode){
       return ssmCodeService.checkCode(ssmCode);
    }
}
