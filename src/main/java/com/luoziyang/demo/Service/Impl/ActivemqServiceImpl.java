package com.luoziyang.demo.Service.Impl;

import com.luoziyang.demo.Service.ActivemqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @author luoziyang
 * @create 2023-07-03
 */
@Service
public class ActivemqServiceImpl implements ActivemqService {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Override
    public void sendMessage(String id) {
        System.out.println("发送短信:"+id);
        jmsMessagingTemplate.convertAndSend(id);

    }

    @Override
    public String doMessage() {
        String s = jmsMessagingTemplate.receiveAndConvert(String.class);
        System.out.println("宋翔宇傻蛋");
        return s;
    }
}
