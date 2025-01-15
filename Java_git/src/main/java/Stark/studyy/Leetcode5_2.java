package Stark.studyy;

import java.util.Scanner;

public class Leetcode5_2 {
    public static void main(String[] args) {
        /*操了，这个解法复杂度O（n），力扣居然才超过5%，该解法通过，但效率较差*/
        String bracket = new Scanner(System.in).next();
        System.out.println(isValid(bracket));
    }

    public static boolean isValid(String s) {
        /*遍历s，如果出现[]{}()，直接替换为空*/
        while(s.contains("[]")||s.contains("{}")||s.contains("()")){
            s = s.replace("[]","");
            s = s.replace("{}","");
            s = s.replace("()","");
        }
        return s.isEmpty();

    }

    /* Stack<Character> stack_load = new Stack<>();
       for(int i = 0;i< chars.length;i++){
           stack_load.push(chars[i]);
       }
        char[] load = new char[chars.length];
        *//*将stack_load弹栈到load数组中，弹出超过一个元素则每次检测，如果成对，则将该成对元素删去，重复该操作*//*
        for(int i = 0;i<chars.length;i++){
            load[i] = stack_load.pop();

        }



        *//*将load数组转换为字符串*//*
        String result = String.valueOf(load);
        *//*如果字符串中没有空格，则返回true，否则返回false*//*
        return result.contains(" ");*/
}
