package com.linjhon.myspringboot.leetcode.binarytree.searchtree;

import com.alibaba.fastjson.JSON;
import com.linjhon.myspringboot.leetcode.binarytree.TreeNode;

import java.util.*;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        int[] source = {8,5,1,7,10,12};
        BinarySearchTreeTest treeTest = new BinarySearchTreeTest();
        System.out.println(JSON.toJSON(treeTest.bstFromPreorder(source)));
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if (n == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.push(root);

        for (int i = 1; i < n; i++) {
            // take the last element of the deque as a parent
            // and create a child from the next preorder element
            TreeNode node = deque.peek();
            TreeNode child = new TreeNode(preorder[i]);
            // adjust the parent
            while (!deque.isEmpty() && deque.peek().value < child.value)
                node = deque.pop();

            // follow BST logic to create a parent-child link
            if (node.value < child.value) node.right = child;
            else node.left = child;
            // add the child into deque
            deque.push(child);
        }
        return root;
    }
}
