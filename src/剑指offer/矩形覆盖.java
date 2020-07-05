package 剑指offer;

/**
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 * https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class 矩形覆盖 {
    public int RectCover(int target) {
        if(target<=3){
            return target;
        }
        int p=2;
        int q=3;
        int result=5;
        while(target-3>0){
            result=p+q;
            p=q;
            q=result;
            target--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(25%1024);
        System.out.println(25&1023);
    }
}
