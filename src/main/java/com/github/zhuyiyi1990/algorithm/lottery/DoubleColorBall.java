package com.github.zhuyiyi1990.algorithm.lottery;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DoubleColorBall {

    /**
     * 生成一注双色球号码
     *
     * @return 返回字符串格式的双色球号码，如：红球：01 02 03 04 05 06 蓝球：07
     */
    public static String generateTicket() {
        Random random = new Random();
        Set<Integer> redBalls = new HashSet<>();

        // 生成6个不重复的红球（1-33）
        while (redBalls.size() < 6) {
            redBalls.add(random.nextInt(33) + 1);
        }

        // 转换为数组并排序
        int[] redArray = redBalls.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        Arrays.sort(redArray);

        // 生成蓝球（1-16）
        int blueBall = random.nextInt(16) + 1;

        // 格式化为字符串
        return formatTicket(redArray, blueBall);
    }

    /**
     * 生成多注双色球号码
     *
     * @param count 注数
     * @return 返回多注号码的字符串数组
     */
    public static String[] generateMultipleTickets(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("注数必须大于0");
        }

        String[] tickets = new String[count];
        for (int i = 0; i < count; i++) {
            tickets[i] = generateTicket();
        }
        return tickets;
    }

    /**
     * 格式化号码输出
     */
    private static String formatTicket(int[] redBalls, int blueBall) {
        StringBuilder sb = new StringBuilder("红球：");

        // 格式化红球，补零显示
        for (int i = 0; i < redBalls.length; i++) {
            sb.append(String.format("%02d", redBalls[i]));
            if (i < redBalls.length - 1) {
                sb.append(" ");
            }
        }

        sb.append(" 蓝球：").append(String.format("%02d", blueBall));
        return sb.toString();
    }

    /**
     * 返回数组形式的结果
     *
     * @return 返回二维数组，第一维是红球，第二维是蓝球
     */
    public static int[][] generateTicketAsArray() {
        Random random = new Random();
        Set<Integer> redBalls = new HashSet<>();

        while (redBalls.size() < 6) {
            redBalls.add(random.nextInt(33) + 1);
        }

        int[] redArray = redBalls.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        Arrays.sort(redArray);

        int blueBall = random.nextInt(16) + 1;

        return new int[][]{redArray, {blueBall}};
    }

    /**
     * 增强版：确保生成公平随机的号码（使用SecureRandom）
     */
    public static String generateSecureTicket() {
        Random random = new Random(System.nanoTime());
        Set<Integer> redBalls = new HashSet<>();

        while (redBalls.size() < 6) {
            redBalls.add(random.nextInt(33) + 1);
        }

        int[] redArray = redBalls.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        Arrays.sort(redArray);

        int blueBall = random.nextInt(16) + 1;

        return formatTicket(redArray, blueBall);
    }

    public static String generateCryptoTicket() {
        SecureRandom secureRandom = new SecureRandom();
        Set<Integer> redBalls = new HashSet<>();

        // 生成6个不重复的红球
        while (redBalls.size() < 6) {
            redBalls.add(secureRandom.nextInt(33) + 1);
        }

        int[] redArray = redBalls.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        Arrays.sort(redArray);

        int blueBall = secureRandom.nextInt(16) + 1;

        return formatTicket(redArray, blueBall);
    }

    // 测试主方法
    public static void main(String[] args) {
        System.out.println("=== 双色球随机生成器 ===");
        System.out.println("\n生成1注号码：");
        System.out.println(generateTicket());

        System.out.println("\n生成5注号码：");
        String[] tickets = generateMultipleTickets(5);
        for (int i = 0; i < tickets.length; i++) {
            System.out.println("第" + (i + 1) + "注：" + tickets[i]);
        }

        System.out.println("\n生成数组形式的号码：");
        int[][] ticketArray = generateTicketAsArray();
        System.out.print("红球：[");
        for (int i = 0; i < ticketArray[0].length; i++) {
            System.out.print(String.format("%02d", ticketArray[0][i]));
            if (i < ticketArray[0].length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
        System.out.println("蓝球：" + String.format("%02d", ticketArray[1][0]));
    }

}