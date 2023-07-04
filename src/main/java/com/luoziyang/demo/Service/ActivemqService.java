package com.luoziyang.demo.Service;

/**
 * @author luoziyang
 * @create 2023-07-03
 */
public interface ActivemqService {
    public void sendMessage(String id);
    public String doMessage();
}
