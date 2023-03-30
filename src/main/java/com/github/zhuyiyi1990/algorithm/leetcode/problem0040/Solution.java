package com.github.zhuyiyi1990.algorithm.leetcode.problem0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    List<long[]> freq = new ArrayList<>();
    List<List<Long>> ans = new ArrayList<>();
    List<Long> sequence = new ArrayList<>();

    public List<List<Long>> combinationSum2(long[] candidates, long target) {
        Arrays.sort(candidates);
        for (long num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new long[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0, target);
        return ans;
    }

    public void dfs(int pos, long rest) {
        if (rest == 0) {
            System.out.println(new ArrayList<>(sequence));
            ans.add(new ArrayList<>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        dfs(pos + 1, rest);

        long most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (long i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (long i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long[] candidates = {
                51284722,
                431531555,
                104944445,
                209888889,
                144666666,
                209888889,
                96444445,
                52472222,
                1049444445,
                289333334,
                157416667,
                114819444,
                157416667,
                348425000,
                104944445,
                90958333,
                28658333,
                52472222,
                482222222,
                52472222,
                224895944,
                102569444,
                209888889,
                52472222,
                157416667,
                227395833,
                205138889,
                539414445,
                934005555,
                970946000,
                104944445,
                282065972,
                209888889,
                144666666,
                144666666,
                209888889,
                520800000,
                104944445,
                350619389,
                96444445,
                96444445,
                215765778,
                283350000,
                104944445,
                192888889,
                94450000,
                52472222,
                717986111,
                289333334,
                314833333,
                104944445,
                104944445,
                192888889,
                96444445,
                104944445,
                27287500,
                96444445,
                818566667,
                167911111,
                75551289,
                32177778,
                134337600
        };
        long target = 5112456250L;
        List<List<Long>> lists = solution.combinationSum2(candidates, target);
        System.out.println("###############");
        System.out.println(lists);
    }

}