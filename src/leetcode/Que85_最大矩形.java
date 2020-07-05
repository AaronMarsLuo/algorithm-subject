package leetcode;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que85_最大矩形 {
    public static int maximalRectangle(char[][] matrix) {
        if(null==matrix || matrix.length==0){
            return 0;
        }
        int l=matrix.length;
        int r=matrix[0].length;
        int[][][] count=new int[l][r][2];
        for(int i=0;i<l;i++){
            for(int j=0;j<r;j++){
                if(matrix[i][j]=='0'){
                    count[i][j][0]=0;
                    count[i][j][1]=0;
                }else{
                    if(j>0 && count[i][j-1][0]>1){
                        count[i][j][0]=count[i][j-1][0]-1;
                    }else{
                        int k=j;
                        int num=0;
                        while(k<r && matrix[i][k]=='1'){
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
                        while(k<l && matrix[k][j]=='1'){
                            num++;
                            k++;
                        }
                        count[i][j][1]=num;
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<l;i++){
            for (int j=0;j<r;j++){
                int right=count[i][j][0];
                int down=count[i][j][1];
                int t=matrix[i][j]=='1'?1:0;
                if(right>0 && down>0 && right*down>max){
                    t=Math.max(t,calculateSqu(count,i,j,right,down,max));
                }
                max=Math.max(max,t);
            }
        }
        return max;
    }
    public static int calculateSqu(int[][][] count,int i,int j,int right,int down,int max){
        if(right*down<=max){
            return 0;
        }
        int flagRight=count[i][j+right-1][1];
        int flagDown=count[i+down-1][j][0];
        if(flagRight>=down && flagDown>=right){
            return right*down;
        }
        if(flagRight<down-1){
            right--;
        }
        if(flagDown<right-1){
            down--;
        }
        if(flagRight==down-1 && flagDown==right-1){
            return Math.max(calculateSqu(count,i,j,right-1,down,max),calculateSqu(count,i,j,right,down-1,max));
        }
        return calculateSqu(count,i,j,right,down,max);
    }

    public static void main(String[] args) {
        char[][] arr=new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(arr));
        char[][] arr2=new char[][]{{'0'}};
        System.out.println(maximalRectangle(arr2));
        char[][] arr3=new char[][]{{'1','1','1'},{'1','1','1'}};
        System.out.println(maximalRectangle(arr3));
        char[][] arr4=new char[][]{{'1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','0','0','0'},{'0','1','1','1','1','0','0','0'}};
        System.out.println(maximalRectangle(arr4));
        char[][] arr5=new char[][]{{'1','0','1','1','0','1'},{'1','1','1','1','1','1'},{'0','1','1','0','1','1'},{'1','1','1','0','1','0'},{'0','1','1','1','1','1'},{'1','1','0','1','1','1'}};
        System.out.println(maximalRectangle(arr5));
    }
}
