package com.zhangbin.pojo;

import lombok.Data;

import java.util.*;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/19-23:17
 */

@Data
public class Student {
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbys;
    private Map<String,String> card;
    private Set<String> games;
    private String wife;
    private Properties info;

}