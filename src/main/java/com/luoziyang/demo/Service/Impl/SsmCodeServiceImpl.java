package com.luoziyang.demo.Service.Impl;

import com.luoziyang.demo.Service.SsmCodeService;
import com.luoziyang.demo.Utill.CodeUtill;
import com.luoziyang.demo.domain.SsmCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;


/**
 * @author luoziyang
 * @create 2023-06-27
 */
@Service
public class SsmCodeServiceImpl implements SsmCodeService {
    @Autowired
    private CodeUtill codeUtill;
    @Override
    @CachePut(value ="ssmCode",key = "#tel")
    public String sendCodeToSMS(String tel) {
        String generator = codeUtill.generator(tel);
        return generator;
    }
    @Override
    public boolean checkCode(SsmCode ssmCode) {
        String Code = ssmCode.getCode();
        String Cachecode=codeUtill.get(ssmCode.getTel());
        return   Code.equals(Cachecode);
    }
}
