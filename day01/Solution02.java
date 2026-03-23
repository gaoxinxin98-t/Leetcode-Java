package com.tyj.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 *
 * 提示:
 *
 * 1 <= numRows <= 30
 */
class Solution02 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);

        list.add(List.of(1));

        for(int i = 1; i<numRows; i++) {
            List<Integer> row = new ArrayList<>(i+1);
            row.add(1);
            if(i>1)
                for(int j = 1;j<i;j++){
                    row.add(j,list.get(i-1).get(j-1)+list.get(i-1).get(j));
                }
            row.add(1);

            list.add(row);
        }

        return list;
    }
}