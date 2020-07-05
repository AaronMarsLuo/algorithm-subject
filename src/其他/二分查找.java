package 其他;

public class 二分查找 {
    public static int binarySort(int[] nums,int target){
        int i=0,j=nums.length-1;
        int mid=i+(j-i)/2;
        while(i<=j){
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                j=mid-1;
            }else{
                i=mid+1;
            }
            mid=i+(j-i)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySort(new int[]{1,3,5,7,9,10},7));
    }
}
