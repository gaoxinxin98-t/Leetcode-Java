package day06;

/**
 * 3. 无重复字符的最长子串
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */

class Solution01 {
    public int lengthOfLongestSubstring(String ss) {
        char[] s = ss.toCharArray();
        int[] hash = new int[128];

        int left=0,right=0,ret=0,n=ss.length();

        while(right<n){
            hash[s[right]]++;

            while(hash[s[right]]>1){
                hash[s[left]]--;
                left++;
            }

            ret=Math.max(ret,right-left+1);
            right++;
        }
        return ret;
    }
}
