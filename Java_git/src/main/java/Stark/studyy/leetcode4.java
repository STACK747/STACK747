package Stark.studyy;

/*
* 我的思路：将字符串分解为二维数组然后纵向比较，力扣第二种解法，另外，我还想能不能用排序解，但是没做出来。
*
*
* */
import java.util.Scanner;

public class leetcode4 {
    public static void main(String[] args){
        /*输入字符串数组*/
        System.out.println("请输入字符串数组的数量：");
        int x = Integer.parseInt(new Scanner(System.in).next());
        String[] strs = new String[x];
        for (int i = 0; i < strs.length; i++) {
            System.out.println("请输入第"+(i+1)+"个字符串：");
            strs[i] = new Scanner(System.in).next();
        }
        System.out.println(longestCommonPrefix(strs));
    }
        public static String longestCommonPrefix(String[] strs) {
           /*二维数组*/
            char[][] chars = new char[strs.length][];
            /*将strs字符串按行列放入二维数组*/
            for (int i = 0; i < strs.length; i++) {
                chars[i] = strs[i].toCharArray();
            }
            /*定义一个字符串*/
            StringBuilder result = new StringBuilder();
            /*定义一个标志位*/
            boolean flag = true;
            /*遍历二维数组*/
            for (int i = 0; i < chars[0].length; i++) {
                /*定义一个字符*/
                char c = chars[0][i];
                /*遍历二维数组的行*/
                for (int j = 1; j < chars.length; j++) {
                    /*如果当前字符等于下一行的字符*/
                    if (i == chars[j].length || chars[j][i] != c) {
                        flag = false;
                        break;
                    }
                }
                /*如果标志位为true*/
                if (flag) {
                    result.append(c);
                } else {
                    break;
                }
            }
            return result.toString();
        }
}
