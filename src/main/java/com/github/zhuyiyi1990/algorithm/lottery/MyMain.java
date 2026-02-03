package com.github.zhuyiyi1990.algorithm.lottery;

import java.security.SecureRandom;

public class MyMain {

    public static void main(String[] args) {
        final int COUNT = 5;
        for (int i = 0; i < COUNT; i++) {
            try {
                Thread.sleep(new SecureRandom().nextInt(4001) + 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String ticket = BestDoubleColorBall.generateBestTicket();
            System.out.println(ticket);
        }
    }

}