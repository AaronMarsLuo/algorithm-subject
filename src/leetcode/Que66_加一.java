package leetcode;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Que66_加一 {
    //我的想法
    public static int[] plusOne(int[] digits) {
        int t=0;
        for (int i=digits.length-1;i>=0;i--){
            int m=digits[i]+t+((i+1)/(digits.length));
            digits[i]=m%10;
            t=m/10;
            if(t!=1){
                break;
            }
            if(i==0 && t==1){
                int[] nums=new int[digits.length+1];
                nums[0]=1;
                for(int j=1;j<nums.length;j++) {
                    nums[j]=digits[j-1];
                }
                return nums;
            }
        }
        return digits;
    }
    //改进
    public static int[] plusOne1(int[] digits) {
        int t=0;
        for (int i=digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i]=digits[i]%10;
            if(digits[i]!=0){
                return digits;
            }
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
    public static void print(int[] nums){
        for (int i: nums) {
            System.out.print(i+",");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        print(plusOne1(new int[]{1,2,3}));
        print(plusOne1(new int[]{1,2,9}));
        print(plusOne1(new int[]{9}));
        print(plusOne1(new int[]{9,9,9}));
        print(plusOne1(new int[]{9,0,0}));
        print(plusOne1(new int[]{0}));
    }
}
