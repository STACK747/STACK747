package Stark.studyy;

import java.util.Scanner;
import java.util.Stack;

public class Leetcode5 {
    public static void main(String[] args) {
        /*注：此方法测试失败！([)]用例无法通过，题目也没说不能有这种嵌套情况，这题目出的有问题啊，如果不考虑括号的这种嵌套类型，这个解可以*/
        String bracket = new Scanner(System.in).next();
        System.out.println(isValid(bracket));
    }

    public static boolean isValid(String s) {
        /*将s转换为字符数组*/
        char[] chars = s.toCharArray();
        /*创建栈，将其压入栈中*/
        /*遍历一次chars，对其计数，建立一个2*6的二维数组，第一行为'('，')'，'{'，'}'，'['，']'，第二行为统计出出现的数量*/
        int[][] count = new int[2][6];
        for (char aChar : chars) {
            switch (aChar) {
                case '(':
                    count[0][0] = '(';
                    count[1][0]++;
                    break;
                case ')':
                    count[0][1] = ')';
                    count[1][1]++;
                    break;
                case '{':
                    count[0][2] = '{';
                    count[1][2]++;
                    break;
                case '}':
                    count[0][3] = '}';
                    count[1][3]++;
                    break;
                case '[':
                    count[0][4] = '[';
                    count[1][4]++;
                    break;
                case ']':
                    count[0][5] = ']';
                    count[1][5]++;
                    break;
            }
        }
        /*如果count[1][0]和count[1][1]相等，count[1][2]和count[1][3]相等，count[1][4]和count[1][5]相等，则返回true，否则返回false*/
        return count[1][0]==count[1][1]&&count[1][2]==count[1][3]&&count[1][4]==count[1][5];


    }

}
