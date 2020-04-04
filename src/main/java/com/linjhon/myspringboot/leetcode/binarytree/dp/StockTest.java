package com.linjhon.myspringboot.leetcode.binarytree.dp;

public class StockTest {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("max value:"+maxValue(grid));
    }
    public static int maxValue(int[][] grid) {
        int row = grid.length;
        int clos = grid[0].length;
        int[][] max = new int[row][clos];
        max[0][0] = grid[0][0];
        for(int i=1;i<clos;i++){
            max[0][i] = max[0][i-1]+grid[0][i];
        }
        for(int j=1;j<row;j++){
            max[j][0] = max[j-1][0]+grid[j][0];
        }
        for(int p=1;p<row;p++){
            for(int q=1;q<clos;q++){
                max[p][q] = Math.max(max[p-1][q],max[p][q-1])+grid[p][q];
            }
        }
        for(int p=0;p<row;p++){
            for(int q=0;q<clos;q++){
                System.out.println(max[p][q]);
            }
        }
        return max[row-1][clos-1];
    }

}
