package com.linjhon.myspringboot.leetcode.binarytree.string;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class PalindromeTest {
    public static void main(String[] args) {
        String source = "abba";
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        DFS(source, res, temp);
        System.out.println(JSON.toJSON(res));
    }

    private static void DFS(String source, List<List<String>> res, List<String> temp) {
        if (source.length() == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 1; i <= source.length(); i++) {
            String firstSubStr = source.substring(0, i);
            //判断该字串是否为回文子串
            if (isPalindrome(firstSubStr)) {
                temp.add(firstSubStr);
                //第一段余下子串
                String dfsString = source.substring(i);
                DFS(dfsString, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
