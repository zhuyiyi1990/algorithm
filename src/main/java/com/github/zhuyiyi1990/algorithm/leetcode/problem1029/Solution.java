package com.github.zhuyiyi1990.algorithm.leetcode.problem1029;

//https://leetcode.com/problems/two-city-scheduling/
public class Solution {

    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (costs[j][0] - costs[j][1] < costs[j - 1][0] - costs[j - 1][1]) {
                    int[] t = costs[j];
                    costs[j] = costs[j - 1];
                    costs[j - 1] = t;
                } else {
                    break;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                sum += costs[i][0];
            } else {
                sum += costs[i][1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        System.out.println(new Solution().twoCitySchedCost(costs));
    }

}