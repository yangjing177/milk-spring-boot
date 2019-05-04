package com.neu.yang.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderNumber extends Thread{

    private static long orderNum = 0l;
    private static String date ;

//    public static void main(String[] args) throws InterruptedException {
////        System.out.println(OrderNumber.getOrderNo());
//        for (int i = 0; i < 10000; i++) {
//            System.out.println(OrderNumber.getOrderNo());
//            Thread.sleep(1000);
//        }
//    }

    /**
     * 生成订单编号
     * @return
     */
    public String getOrderNo() {
        String str = new SimpleDateFormat("yyMMddHHmmSS").format(new Date());
        if(date==null||!date.equals(str)){
            date = str;
            orderNum  = 0l;
        }
        orderNum ++;
        long orderNo = Long.parseLong((date)) * 10000;
        orderNo += orderNum;;
        return orderNo+"";
    }
}

