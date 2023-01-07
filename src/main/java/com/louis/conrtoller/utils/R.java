package com.louis.conrtoller.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

//设计表现层返回结果的模型类，用于后端与前端进行数据格式统一，也称为前后端数据协议
@Data
public class R {
    private boolean flag;
    private Object data;
    private String message;
    public R(){

    }

    public R(boolean flag){
        this.flag = flag;
    }

    public R(boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }
    public R(boolean flag ,String message){
        this.flag = flag;
        this.message=message;
    }
    public R(String message){
        this.flag = false;
        this.message=message;
    }
}
