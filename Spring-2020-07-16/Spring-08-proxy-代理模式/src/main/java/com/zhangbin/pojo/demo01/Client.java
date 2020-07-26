package com.zhangbin.pojo.demo01;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/26-11:25
 */

//租房流程
public class Client {
    public static void main(String[] args) {
        //房东
        Host host = new Host();
        //代理中介，找中介不用面对房东还可以有一些附属操作，如签合同，带你看房等
        Proxy proxy = new Proxy(host);
        //不用面对房东租房
        proxy.rent();
    }
}
