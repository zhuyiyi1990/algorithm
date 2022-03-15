package com.github.zhuyiyi1990.algorithm.leetcode.problem0038;

//https://leetcode.com/problems/count-and-say/
public class Solution {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String sayString = countAndSay(n - 1);
        char[] say = sayString.toCharArray();
        StringBuilder sb = new StringBuilder();
        char last = say[0];
        int count = 1;
        for (int i = 1; i < say.length; i++) {
            if (say[i] != last) {
                sb.append(count).append(last);
                count = 0;
            }
            count++;
            last = say[i];
        }
        sb.append(count).append(last);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(4));
    }

}