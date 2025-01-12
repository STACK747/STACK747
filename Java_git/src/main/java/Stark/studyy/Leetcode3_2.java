package Stark.studyy;
/*HASH没做出来，MCMXCIV答案错误*/
import java.util.HashMap;
import java.util.Scanner;

public class Leetcode3_2 {
    public static void main(String args[]){
        String s = new Scanner(System.in).next();
        System.out.println(INTtrans(s));
    }

    private static int INTtrans(String s) {

        int result = 0;
        /*转换为字符数组*/
        char[] chars = s.toCharArray();
        /*hashmap这里有点问题，在Stackoverflow搜Hashmap does not work with int, char [duplicate]*/
        HashMap<Character, Integer> Sites = new HashMap<Character, Integer>();
        Sites.put('I',1);
        Sites.put('V',5);
        Sites.put('X',10);
        Sites.put('L',50);
        Sites.put('C',100);
        Sites.put('D',500);
        Sites.put('M',1000);
        /*hashmap*/
        for (int i = 0;i< chars.length;i++){

            if(Sites.containsKey(chars[i])){
                /*System.out.print(Sites.get(chars[i]));*/
                /*根据罗马数字规则将对应的值相加减*/
                result += Sites.get(chars[i]);
            }
        }
        /*这里有点问题，需要再次遍历一遍，将特殊情况的值减去*/
        for (int i = 0;i< chars.length-1;i++){
            if(Sites.get(chars[i])<Sites.get(chars[i+1])){
                result -= Sites.get(chars[i]);
            }

    }
        return result;
    }


}
