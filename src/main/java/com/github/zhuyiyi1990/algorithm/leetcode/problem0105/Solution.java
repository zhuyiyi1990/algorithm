package com.github.zhuyiyi1990.algorithm.leetcode.problem0105;

import java.util.HashMap;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return buildTree1(preorder, inorder);
        return buildTree2(preorder, inorder);
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode f(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return head;
        }
        int find = l2;
        while (inorder[find] != preorder[l1]) {
            find++;
        }
        head.left = f(preorder, l1 + 1, l1 + find - l2, inorder, l2, find - 1);
        head.right = f(preorder, l1 + find - l2 + 1, r1, inorder, find + 1, r2);
        return head;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }
        return g(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueIndexMap);
    }

    private TreeNode g(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2, HashMap<Integer, Integer> valueIndexMap) {
        if (l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return head;
        }
        int find = valueIndexMap.get(preorder[l1]);
        head.left = g(preorder, l1 + 1, l1 + find - l2, inorder, l2, find - 1, valueIndexMap);
        head.right = g(preorder, l1 + find - l2 + 1, r1, inorder, find + 1, r2, valueIndexMap);
        return head;
    }

}