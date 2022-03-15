package com.github.zhuyiyi1990.algorithm.leetcode.problem0345;

//https://leetcode.com/problems/reverse-vowels-of-a-string/
public class Solution {

    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int i = 0, j = str.length - 1;
        while (i < j) {
            while (i < str.length && str[i] != 'a' && str[i] != 'e' && str[i] != 'i' && str[i] != 'o' && str[i] != 'u' && str[i] != 'A' && str[i] != 'E' && str[i] != 'I' && str[i] != 'O' && str[i] != 'U') {
                i++;
            }
            while (j >= 0 && str[j] != 'a' && str[j] != 'e' && str[j] != 'i' && str[j] != 'o' && str[j] != 'u' && str[j] != 'A' && str[j] != 'E' && str[j] != 'I' && str[j] != 'O' && str[j] != 'U') {
                j--;
            }
            if (i < str.length && j >= 0 && i < j) {
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
            }
            i++;
            j--;
        }
        return new String(str);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
    }

}