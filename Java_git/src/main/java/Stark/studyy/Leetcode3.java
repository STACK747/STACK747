package Stark.studyy;
/*罗马数字转换为整数*/

import java.util.Scanner;

public class Leetcode3 {
    public static void main(String[] args) {
        String s = new Scanner(System.in).next();

        System.out.println(INTtrans(s));
    }
    public static int INTtrans(String s){
        int result = 0;
        /*分割字符串为字符数组*/
        char[] chars = s.toCharArray();

        int[] num = new int[chars.length];
        for(int i = 0;i<chars.length;i++){
            switch (chars[i]){
                case 'I':
                    num[i] = 1;
                    break;
                case 'V':
                    num[i] = 5;
                    break;
                case 'X':
                    num[i] = 10;
                    break;
                case 'L':
                    num[i] = 50;
                    break;
                case 'C':
                    num[i] = 100;
                    break;
                case 'D':
                    num[i] = 500;
                    break;
                case 'M':
                    num[i] = 1000;
                    break;
            }
        }

        for(int i = 0;i<num.length-1;i++){
            if(num[i]<num[i+1]){
                result -= num[i];
                /*这一步主要是
                 * 1.将当前数值减去
                 * 2.将下一个数值减去当前数值
                 * 3.将两者相加
                 * 4.最后一个数值直接加上
                 * 5.返回结果
                 * */
            }else{
                result += num[i];
            }
        }
        result += num[num.length-1];
        return result;


    }
}
