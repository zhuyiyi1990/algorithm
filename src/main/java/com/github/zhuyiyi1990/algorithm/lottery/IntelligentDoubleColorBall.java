package com.github.zhuyiyi1990.algorithm.lottery;

import java.util.*;

public class IntelligentDoubleColorBall {

    /**
     * 智能生成双色球号码 - 减少不自然的连号
     *
     * @param maxConsecutive 最大允许的连续号码数，默认2
     * @return 生成的号码
     */
    public static String generateIntelligentTicket(int maxConsecutive) {
        Random random = new Random(System.nanoTime());
        List<Integer> redBalls = new ArrayList<>();
        int attempts = 0;

        // 尝试生成符合条件的号码
        while (redBalls.size() < 6 && attempts < 1000) {
            int ball = random.nextInt(33) + 1;

            if (!redBalls.contains(ball)) {
                // 检查连续号码限制
                if (checkConsecutiveLimit(redBalls, ball, maxConsecutive)) {
                    redBalls.add(ball);
                }
            }

            attempts++;
        }

        // 如果生成失败，回退到普通算法
        if (redBalls.size() < 6) {
            return generateNormalTicket();
        }

        // 排序
        Collections.sort(redBalls);

        // 生成蓝球
        int blueBall = random.nextInt(16) + 1;

        return formatTicket(redBalls, blueBall);
    }

    /**
     * 检查是否满足连续号码限制
     */
    private static boolean checkConsecutiveLimit(List<Integer> existing, int newBall, int maxConsecutive) {
        if (existing.isEmpty()) {
            return true;
        }

        // 统计连续号码
        List<Integer> temp = new ArrayList<>(existing);
        temp.add(newBall);
        Collections.sort(temp);

        int consecutiveCount = 1;
        int maxConsecutiveFound = 1;

        for (int i = 1; i < temp.size(); i++) {
            if (temp.get(i) == temp.get(i - 1) + 1) {
                consecutiveCount++;
                maxConsecutiveFound = Math.max(maxConsecutiveFound, consecutiveCount);
            } else {
                consecutiveCount = 1;
            }
        }

        return maxConsecutiveFound <= maxConsecutive;
    }

    /**
     * 生成更接近真实分布的号码
     */
    public static String generateRealisticTicket() {
        Random random = new Random(System.nanoTime());
        List<Integer> redBalls = new ArrayList<>();

        // 策略：分区域选择号码
        // 将1-33分为3个区域
        int[] areaCounts = {2, 2, 2}; // 每个区域选2个号码
        String[] areas = {"01-11", "12-22", "23-33"};

        for (int area = 0; area < 3; area++) {
            int count = 0;
            while (count < areaCounts[area]) {
                int min = area * 11 + 1;
                int max = min + 10;
                int ball = random.nextInt(max - min + 1) + min;

                if (!redBalls.contains(ball)) {
                    redBalls.add(ball);
                    count++;
                }
            }
        }

        // 排序
        Collections.sort(redBalls);

        // 生成蓝球
        int blueBall = random.nextInt(16) + 1;

        return formatTicket(redBalls, blueBall);
    }

    /**
     * 生成具有统计特性的号码
     */
    public static String generateStatisticalTicket() {
        Random random = new Random(System.nanoTime());
        Set<Integer> redBalls = new HashSet<>();

        // 使用概率权重：中间号码概率稍高
        while (redBalls.size() < 6) {
            double r = random.nextDouble();
            int ball;

            if (r < 0.2) {           // 20%概率选小号(1-11)
                ball = random.nextInt(11) + 1;
            } else if (r < 0.5) {    // 30%概率选中号(12-22)
                ball = random.nextInt(11) + 12;
            } else {                  // 50%概率选大号(23-33)
                ball = random.nextInt(11) + 23;
            }

            if (!redBalls.contains(ball)) {
                redBalls.add(ball);
            }
        }

        // 转换为列表并排序
        List<Integer> sortedBalls = new ArrayList<>(redBalls);
        Collections.sort(sortedBalls);

        // 检查连号，如有过多连号则调整
        sortedBalls = adjustConsecutiveNumbers(sortedBalls);

        // 生成蓝球
        int blueBall = random.nextInt(16) + 1;

        return formatTicket(sortedBalls, blueBall);
    }

    /**
     * 调整连号数量
     */
    private static List<Integer> adjustConsecutiveNumbers(List<Integer> numbers) {
        List<Integer> adjusted = new ArrayList<>(numbers);

        // 统计连续号码段
        int consecutiveCount = countConsecutive(adjusted);

        // 如果连续号码太多，进行替换
        if (consecutiveCount > 2) {
            Random random = new Random();
            // 找到连续段并替换其中一个
            for (int i = 1; i < adjusted.size(); i++) {
                if (adjusted.get(i) == adjusted.get(i - 1) + 1) {
                    // 尝试替换
                    int newBall;
                    do {
                        newBall = random.nextInt(33) + 1;
                    } while (adjusted.contains(newBall) ||
                            (newBall == adjusted.get(i) - 1) ||
                            (newBall == adjusted.get(i) + 1));

                    adjusted.set(i, newBall);
                    break;
                }
            }
            Collections.sort(adjusted);
        }

        return adjusted;
    }

    /**
     * 统计连续号码数量
     */
    private static int countConsecutive(List<Integer> numbers) {
        int count = 0;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) == numbers.get(i - 1) + 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * 普通生成方法（对比用）
     */
    private static String generateNormalTicket() {
        Random random = new Random();
        Set<Integer> redBalls = new HashSet<>();

        while (redBalls.size() < 6) {
            redBalls.add(random.nextInt(33) + 1);
        }

        List<Integer> sortedBalls = new ArrayList<>(redBalls);
        Collections.sort(sortedBalls);

        int blueBall = random.nextInt(16) + 1;

        return formatTicket(sortedBalls, blueBall);
    }

    private static String formatTicket(List<Integer> redBalls, int blueBall) {
        StringBuilder sb = new StringBuilder("红球：");
        for (int i = 0; i < redBalls.size(); i++) {
            sb.append(String.format("%02d", redBalls.get(i)));
            if (i < redBalls.size() - 1) {
                sb.append(" ");
            }
        }
        sb.append(" 蓝球：").append(String.format("%02d", blueBall));
        return sb.toString();
    }

    // 测试对比
    public static void main(String[] args) {
        System.out.println("=== 不同算法连号情况对比 ===\n");

        int normalConsecutive = 0;
        int intelligentConsecutive = 0;
        int realisticConsecutive = 0;
        int statisticalConsecutive = 0;

        int trials = 1000;

        for (int i = 0; i < trials; i++) {
            // 普通算法
            String normal = generateNormalTicket();
            normalConsecutive += countConsecutive(extractNumbers(normal));

            // 智能算法
            String intelligent = generateIntelligentTicket(2);
            intelligentConsecutive += countConsecutive(extractNumbers(intelligent));

            // 真实分布算法
            String realistic = generateRealisticTicket();
            realisticConsecutive += countConsecutive(extractNumbers(realistic));

            // 统计算法
            String statistical = generateStatisticalTicket();
            statisticalConsecutive += countConsecutive(extractNumbers(statistical));
        }

        System.out.println("测试" + trials + "次后的平均连号数量：");
        System.out.println("普通算法: " + (normalConsecutive * 1.0 / trials));
        System.out.println("智能算法: " + (intelligentConsecutive * 1.0 / trials));
        System.out.println("真实分布: " + (realisticConsecutive * 1.0 / trials));
        System.out.println("统计算法: " + (statisticalConsecutive * 1.0 / trials));

        // 展示示例
        System.out.println("\n=== 示例号码 ===");
        System.out.println("普通算法: " + generateNormalTicket());
        System.out.println("智能算法: " + generateIntelligentTicket(2));
        System.out.println("真实分布: " + generateRealisticTicket());
        System.out.println("统计算法: " + generateStatisticalTicket());
    }

    private static List<Integer> extractNumbers(String ticket) {
        List<Integer> numbers = new ArrayList<>();
        String[] parts = ticket.split(" ");
        for (String part : parts) {
            if (part.matches("\\d+")) {
                numbers.add(Integer.parseInt(part));
            }
        }
        return numbers;
    }

}