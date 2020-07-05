package 其他;

import java.util.*;

public class 和为0的三元组 {
    private static Set<List<Integer>> list=new HashSet<>();
    public static Set getGroups(int[] nums){
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-3;i++){
            int target =0-nums[i];
            int index1=i+1;
            int index2=nums.length-1;
            while(index1<index2){
                if(nums[index1]+nums[index2]==target){
                    List<Integer> l=new ArrayList();
                    l.add(nums[i]);
                    l.add(nums[index1]);
                    l.add(nums[index2]);
                    list.add(l);
                    index1++;
                } else if(nums[index1]+nums[index2]>target) {
                    index2--;
                } else{
                    index1++;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Set groups = getGroups(new int[]{-1, 0, 1, 2, -1, -3, 1});
        for (Object group : groups) {
            System.out.println(group);
        }
    }
}
