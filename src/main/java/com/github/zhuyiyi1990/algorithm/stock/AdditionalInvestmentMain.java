package com.github.zhuyiyi1990.algorithm.stock;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AdditionalInvestmentMain {

    /**
     * 计算需要加仓的金额，使持股成本降至当前股价的101%以内
     *
     * @param costPrice    原成本价（元/股）
     * @param shares       原持有股数（股）
     * @param currentPrice 当前股价（元/股）
     * @return 需要加仓的最低金额（元）
     */
    public static double calculateAdditionalInvestment(double costPrice, int shares, double currentPrice) {
        // 参数校验
        if (costPrice <= 0 || shares <= 0 || currentPrice <= 0) {
            throw new IllegalArgumentException("价格和股数必须为正数");
        }

        if (currentPrice >= costPrice) {
            // 当前股价不低于成本价，无需加仓
            return 0.0;
        }

        // 目标成本价 = 当前股价 * 101%
        double targetCost = currentPrice * 1.01;

        // 当前总市值 = 原成本价 * 原股数
        double currentTotalValue = costPrice * shares;

        // 设需要加仓x元，加仓后总市值 = 当前总市值 + x
        // 加仓后总股数 = 原股数 + (x / 当前股价)
        // 加仓后平均成本 = (当前总市值 + x) / (原股数 + x/当前股价)
        // 要求：加仓后平均成本 <= targetCost

        // 推导公式：
        // (currentTotalValue + x) / (shares + x/currentPrice) <= targetCost
        // currentTotalValue + x <= targetCost * (shares + x/currentPrice)
        // currentTotalValue + x <= targetCost * shares + (targetCost/currentPrice) * x
        // x - (targetCost/currentPrice) * x <= targetCost * shares - currentTotalValue
        // x * (1 - targetCost/currentPrice) <= targetCost * shares - currentTotalValue

        // 注意：由于targetCost > currentPrice，所以 (1 - targetCost/currentPrice) < 0
        // 因此不等号方向会改变，我们需要重新推导

        // 正确推导：
        // (currentTotalValue + x) / (shares + x/currentPrice) <= targetCost
        // 两边乘以正数 (shares + x/currentPrice)：
        // currentTotalValue + x <= targetCost * shares + (targetCost/currentPrice) * x
        // 移项：
        // currentTotalValue + x - (targetCost/currentPrice) * x <= targetCost * shares
        // currentTotalValue + x * (1 - targetCost/currentPrice) <= targetCost * shares
        // x * (1 - targetCost/currentPrice) <= targetCost * shares - currentTotalValue

        // 因为 targetCost > currentPrice，所以 1 - targetCost/currentPrice < 0
        // 两边除以负数，不等号反向：
        // x >= (targetCost * shares - currentTotalValue) / (1 - targetCost/currentPrice)

        double numerator = targetCost * shares - currentTotalValue;
        double denominator = 1 - (targetCost / currentPrice);

        // 计算所需加仓金额
        double requiredAmount = numerator / denominator;

        // 确保结果为正数
        return Math.max(0, requiredAmount);
    }

    /**
     * 使用BigDecimal的高精度版本，避免浮点数精度问题
     */
    public static BigDecimal calculateAdditionalInvestmentPrecise(
            BigDecimal costPrice, BigDecimal shares, BigDecimal currentPrice) {

        // 参数校验
        if (costPrice.compareTo(BigDecimal.ZERO) <= 0 ||
                shares.compareTo(BigDecimal.ZERO) <= 0 ||
                currentPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("价格和股数必须为正数");
        }

        if (currentPrice.compareTo(costPrice) >= 0) {
            return BigDecimal.ZERO;
        }

        // 目标成本价 = 当前股价 * 101%
        BigDecimal targetCost = currentPrice.multiply(new BigDecimal("1.01"));

        // 当前总市值 = 原成本价 * 原股数
        BigDecimal currentTotalValue = costPrice.multiply(shares);

        // 计算所需加仓金额
        // x = (targetCost * shares - currentTotalValue) / (1 - targetCost/currentPrice)

        BigDecimal numerator = targetCost.multiply(shares).subtract(currentTotalValue);
        BigDecimal denominator = BigDecimal.ONE.subtract(
                targetCost.divide(currentPrice, 10, RoundingMode.HALF_UP));

        BigDecimal requiredAmount = numerator.divide(denominator, 2, RoundingMode.CEILING);

        return requiredAmount.max(BigDecimal.ZERO);
    }

    // 使用示例
    public static void main(String[] args) {
        // 示例：成本价10元，持有1000股，当前股价8元
        double amount = calculateAdditionalInvestment(10.0, 1000, 8.0);
        System.out.printf("需要加仓: %.2f元%n", amount);

        // 使用高精度版本
        BigDecimal preciseAmount = calculateAdditionalInvestmentPrecise(
                new BigDecimal("10"), new BigDecimal("1000"), new BigDecimal("8"));
        System.out.println("需要加仓(精确): " + preciseAmount + "元");
    }

}