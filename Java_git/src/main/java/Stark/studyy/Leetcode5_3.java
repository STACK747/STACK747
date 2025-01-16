package Stark.studyy;

import java.util.Scanner;

public class Leetcode5_3 {
    public static void main(String[] args) {
        String bracket = new Scanner(System.in).next();
        System.out.println(isValid(bracket));
    }

    public static boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = 0;
        for (char c : s.toCharArray()) {
            /*
            * 如果是左括号就压入栈
            * 如果是右括号就判断栈顶元素是否与之匹配
            * 如果匹配就弹出栈顶元素
            * 如果不匹配就返回false
            * 最后判断栈是否为空
            * 如果为空就返回true
            * */
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
            } else {
                if (top == 0) return false;
                if (c == ')' && stack[top - 1] != '(') return false;
                if (c == ']' && stack[top - 1] != '[') return false;
                if (c == '}' && stack[top - 1] != '{') return false;
                top--;
            }
        }
        return top == 0;

    }
}