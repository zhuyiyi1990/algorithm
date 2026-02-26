package com.github.zhuyiyi1990.algorithm.stock;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StockMain {

    public static void main(String[] args) {
        final BigDecimal costPrice = new BigDecimal("6.4280");
        final BigDecimal oneHundred = new BigDecimal("100");
        for (int i = 1; i <= 10; i++) {
            BigDecimal variation = costPrice.multiply(new BigDecimal(i)).divide(oneHundred, 4, RoundingMode.HALF_UP);
            BigDecimal posValue = costPrice.add(variation);
            BigDecimal negValue = costPrice.subtract(variation);
            System.out.format("%d%%   %.4f    -%d%%   %.4f%n", i, posValue, i, negValue);
        }
    }

}