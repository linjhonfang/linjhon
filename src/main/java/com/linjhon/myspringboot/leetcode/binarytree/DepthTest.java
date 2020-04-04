package com.linjhon.myspringboot.leetcode.binarytree;

public class DepthTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        System.out.println(getHeight(root));
    }

    private static int getHeight(TreeNode node) {
        System.out.println("curent node value" + (node != null ? node.value : null));
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right) + 1;
    }
}
