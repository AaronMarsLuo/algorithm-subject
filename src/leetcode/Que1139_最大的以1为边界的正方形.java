package leetcode;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

/**
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：9
 * 示例 2：
 *
 * 输入：grid = [[1,1,0,0]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= grid.length <= 100
 * 1 <= grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-1-bordered-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que1139_最大的以1为边界的正方形 {
    public static int largest1BorderedSquare(int[][] grid) {
        if(null==grid || grid.length==0){
            return 0;
        }
        int l=grid.length;
        int r=grid[0].length;
        int[][][] count=new int[l][r][2];
        for(int i=0;i<l;i++){
            for(int j=0;j<r;j++){
                if(grid[i][j]==0){
                    count[i][j][0]=0;
                    count[i][j][1]=0;
                }else{
                    if(j>0 && count[i][j-1][0]>1){
                        count[i][j][0]=count[i][j-1][0]-1;
                    }else{
                        int k=j;
                        int num=0;
                        while(k<r && grid[i][k]==1){
                            num++;
                            k++;
                        }
                        count[i][j][0]=num;
                    }
                    if(i>0 && count[i-1][j][1]>1){
                        count[i][j][1]=count[i-1][j][1]-1;
                    }else{
                        int k=i;
                        int num=0;
                        while(k<l && grid[k][j]==1){
                            num++;
                            k++;
                        }
                        count[i][j][1]=num;
                    }
                }
            }
        }
        for(int i=0;i<l;i++){
            for(int j=0;j<r;j++){
                System.out.print(count[i][j][0]+"+"+count[i][j][1]+" ");
            }
            System.out.println();
        }
        int max=0;
        for(int i=0;i<l;i++){
            for (int j=0;j<r;j++){
                int t= Math.min(count[i][j][0],count[i][j][1]);
                while(t>1){
                    if(count[i][j+t-1][1]>=t && count[i+t-1][j][0]>=t){
                        break;
                    }
                    t--;
                }
                max=Math.max(max,t);
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
         int[][] arr=new int[][]{{1,0,1,0,1,1,1},{0,1,1,0,1,1,1},{0,1,1,0,1,1,1},{1,1,1,0,1,1,0},{1,1,1,0,1,0,1},{1,1,1,1,0,1,1},{1,1,1,1,1,1,1},{1,1,1,1,1,1,1}};
        System.out.println(largest1BorderedSquare(arr));
    }
}
