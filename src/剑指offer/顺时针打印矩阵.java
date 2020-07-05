package 剑指offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class 顺时针打印矩阵 {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
       ArrayList<Integer> list=new ArrayList<>();
       if(matrix.length==0){
           return list;
       }
        int minRow=0;
        int minCol=0;
        int maxRow=matrix.length-1;
        int maxCol=matrix[0].length-1;
        int i=0;
        int j=0;
        while(minRow<=maxRow && minCol<=maxCol){
            while(j<=maxCol){
                list.add(matrix[i][j]);
                j++;
            }
            minRow++;
            j--;
            list.remove(list.size()-1);
            if(minRow>maxRow || minCol>maxCol){
                break;
            }
            while(i<=maxRow){
                list.add(matrix[i][j]);
                i++;
            }
            maxCol--;
            i--;
            list.remove(list.size()-1);
            if(minRow>maxRow || minCol>maxCol){
                break;
            }
            while(j>=minCol){
                list.add(matrix[i][j]);
                j--;
            }
            maxRow--;
            j++;
            list.remove(list.size()-1);
            if(minRow>maxRow || minCol>maxCol){
                break;
            }
            while(i>=minRow){
                list.add(matrix[i][j]);
                i--;
            }
            minCol++;
            i++;
            list.remove(list.size()-1);
        }
        list.add(matrix[i][j]);
        return list;
    }

    public static void main(String[] args) {
        int[][] arr=new int[][]{{1},{2},{3},{4},{5}};
        ArrayList<Integer> integers = printMatrix(arr);
        for (Integer integer : integers) {
            System.out.print(integer+" ");
        }
    }
}
