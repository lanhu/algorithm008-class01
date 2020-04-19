package com.lanhu.leecode;

import java.util.*;

/**
 * @author 蓝狐
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 当判断成对出现元素是否合理时，可以考虑栈，先进后出
 * 利用额外的空间，只是额外空间中元素的排序是否复合场景
 */
public class EffectiveBrackets {

    public static void main (String[] args) {
        //String input = "()[]{}";
        //boolean result = isValid(input);
        //System.out.println(result);
        String input2 = "([{}])";
        boolean result2 = isValid(input2);
        System.out.println(result2);

    }
    public static boolean isValid(String str){
        if (str.trim().equals("")){
            return true;
        }
        int length = str.length();
        // 奇数偶数判断
        if ((length & 1) == 1){
            return false;
        }
        char[] chars = str.toCharArray();
        // 用linkedlist模拟栈
        LinkedList<Character> linkedList = new LinkedList();
        for (int i = 0; i < chars.length; i++) {
           char c = chars[i];
           if (c == '{'){
               linkedList.addLast('}');
           }else if (c == '('){
               linkedList.addLast(')');
           }else if (c == '['){
               linkedList.addLast(']');
           }else if(linkedList.isEmpty() || linkedList.removeLast() != c){
               return false;
           }
        }
        if(linkedList.isEmpty()){
            return true;
        }
        return false;
    }
}
