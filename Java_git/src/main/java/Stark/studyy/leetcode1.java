package Stark.studyy;

import java.util.Scanner;
/*两数之和*/
public class leetcode1 {
    public static void main(String[] args) {
       // System.out.println("请输入数组大小");
        //int num_length = new Scanner(System.in).nextInt();
        int[] num = new int[99];
        //int[] num = new int[num_length];
            for (int i = 0; i < num.length; i++) {
                System.out.println("请输入第"+(i+1)+"个数字：");
                num[i] = new java.util.Scanner(System.in).nextInt();
            }
            System.out.println("请输入目标值：");
            int target = new java.util.Scanner(System.in).nextInt();
            String result = TwoSum(num,target);
        System.out.println("结果为：");
        System.out.println(result);
    }
    public static String TwoSum(int[] num, int target){
        String result = "";
        for(int i = 0 ; i<num.length;i++){
            for(int j = i+1;j<num.length;j++){
                if(num[i]+num[j]==target){
                    result = "["+num[i]+","+num[j]+"]";
                    break;
                }
            }
        }
        return result;
    }
}


