package com.luoziyang.demo.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.Max;


/**
 * @author luoziyang
 * @create 2023-06-21
 */
@Data
@ToString
@Component
@Valid
public class book {
    @Max(value = 100,message = "最大不能超过100")
    private Integer id;
    private String type;
    private String name;
    private String description;
}
