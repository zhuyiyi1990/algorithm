package com.github.zhuyiyi1990.algorithm.lottery;

public class LotteryMain {

    public static void main(String[] args) {
        final int COUNT = 1;
        for (int i = 0; i < COUNT; i++) {
            String ticket = DoubleColorBall.generateTicket();
            System.out.println(ticket);
        }
    }

}