package com.zhangbin.pojo.demo03;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/26-11:23
 */

//房东
public class Host  implements Rent {

    //重写租房的接口
    public void rent() {
        System.out.println("房东要出租房子！！！");
    }
}
