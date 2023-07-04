package com.luoziyang.demo.Utill;

import com.zhenzi.sms.ZhenziSmsClient;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luoziyang
 * @create 2023-07-04
 */
public class SendUtill {
    public static void send(String phoneNumber, String code) {
        // 使用自己的 AppId 和 AppSecret
        ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "113293", "4686afa8-6c98-4503-bfc2-bfb18bff64ea");
        Map<String, Object> params = new HashMap<>();
        params.put("113293", phoneNumber);
        // 修改为自己的templateId
        params.put("templateId", "113293");
        String[] templateParams = new String[2];
        templateParams[0] = code;
        templateParams[1]="1";
        params.put("templateParams", templateParams);
        try {
            String result = client.send(params);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
