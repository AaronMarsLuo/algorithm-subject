package 其他;

public class asdfsd {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        return checkSequ(sequence,0,sequence.length-1);
    }

    private static boolean checkSequ(int[] nums,int i,int j){
        if(i<0 || j<0 || i>nums.length-1 || j>nums.length-1){
            return true;
        }
        if(i>=j){
            return true;
        }
        int target=nums[j];
        int left=i;
        int right=j-1;
        while(left<j  && nums[left]<target){
            left++;
        }
        while(right>=i && nums[right]>target){
            right--;
        }
        if(left-right==1){
            return checkSequ(nums,i,right) && checkSequ(nums,left,j-1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[]{1,3,2,4,6,8,7,5}));
    }
}
