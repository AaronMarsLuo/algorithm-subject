package leetcode;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que221_最大正方形 {
    public static int maximalSquare(char[][] matrix) {
        if(null==matrix || matrix.length==0){
            return 0;
        }
        int l=matrix.length;
        int r=matrix[0].length;
        int max=0;
        int[][] square=new int[l][r];
        for(int i=0;i<l;i++){
            for(int j=0;j<r;j++) {
                if (matrix[i][j] == '1') {
                    int left = 0, top = 0, leftTop = 0;
                    if (i > 0) {
                        top = square[i - 1][j];
                    }
                    if (j > 0) {
                        left = square[i][j - 1];
                    }
                    if (i > 0 && j > 0) {
                        leftTop = square[i - 1][j - 1];
                    }
                    square[i][j] = Math.min(Math.min(left, top), leftTop) + 1;
                    max=Math.max(square[i][j],max);
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
}
