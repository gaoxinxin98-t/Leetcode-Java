package com.tyj.day01;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 *
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 *
 * 输出：true
 *
 * 示例 3：
 *
 * 输入：s = "(]"
 *
 * 输出：false
 *
 * 示例 4：
 *
 * 输入：s = "([])"
 *
 * 输出：true
 *
 * 示例 5：
 *
 * 输入：s = "([)]"
 *
 * 输出：false
 *
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }

        Stack stack = new Stack<Character>();

        HashMap<Character,Character> map = new HashMap<Character,Character>() {
            {
                put(')','(');
                put('}','{');
                put(']','[');
            }
        };

        for(int i=0;i<s.length();i++){

            char a =  s.charAt(i);
            if(a=='(' || a=='{' || a=='[')
                stack.push(a);
            else{
                if(!stack.isEmpty() && stack.peek()==map.get(a)){
                    stack.pop();
                    continue;
                }else{
                    return false;
                }

            }


        }
        return stack.isEmpty();

    }
}

