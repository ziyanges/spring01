package com.luoziyang.demo.Utill;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author luoziyang
 * @create 2023-06-27
 */
@Component
public class CodeUtill {
    private String [] patch = {"000000","00000","0000","000","00","0",""};

    public String generator(String tele){
        int hash = tele.hashCode();
        int encryption = 20206666;
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000;
        code = code < 0 ? -code : code;
        String codeStr = code + "";
        int len = codeStr.length();
        return patch[len] + codeStr;
    }
    public String getSome(){
        return "good";
    }

    @Cacheable(value = "ssmCode",key="#tele")
    public String get(String tele){
        return null;
    }
}
