package Stark.studyy;
/*将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);
*/
/*
*这个解法是一维数组解法，击败99%
* 1.按照行数确定输入字符串数，将其拼接
* 2.以列数建立循环，每个循环有X-1列，循环中第一列全部放满，第二列及后续列间隔X-2放置
* 3.第一列和最后一列不需要考虑
* 4.第二列及后续列的第一个字符是第一列的第i个字符，第二个字符是第一列的第i+cycleLen个字符
* 5.第二列及后续列的第一个字符和第二个字符之间的间隔是cycleLen-2
* 6.返回字符串
*
* */
import java.util.Scanner;

public class Leetcode7 {
    public static void main(String[] args) {
        System.out.println("请输入行数：");
        int row = new Scanner(System.in).nextInt();
        String sb = new Scanner(System.in).nextLine();
        System.out.println(convert(sb, row));


    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        /*以列数建立循环，每个循环有X-1列，循环中第一列全部放满，第二列及后续列间隔X-2放置*/
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        /*这里的cycleLen是一个循环的长度，即一个Z字的长度*/
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i + j < n; j += cycleLen) {
                sb.append(s.charAt(i + j));
                /*第二列及后续列*/
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    /*这一步i != numRows - 1 && j + cycleLen - i < n
                    * 保证了：
                    *
                    * 1.第一列和最后一列不需要考虑
                    * 2.第二列及后续列的第一个字符是第一列的第i个字符，第二个字符是第一列的第i+cycleLen个字符
                    * 3.第二列及后续列的第一个字符和第二个字符之间的间隔是cycleLen-2
                    *
                    * */
                    sb.append(s.charAt(j + cycleLen - i));
            }

        }

        return sb.toString();




    }
}
