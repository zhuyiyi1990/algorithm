package com.github.zhuyiyi1990.algorithm.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BestDoubleColorBall {

    /**
     * 推荐的最佳生成方法
     * - 适当的连号概率
     * - 区域分布合理
     * - 号码分布均匀
     */
    public static String generateBestTicket() {
        Random random = new Random(System.nanoTime());
        List<Integer> redBalls = new ArrayList<>();

        // 策略1：确保至少来自3个不同的十位区间
        int[] decadeCount = new int[4]; // 0-9, 10-19, 20-29, 30-33

        // 策略2：限制连号数量
        while (redBalls.size() < 6) {
            int ball = generateWeightedNumber(random);

            if (!redBalls.contains(ball)) {
                // 检查十位区间分布
                int decade = Math.min(ball / 10, 3);
                if (decadeCount[decade] >= 3) {
                    continue; // 该区间已满
                }

                // 检查连号
                List<Integer> temp = new ArrayList<>(redBalls);
                temp.add(ball);
                Collections.sort(temp);

                if (countConsecutive(temp) <= 2) { // 最多允许2对连号
                    redBalls.add(ball);
                    decadeCount[decade]++;
                }
            }
        }

        Collections.sort(redBalls);
        int blueBall = random.nextInt(16) + 1;

        return format(redBalls, blueBall);
    }

    /**
     * 加权随机：中间号码概率稍高
     */
    private static int generateWeightedNumber(Random random) {
        double r = random.nextDouble();
        if (r < 0.15) return random.nextInt(11) + 1;      // 1-11
        else if (r < 0.65) return random.nextInt(11) + 12; // 12-22
        else return random.nextInt(11) + 23;              // 23-33
    }

    private static int countConsecutive(List<Integer> numbers) {
        int count = 0;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) == numbers.get(i - 1) + 1) count++;
        }
        return count;
    }

    private static String format(List<Integer> redBalls, int blueBall) {
        StringBuilder sb = new StringBuilder();
        for (int ball : redBalls) {
            sb.append(String.format("%02d ", ball));
        }
        return sb.toString().trim() + " + " + String.format("%02d", blueBall);
    }

}