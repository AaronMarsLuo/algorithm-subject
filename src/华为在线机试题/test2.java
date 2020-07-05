
package 华为在线机试题;

import java.util.Arrays;
import java.util.Scanner;

/*
2 4
10.000000 5.000000
4.500000 3.000000
4.499999 2.000000
2.000000 1.000000
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs=sc.nextLine().split(" ");
        int m=Integer.valueOf(strs[0]);
        int n= Integer.valueOf(strs[1]);
        Double[][] nums=new Double[n][m];
        Double[][] dp=new Double[n][m];
        for (int i = 0; i < n; i++) {
            String[] lineNum=sc.nextLine().split(" ");
            for(int j=0;j<m;j++){
                nums[i][j]=Double.valueOf(lineNum[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                double top=0,left=0;
                if(i>0){
                    top=dp[i-1][j];
                }
                if(j>0){
                    left=dp[i][j-1];
                }
                dp[i][j]=Math.max(top,left)+nums[i][j];
            }
        }
        String result=dp[n-1][m-1].toString();
        result=result+"000000";

        System.out.println(result.substring(0,result.indexOf(".")+7));
    }
}
