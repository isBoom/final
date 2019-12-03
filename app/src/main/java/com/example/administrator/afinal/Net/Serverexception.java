package com.example.administrator.afinal.Net;

/**
 * Created by skyti on 2019/11/26.
 */

public class Serverexception extends Exception {
    private int code;
    private String msg;

    public Serverexception(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
