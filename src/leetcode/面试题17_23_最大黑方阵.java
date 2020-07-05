package leetcode;

/**
 * 给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。
 *
 * 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *    [1,0,1],
 *    [0,0,1],
 *    [0,0,1]
 * ]
 * 输出: [1,0,2]
 * 解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
 * 示例 2:
 *
 * 输入:
 * [
 *    [0,1,1],
 *    [1,0,1],
 *    [1,1,0]
 * ]
 * 输出: [0,0,1]
 * 提示：
 *
 * matrix.length == matrix[0].length <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-black-square-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 面试题17_23_最大黑方阵 {
    public int[] findSquare(int[][] matrix) {
        if(null==matrix || matrix.length==0){
            return new int[]{};
        }
        int l=matrix.length;
        int r=matrix[0].length;
        int[][][] count=new int[l][r][2];
        for(int i=0;i<l;i++){
            for(int j=0;j<r;j++){
                if(matrix[i][j]==1){
                    count[i][j][0]=0;
                    count[i][j][1]=0;
                }else{
                    if(j>0 && count[i][j-1][0]>1){
                        count[i][j][0]=count[i][j-1][0]-1;
                    }else{
                        int k=j;
                        int num=0;
                        while(k<r && matrix[i][k]==0){
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
                        while(k<l && matrix[k][j]==0){
                            num++;
                            k++;
                        }
                        count[i][j][1]=num;
                    }
                }
            }
        }
        int top=0;
        int left=0;
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
                if(t>max){
                    top=i;
                    left=j;
                    max=t;
                }
            }
        }
        if(matrix[top][left]==1){
            return new int[]{};
        }
        return new int[]{top,left,max};
    }
}
