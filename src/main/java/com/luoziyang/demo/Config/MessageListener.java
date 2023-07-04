package com.luoziyang.demo.Config;

import com.luoziyang.demo.Utill.SendUtill;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author luoziyang
 * @create 2023-07-04
 */
@Component
public class MessageListener {
    @JmsListener(destination = "luoziyang")
    public void receive(String id){
        //SendUtill.send("18827686213",id);
        System.out.println("已完成短信发送业务，code："+id);
    }
}
