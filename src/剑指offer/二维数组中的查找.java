package 剑指offer;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * */
public class 二维数组中的查找 {
    public boolean Find(int target, int [][] array) {
        int i=array.length-1;
        int j=0;
        while(i>=0 && j<array[0].length){
            if(array[i][j]==target){
                return true;
            } else if(array[i][j]>target){
                i--;
            } else{
                j++;
            }
        }
        return false;
    }
}
