package Stark.studyy;

import java.util.Scanner;
/*
 * 更快的解法： public boolean isPalindrome(int x) {
 *                    return String.valueOf(x).equals(new StringBuilder(String.valueOf(x)).reverse().toString());
 *                      }
 * 另外：我想的是把x转换为字符数组，然后遍历一遍，比较成对数量和不成对的数字所处位置（如果未处于末尾，则判定false），但提交到力扣之后，发现100，121这种例子无法通过
 * */


public class leetcode2 {
    public static void main(String[] args) {
        int x = new Scanner(System.in).nextInt();
        System.out.println(isPalindrome(x));
    }
    public static boolean isPalindrome(int x) {
        /*将传入X转换为字符串*/
        String str = String.valueOf(x);
        /*将字符串转换为字符数组*/
        char[] chars = str.toCharArray();
        /*定义两个指针，一个指向头部，一个指向尾部*/
        int start = 0;
        int end = chars.length-1;
        /*双循环，一个从前往后，一个从后往前进行比较，如果相等就进行下一轮比较，如果不等则返回false*/
        while(start<end){
            if(chars[start]==chars[end]){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }

}

