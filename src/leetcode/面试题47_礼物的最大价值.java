package leetcode;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
public class 面试题47_礼物的最大价值 {
    public static int maxValue(int[][] grid) {
        if(null==grid || grid.length==0){
            return 0;
        }
        int l=grid.length;
        int r=grid[0].length;
        int[][] value=new int[l][r];
        value[0][0]=grid[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int up=0,left=0;
                if(i>0){
                    up=value[i-1][j];
                }
                if(j>0){
                    left=value[i][j-1];
                }
                value[i][j]=Math.max(up,left)+grid[i][j];
            }
        }
        return value[l-1][r-1];
    }

    public static int maxValue1(int[][] grid) {
        if(null==grid || grid.length==0){
            return 0;
        }
        int l=grid.length;
        int r=grid[0].length;
        int[] value=new int[r];
        value[0]=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++) {
                if(j==0){
                    value[j]+=grid[i][j];
                }else{
                    value[j]=Math.max(value[j-1],value[j])+grid[i][j];
                }
            }
        }
        return value[r-1];
    }
    public static void main(String[] args) {
        int[][] grid=new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        maxValue(grid);
    }
}
