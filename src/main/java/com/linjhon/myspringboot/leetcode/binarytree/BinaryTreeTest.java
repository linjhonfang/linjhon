package com.linjhon.myspringboot.leetcode.binarytree;


public class BinaryTreeTest {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        rootNode.setLeft(node2);
        rootNode.setRight(node3);
        preOrder(rootNode);
        middleOrder(rootNode);
        postOrder(rootNode);
    }


    public static void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.getValue());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public static void middleOrder(TreeNode node){
        if(node!=null){
            middleOrder(node.getLeft());
            System.out.print(node.getValue());
            middleOrder(node.getRight());
        }
    }


    public static void postOrder(TreeNode node){
        if(node!=null){
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getValue());
        }
    }
}