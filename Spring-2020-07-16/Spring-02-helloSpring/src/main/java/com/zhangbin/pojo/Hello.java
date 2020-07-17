package com.zhangbin.pojo;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/17-10:20
 */
public class Hello {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
