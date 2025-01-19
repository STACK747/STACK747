package Stark.studyy;
/*这个解法是二维数组解法，超高复杂度，仅击败8%*/
import java.util.Scanner;

public class Leetcode7_2 {
    public static void main(String[] args) {
        System.out.println("请输入行数：");
        int row = new Scanner(System.in).nextInt();
        String sb = new Scanner(System.in).nextLine();
        System.out.println(convert(sb, row));
    }
    public static String convert(String s, int numRows) {
        /*二维数组解法*/
        // 特殊情况：行数为1，或者字符串过短，不用转换
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        int n = numRows;
        int length = s.length();

        // 计算一个Z字周期里会消耗多少字符：2*(n-1)
        int cycleLen = 2 * (n - 1);

        // 计算需要多少个完整周期（最后一个周期可能不完整，所以要向上取整）
        int cycles = (length + cycleLen - 1) / cycleLen; // 等价于Math.ceil( (double) length / cycleLen )

        // 每个周期在二维数组上会占 (n-1) 列
        int totalCols = cycles * (n - 1);

        // 准备一个二维字符数组，行n, 列totalCols
        // 这里用字符 '\0' 表示空
        char[][] grid = new char[n][totalCols];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < totalCols; col++) {
                grid[row][col] = '\0';  // 初始化为空字符
            }
        }

        // 开始把字符串s的字符按Z字形顺序填入grid
        int idx = 0;     // s的下标，遍历字符串
        int col = 0;     // 当前要填哪一列

        while (idx < length) {
            // 1) 从上到下，往grid的这一列依次填字符
            for (int row = 0; row < n && idx < length; row++) {
                grid[row][col] = s.charAt(idx++);
            }
            col++; // 填完竖列后，列号加1，开始放斜对角

            // 2) 从下往上斜对角，每次只填一行，然后列++，行--
            //   实际要填 (n - 2) 次，如果字符不够就提前结束
            for (int row = n - 2; row >= 1 && idx < length; row--) {
                grid[row][col] = s.charAt(idx++);
                col++;
            }
            // 这里一个周期结束，再进入下一个周期
        }

        // 最后按“逐行扫描”的方式把非空字符读出来
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < n; row++) {
            for (int c = 0; c < totalCols; c++) {
                if (grid[row][c] != '\0') {
                    sb.append(grid[row][c]);
                }
            }
        }

        return sb.toString();

    }
}
