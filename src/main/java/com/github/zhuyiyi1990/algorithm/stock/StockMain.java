package com.github.zhuyiyi1990.algorithm.stock;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StockMain {

    public static void main(String[] args) {
        final BigDecimal costPrice = new BigDecimal("100.0000");
        final BigDecimal oneHundred = new BigDecimal("100");
        for (BigDecimal i = new BigDecimal("0.5"); i.compareTo(BigDecimal.TEN) <= 0; i = i.add(new BigDecimal("0.5"))) {
            BigDecimal variation = costPrice.multiply(i).divide(oneHundred, 4, RoundingMode.HALF_UP);
            BigDecimal posValue = costPrice.add(variation);
            BigDecimal negValue = costPrice.subtract(variation);
            System.out.format("%.1f%%   %.4f    -%.1f%%   %.4f%n", i, posValue, i, negValue);
        }
    }

}