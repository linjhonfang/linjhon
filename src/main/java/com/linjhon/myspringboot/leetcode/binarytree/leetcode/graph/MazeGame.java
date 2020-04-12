package com.linjhon.myspringboot.leetcode.binarytree.leetcode.graph;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 0 0 1 0
 * 0 0 0 0
 * 0 0 1 0
 * 0 1 0 0
 * 0 0 0 1
 */
public class MazeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] source = new int[5][4];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                source[i][j] = scanner.nextInt();
            }
        }
        System.out.println(JSON.toJSON(source));

        int startX = 0, startY = 0, destX = 3, destY = 2;
        Queue<PropertyObj> queue = new LinkedList();
        PropertyObj startPoint = new PropertyObj(startX, startY, 0);
        queue.offer(startPoint);
        //上下左右方向控制值
        int[] directionX = new int[4];
        int[] directionY = new int[4];
        //向右
        directionX[0] = 0;
        directionY[0] = 1;
        //向下
        directionX[1] = 1;
        directionY[1] = 0;
        //向左
        directionX[2] = 0;
        directionY[2] = -1;
        //向上
        directionX[3] = -1;
        directionY[3] = 0;
        int[][] visited = new int[5][4];
        //一共有多少条路
        int solutions = 0;
        int flag = 0;
        while (!queue.isEmpty()) {
            PropertyObj getValue = queue.poll();
            int currentX = getValue.x;
            int currentY = getValue.y;
            int currentStep = getValue.step;
            if(currentX==1 && currentY==2){
                System.out.println("solutions2");
            }
            if (currentX == destX && currentY == destY) {
                flag = 1;
                System.out.println(currentStep);
                continue;
//                break;
            }
            //上，下，左，右移动
            for (int q = 0; q < 4; q++) {
                int nextX = currentX + directionX[q];
                int nextY = currentY + directionY[q];
                if(nextX>4 || nextY>3){
                    continue;
                }
                if (nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 4
                        && nextX == destX && nextY == destY){
                    solutions++;
                }
                //不是障碍物,并且未被访问过
                if (nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 4 && source[nextX][nextY] == 0 && visited[nextX][nextY] == 0) {
                    int nextStep = currentStep + 1;
                    PropertyObj nextObj = new PropertyObj(nextX, nextY, nextStep);
                    queue.offer(nextObj);
                    System.out.println("add to queue:"+JSON.toJSON(nextObj));
                    visited[nextX][nextY] = 1;
                }

            }
        }
        if(flag!=1){
            System.out.println("no solutions");
        }
        System.out.println("solutions:"+solutions);
    }

    public static class PropertyObj {
        private int x;
        private int y;
        private int step;

        public PropertyObj(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }
    }

}
