package com.linjhon.myspringboot.leetcode.dp;

/**
 * 0-1 背包问题：给定 n 种物品和一个容量为 C 的背包，物品 i 的重量是 wi，其价值为 vi 。
 * <p>
 * 问：应该如何选择装入背包的物品，使得装入背包中的物品的总价值最大？
 */
public class OneZeroBag {
    public static void main(String[] args) {
        int count = 5;
        int capacity = 8;
        int[] weight = {1, 2, 3, 4, 5};
        int[] value = {3, 4, 2, 5, 6};
        int[][] maxRes = new int[6][9];

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j <= 8; j++) {
                if (j < weight[i]) {
                    maxRes[i][j] = maxRes[i - 1][j];
                } else {
                    maxRes[i][j] = Math.max(maxRes[i - 1][j - weight[i]] + value[i],
                            maxRes[i - 1][j]);
                }
            }
        }
        System.out.println(maxRes[4][8]);

    }

}
