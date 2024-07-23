package com.github.zhuyiyi1990.algorithm.other.kmerge;

import java.util.Arrays;

/*
 * https://www.jianshu.com/p/898cb2456d7a
 * 多路平衡归并算法（基于败者树归并有序段）
 */
public class KMerge {

    private static class ExNode {
        int key;
    }

    private final int k;

    private final int maxKey;

    private final int minKey;

    private final int[] loserTree;

    private final ExNode[] b;

    private final int[][] a;

    int[] t;

    public KMerge(int k, int maxKey, int minKey, int[][] a) {
        this.k = k;
        this.maxKey = maxKey;
        this.minKey = minKey;
        // 表示非终端结点，由于是完全二叉树，所以可以使用一维数组来表示
        loserTree = new int[k];
        // 表示败者树的叶子结点
        b = new ExNode[k + 1];
        for (int i = 0; i < b.length; i++) {
            b[i] = new ExNode();
        }
        this.a = a;
        t = new int[k];
    }

    // 沿从叶子结点b[s]到根结点ls[0]的路径调整败者树
    private void adjust(int[] ls, int s) {
        int t = (s + k) / 2;
        while (t > 0) {
            // 判断每一个叶子结点同其双亲结点中记录的败者的值相比较，调整败者的值，其中 s 一直表示的都是胜者
            if (b[s].key > b[ls[t]].key) {
                int swap = s;
                s = ls[t];
                ls[t] = swap;
            }
            t = t / 2;
        }
        // 最终将胜者的值赋给 ls[0]
        ls[0] = s;
    }

    //创建败者树
    private void createLoserTree(int[] ls) {
        b[k].key = minKey;
        // 设置ls数组中败者的初始值
        for (int i = 0; i < k; i++) {
            ls[i] = k;
        }
        // 对于每一个叶子结点，调整败者树中非终端结点中记录败者的值
        for (int i = k - 1; i >= 0; i--) {
            adjust(ls, i);
        }
    }

    //模拟从外存向内存读入初始归并段中的每一小部分
    private void input(int i) {
        if (t[i] < 3) {
            b[i].key = a[i][t[i]];
            t[i]++;
        } else {
            b[i].key = maxKey;
        }
    }

    // 败者树的建立及内部归并
    private void kMerge() {
        // 模拟从外存中的5个初始归并段中向内存调取数据
        for (int i = 0; i < k; i++) {
            input(i);
        }
        // 创建败者树
        createLoserTree(loserTree);
        // 最终的胜者存储在 is[0]中，当其值为 MAXKEY时，证明5个临时文件归并结束
        while (b[loserTree[0]].key != maxKey) {
            // 输出过程模拟向外存写的操作
            System.out.printf("%d ", b[loserTree[0]].key);
            // 继续读入后续的记录
            input(loserTree[0]);
            // 根据新读入的记录的关键字的值，重新调整败者树，找出最终的胜者
            adjust(loserTree, loserTree[0]);
        }
    }

    public static void main(String[] args) {
        int[][] a = {{10, 15, 16}, {9, 18, 20}, {20, 22, 40}, {6, 15, 25}, {12, 37, 48}};
        KMerge kMerge = new KMerge(5, 10000, -1, a);
        kMerge.kMerge();
        System.out.println();
        int[] test = {10, 15, 16, 9, 18, 20, 20, 22, 40, 6, 15, 25, 12, 37, 48};
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));
    }

}