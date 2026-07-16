package bite.test.day09;
import java.util.*;

/**
 * 对于长度为n的一个字符串A(仅包含数字，大小写英文字母)，请设计一个高效算法，计算其中最长回文子串的长度。
 * 数据范围:1≤n≤1000要求:空间复杂度O(1)，时间复杂度O(n2)进阶:空间复杂度O(n),时间复杂度0(n)
 * 示例1
 * 输入
 * "ababc"
 * 输出
 * 3
 * 说明
 * 最长的回文子串为“aba"与“bab"，长度都为3
 * 示例2
 * 输入
 * "abbba"
 * 输出
 * 5
 * 示例3
 * 输入
 * "b"
 * 输出
 */

public class Solution01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param A string字符串
     * @return int整型
     */

///    翻转判断
//    public int getLongestPalindrome (String A) {
//        // write code here
//        int left=0,right=A.length()-1;
//        int len = 0;
//
//        for (int i = 0; i < A.length()-1; i++) {
//            for (int j = i+1; j < A.length(); j++) {
//                String str = new StringBuilder(A.substring(i, j)).reverse().toString();
//                if(str.equals(A.substring(i, j))) {
//                    len = Math.max(len, j - i);
//                }
//            }
//        }
//
//        return len;
//
//    }

///    从两边向中间对比
//public int getLongestPalindrome (String A) {
//    // write code here
//    int left=0,right=A.length()-1;
//    int len = 0;
//    if(A.length()==1){
//        return 1;
//    }
//
//    for (int i = 0; i < A.length()-1; i++) {
//        for (int j = i+1; j < A.length(); j++) {
//            String str = new StringBuilder(A.substring(i, j)).reverse().toString();
//            System.out.println(A.substring(i, j));
//            if(isSub(A.substring(i, j))) {
//                len = Math.max(len, j - i);
//            }
//        }
//    }
//
//    return len;
//
//}
//
//private boolean isSub(String s){
//    int left=0,right=s.length()-1;
//    while(left<right){
//        if(s.charAt(left)!=s.charAt(right)){
//            break;
//        }
//        left++;
//        right--;
//    }
//    return left==right;
//}

///   中心扩展法
    /**
     *## 一、核心原理
     *
     * 所有回文一定存在**对称中心**，分两类：
     *
     * 1. 奇数长度回文：中心是**单个字符**
     * 例：`aba`，中心 `b`，左右对称
     * 2. 偶数长度回文：中心是**两个字符中间空隙**
     * 例：`abba`，中心在两个`b`之间
     *
     * 遍历每个位置当作中心，向左右扩散，直到左右字符不相等，每次扩散得到合法回文，记录最大长度。
     * 不用生成子串、不用额外数组，空间极低。
     */

    public int getLongestPalindrome (String A) {
    int maxLen = 0;
    int n = A.length();
    for(int i = 0; i < n; i++){
        // 奇数长度
        int len1 = expand(A, i, i);
        // 偶数长度
        int len2 = expand(A, i, i + 1);
        maxLen = Math.max(maxLen, Math.max(len1, len2));
    }
    return maxLen;
}

    // 从l、r向两边扩散，返回当前中心最长回文长度
    private int expand(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;
    }



    public static void main(String[] args) {
        Solution01 sol = new Solution01();
        System.out.println(sol.getLongestPalindrome("a"));
    }
}