package 华为在线机试题;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;
/*\
5 4
1 0 1 0
1 1 1 1
1 0 0 0
0 1 0 1
0 0 0 1
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs=sc.nextLine().split(" ");
        int m=Integer.valueOf(strs[0]);
        int n= Integer.valueOf(strs[1]);
        int[][] nums=new int[m][n];
        boolean[][] flag=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String[] lineNum=sc.nextLine().split(" ");
            for(int j=0;j<lineNum.length;j++){
                nums[i][j]=Integer.valueOf(lineNum[j]);
                if(nums[i][j]==0){
                    flag[i][j]=false;
                } else{
                    flag[i][j]=true;
                }
            }
        }
        int count=0;
        for (int i = 0; i < m; i++) {
            for(int j=0;j<n;j++){
                if(nums[i][j]==1 && flag[i][j]){
                    flag[i][j]=false;
                    findPath(nums,flag,i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void findPath(int[][] nums, boolean[][]flag,int i,int j){
        boolean in=false;
        //right
        if(i>0 && flag[i-1][j]) {
            flag[i-1][j]=false;
            in=true;
            i--;
            findPath(nums,flag,i,j);
        }
        if(in){
            i++;
            in=false;
        }
        //up
        if(j<nums[0].length-1 && flag[i][j+1]){
            flag[i][j+1]=false;
            in=true;
            j++;
            findPath(nums,flag,i,j);
        }
        if(in){
            j--;
            in=false;
        }
        //down
        if(i<nums.length-1 && flag[i+1][j]){
            flag[i+1][j]=false;
            in=true;
            i++;
            findPath(nums,flag,i,j);
        }
        if(in){
            i--;
            in=false;
        }
        //left
        if(j>0 && flag[i][j-1]){
            flag[i][j-1]=false;
            in=true;
            j--;
            findPath(nums,flag,i,j);
        }
        if(in){
            j++;
            in=false;
        }
    }
}
