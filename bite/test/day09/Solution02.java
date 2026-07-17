package bite.test.day09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 假设你有一个数组prices，长度为n，其中prices[i是股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益:
 * 1.你可以买入一次股票和卖出一次股票，并非每天都可以买入或卖出一次，总共只能买入和卖出一次，且买入必须在卖出的前面的某一天:
 * 2.如果不能获取到任何利润，请返回03.假设买入卖出均无手续费
 * 数据范围:0≤n≤105,0≤val≤104
 * 输入描述
 * 第一行输入一个正整数n表示数组的长度第二行输入n个正整数，表示股票在第i天的价格
 * 输出描述
 * 输出只买卖一次的最高收益
 * 示例1
 * 输入
 * 收起
 * 7
 * 8925471
 * 输出
 * 5
 * 说明
 * 在第3天(股票价格=2)的时候买入，在第6天(股票价格=7)的时候卖出，最大利润=7-2=5，不能选择在第2天买入，第3天卖出，这样就亏损7了;同时，你也不能在买入前卖出股票。
 * 示例2
 * 输入
 * 收起へ
 * 3
 * 241
 * 输出
 * 2
 * 示例3
 * 输入
 * 收起へ
 * 3
 * 321
 * 输出
 * 0
 */
public class Solution02 {

    ///  运行超时
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        List<Integer> list = new ArrayList<>();
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            list.add(in.nextInt());
//        }
//
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                max = Math.max(max, list.get(j) - list.get(i));
//            }
//        }
//
//
//        System.out.println(max);
//        in.close();
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            list.add(in.nextInt());
        }

        int max = 0;
        int min = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            max = Math.max(max, list.get(i) - min);
            min = Math.min(min, list.get(i));
        }

        System.out.println(max);
        in.close();
    }


}
