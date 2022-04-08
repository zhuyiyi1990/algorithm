package com.github.zhuyiyi1990.algorithm.leetcode.problem0703;

import java.util.Arrays;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KthLargest {

    private int[] kNums;

    public KthLargest(int k, int[] nums) {
        kNums = new int[k];
        Arrays.sort(nums);
        Arrays.fill(kNums, -10001);
        for (int i = nums.length - 1; i >= 0 && nums.length - 1 - i >= 0 && nums.length - 1 - i < k; i--) {
            kNums[nums.length - 1 - i] = nums[i];
        }
        System.out.println(Arrays.toString(kNums));
    }

    public int add(int val) {
        int i;
        for (i = kNums.length - 1; i >= 0 && kNums[i] < val; i--) {
            if (i + 1 < kNums.length) {
                kNums[i + 1] = kNums[i];
            }
        }
        if (i + 1 < kNums.length) {
            kNums[i + 1] = val;
        }
        System.out.println(Arrays.toString(kNums));
        return kNums[kNums.length - 1];
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargest obj = new KthLargest(k, nums);
        System.out.println(obj.add(3) + " ");
        System.out.println(obj.add(5) + " ");
        System.out.println(obj.add(10) + " ");
        System.out.println(obj.add(9) + " ");
        System.out.println(obj.add(4));
    }

}