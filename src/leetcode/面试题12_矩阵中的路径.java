package leetcode;

import java.util.Arrays;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 面试题12_矩阵中的路径 {
    public static boolean exist(char[][] board, String word) {
        int x=board.length;
        int y=board[0].length;
        boolean[][] selected=new boolean[x][y];
        for(int i=0;i<x;i++){
            Arrays.fill(selected[i],false);
        }
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(board[i][j]==word.charAt(0)){
                    selected[i][j]=true;
                    boolean flag=dfs(board,word.substring(1),selected,i,j);
                    if(flag){
                        return true;
                    }
                    selected[i][j]=false;
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board,String word,boolean[][] selected,int x,int y){
        if(word.equals("")){
            return true;
        }
        boolean f1=false,f2=false,f3=false,f4=false;
        if(x>0 && !selected[x-1][y] && board[x-1][y]==word.charAt(0)){
            selected[x-1][y]=true;
            f1=dfs(board,word.substring(1),selected,x-1,y);
            selected[x-1][y]=false;
        }
        if(f1){
            return true;
        }
        if(y<board[0].length-1 && !selected[x][y+1] && board[x][y+1]==word.charAt(0)){
            selected[x][y+1]=true;
            f2=dfs(board,word.substring(1),selected,x,y+1);
            selected[x][y+1]=false;
        }
        if(f2){
            return true;
        }
        if(x<board.length-1 && !selected[x+1][y] && board[x+1][y]==word.charAt(0)){
            selected[x+1][y]=true;
            f3=dfs(board,word.substring(1),selected,x+1,y);
            selected[x+1][y]=false;
        }
        if(f3){
            return true;
        }
        if(y>0 && !selected[x][y-1] && board[x][y-1]==word.charAt(0)){
            selected[x][y-1]=true;
            f4=dfs(board,word.substring(1),selected,x,y-1);
            selected[x][y-1]=false;
        }
        return f4;
    }

    public static void main(String[] args) {
        char[][] board1={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board2=new char[][]{{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        char[][] board3=new char[][]{{'a','b'},{'c','d'}};
        char[][] board4=new char[][]{{'a'}};
        System.out.println(exist(board1,"ABCCED"));
        System.out.println(exist(board2,"abcdefg"));
        System.out.println(exist(board3,"abcd"));
        System.out.println(exist(board4,"a"));
        System.out.println(exist(new char[][]{{'a','b'}},"ba"));

    }
}
