package com.linjhon.myspringboot.list;

import com.linjhon.myspringboot.leetcode.binarytree.TreeNode;

public class ListToBinarySearchTree {
    public static void main(String[] args) {
        ListToBinarySearchTree test = new ListToBinarySearchTree();
        ListNode listNode = new ListNode(-10);
        ListNode listNode2 = new ListNode(-3);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(9);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        TreeNode treeNode = test.sortedListToBST(listNode);
        System.out.println(treeNode.value);
    }
    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode current = head;
        while(current!=null){
            size++;
            current = current.next;
        }
        int[] values = new int[size];
        current = head;
        int index = 0;
        while(current!=null){
            values[index] = current.val;
            current = current.next;
            index++;
        }
        return handle(values,0,values.length-1);
    }
    private TreeNode handle(int[] nums,int start, int end){
        if (start > end) return null;
        int mid = (start + end + 1) / 2 ;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = handle(nums, start, mid - 1);
        root.right = handle(nums, mid + 1, end);
        return root;
    }
}
