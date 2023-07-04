package com.luoziyang.demo.controller;

import com.luoziyang.demo.Service.ActivemqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoziyang
 * @create 2023-07-04
 */
@RestController
@RequestMapping("/active")
public class ActivemqController {
    @Autowired
    private ActivemqService activemqService;
    @PostMapping
    int recieve(String id){
        activemqService.sendMessage(id);
        return 200;
    }
    @RequestMapping
    void receive(){
        activemqService.doMessage();
    }


}
