package com.luoziyang.demo.Service;

import com.luoziyang.demo.domain.SsmCode;

/**
 * @author luoziyang
 * @create 2023-06-27
 */
public interface SsmCodeService {
    String sendCodeToSMS(String tele);
    boolean checkCode(SsmCode ssmCode);

}
