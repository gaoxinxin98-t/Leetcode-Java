package bite.test.day01;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution1 {
    public String solve (String s, String t) {
//        BigInteger b = new BigInteger(s);
//        BigInteger bt = new BigInteger(t);
//        return b.add(bt).toString();
        StringBuilder sb = new StringBuilder();

        int i = s.length() - 1;
        int j = t.length() - 1;
        int bit = 0;

        while (i > 0 || j > 0 || bit > 0) {
            int num1 = i>0?s.charAt(i)-'0':0;
            int num2 = j>0?t.charAt(j)-'0':0;

            int sum = num1+num2+bit;
            bit = sum/10;
            sb.append(sum%10);

            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
