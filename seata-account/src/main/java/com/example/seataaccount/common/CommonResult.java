package com.example.seataaccount.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author i
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    private Integer code;
    private String  message;
    private T       data;

    public CommonResult(Integer code, String message)
    {
        this(code,message,null);
    }
}

