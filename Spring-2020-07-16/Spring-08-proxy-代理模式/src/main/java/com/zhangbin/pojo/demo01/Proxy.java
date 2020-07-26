package com.zhangbin.pojo.demo01;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/26-11:26
 */
//代理，中介
public class Proxy implements Rent{

    //房东
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    //实现租房接口
    public void rent() {
        //中介带你看房
        seeHouse();
        //不用面向房东直接看房
        host.rent();
        //中介收费
        fare();
        //中介签合同
        hetong();

    }

    //看房
    public void seeHouse(){
        System.out.println("中介带你看房");
    }

    //收中介费
    public void fare(){
        System.out.println("收中介费");
    }

    //签合同
    public void hetong(){
        System.out.println("签租赁合同");
    }
}
