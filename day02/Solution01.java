package day02;

import java.util.*;

/**
 * 描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 1. 0<=pushV.length == popV.length <=1000
 * 2. -1000<=pushV[i]<=1000
 * 3. pushV 的所有数字均不相同
 * 示例1
 * 输入：
 * [1,2,3,4,5],[4,5,3,2,1]
 * 复制
 * 返回值：
 * true
 * 复制
 * 说明：
 * 可以通过push(1)=>push(2)=>push(3)=>push(4)=>pop()=>push(5)=>pop()=>pop()=>pop()=>pop()
 * 这样的顺序得到[4,5,3,2,1]这个序列，返回true
 * 示例2
 * 输入：
 * [1,2,3,4,5],[4,3,5,1,2]
 * 复制
 * 返回值：
 * false
 * 复制
 * 说明：
 * 由于是[1,2,3,4,5]的压入顺序，[4,3,5,1,2]的弹出顺序，要求4，3，5必须在1，2前压入，且1，2不能弹出，但是这样压入的顺序，1又不能在2之前弹出，所以无法形成的，返回false
 */

public class Solution01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pushV int整型一维数组
     * @param popV int整型一维数组
     * @return bool布尔型
     */
    public boolean IsPopOrder (int[] pushV, int[] popV) {
        Stack<Integer> stack = new Stack<>();
        int n=0;
        for(int i=0;i<pushV.length;i++){
            stack.push(pushV[i]);
            while(!stack.isEmpty() && n<pushV.length && (stack.peek() == popV[n])){
                stack.pop();
                n++;
            }

        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
/**
 * 思路：
 * 题目要我们判断两个序列是否符合入栈出栈的次序，我们就可以用一个栈来模拟。对于入栈序列，只要栈为空，序列肯定要依次入栈。那什么时候出来呢？自然是遇到一个元素等于当前的出栈序列的元素，那我们就放弃入栈，让它先出来。
 *
 * //入栈：栈为空或者栈顶不等于出栈数组
 * while(j < n && (s.isEmpty() || s.peek() != popA[i])){
 *     s.push(pushA[j]);
 *     j++;
 * }
 * 如果能按照这个次序将两个序列都访问完，那说明是可以匹配入栈出栈次序的。
 *
 * 具体做法：
 *
 * step 1：准备一个辅助栈，两个下标分别访问两个序列。
 * step 2：辅助栈为空或者栈顶不等于出栈数组当前元素，就持续将入栈数组加入栈中。
 * step 3：栈顶等于出栈数组当前元素就出栈。
 * step 4：当入栈数组访问完，出栈数组无法依次弹出，就是不匹配的，否则两个序列都访问完就是匹配的。
 */

/**
 * Java实现代码：
 * import java.util.Stack;
 * public class Solution {
 *     public boolean IsPopOrder(int [] pushA,int [] popA) {
 *         int n = pushA.length;
 *         //辅助栈
 *         Stack<Integer> s = new Stack<>();
 *         //遍历入栈的下标
 *         int j = 0;
 *         //遍历出栈的数组
 *         for(int i = 0; i < n; i++){
 *             //入栈：栈为空或者栈顶不等于出栈数组
 *             while(j < n && (s.isEmpty() || s.peek() != popA[i])){
 *                 s.push(pushA[j]);
 *                 j++;
 *             }
 *             //栈顶等于出栈数组
 *             if(s.peek() == popA[i])
 *                 s.pop();
 *             //不匹配序列
 *             else
 *                 return false;
 *         }
 *         return true;
 *     }
 * }
 */