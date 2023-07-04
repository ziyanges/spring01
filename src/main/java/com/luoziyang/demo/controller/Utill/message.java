package com.luoziyang.demo.controller.Utill;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

/**
 * @author luoziyang
 * @create 2023-06-25
 */
@Data
public class message {
    private boolean flag;
    private Object data;
    public message(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
