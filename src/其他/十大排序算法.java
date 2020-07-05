package 其他;

import java.util.Arrays;
import java.util.Stack;

public class 十大排序算法 {

    public void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public void shellSort(int[] nums) {
        int gap = 1;
        while (gap * 3 + 1 < nums.length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < nums.length; j = j + gap) {
                    for (int k = j; k >= gap; k = k - gap) {
                        if (nums[k] < nums[k - gap]) {
                            int temp = nums[k];
                            nums[k] = nums[k - gap];
                            nums[k - gap] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            gap = (gap - 1) / 3;
        }
    }

    public static int quickSortSplit(int[] nums, int left, int right) {
        if (left < 0 || right < 0 || left >= right) {
            return -1;
        }
        int i = left, j = right;
        int flag = nums[left];
        while (i != j) {
            while (nums[j] >= flag && j > i) {
                j--;
            }
            nums[i] = nums[j];
            while (nums[i] <= flag && j > i) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = flag;
        return i;
    }

    public static void quickSort(int[] nums) {
        Stack<Integer> L = new Stack<>();
        L.push(0);
        L.push(nums.length - 1);
        while (!L.isEmpty()) {
            int j = L.pop();
            int i = L.pop();
            int zone = quickSortSplit(nums, i, j);
            if (zone != -1) {
                L.push(i);
                L.push(zone - 1);
                L.push(zone + 1);
                L.push(j);
            }
        }

    }

    public static void mergeSortCombine(int[] nums, int[] copyNums, int left, int right) {
        int mid = (right - left) / 2 + left;
        int i = left;//数组一的头部
        int j = mid + 1;//数组二的头部
        int k = 0;//新数组的头部
        while (i <= mid && j <= right)//实现图二的结合排序过程
            copyNums[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        while (i <= mid)//如果数组一还没遍历完
            copyNums[k++] = nums[i++];
        while (j <= right)//如果数组二还没遍历完
            copyNums[k++] = nums[j++];
        for (int m = 0; m < k; m++)//将遍历完的结果覆盖到原数组
            nums[m + left] = copyNums[m];
    }

    public static void mergeSort(int[] nums) {
        int[] copyNums = new int[nums.length];
        Stack<Integer> pos1 = new Stack<>();//pos1用于不断划分子区间
        Stack<Integer> pos2 = new Stack<>();//pos2用于保存需要排序的子区间
        pos1.push(0);
        pos1.push(nums.length - 1);
        pos2.push(0);
        pos2.push(nums.length - 1);
        while (!pos1.empty())//不断划分子区间并保存
        {
            int j = pos1.pop();
            int i = pos1.pop();
            int mid = (j - i) / 2 + i;
            if (mid > i) {
                pos1.push(i);
                pos1.push(mid);
                pos2.push(i);
                pos2.push(mid);
            }
            if (j > mid + 1) {
                pos1.push(mid + 1);
                pos1.push(j);
                pos2.push(mid + 1);
                pos2.push(j);
            }
        }
        while (!pos2.empty())//对保存的每个区间进行结合排序
        {
            int j = pos2.pop();
            int i = pos2.pop();
            mergeSortCombine(nums, copyNums, i, j);
        }
    }

    public static void heapSortSetOneNode(int[]nums,int i,int len){
        int left=2*i+1;
        int right=2*i+2;
        int index=i;
        if(right<len){
            int t=nums[right]>nums[left]?right:left;
            index=nums[t]>nums[i]?t:i;
        }else if(left<len){
            index=nums[left]>nums[i]?left:i;
        }
        if(index!=i){
            int temp=nums[i];
            nums[i]=nums[index];
            nums[index]=temp;
            heapSortSetOneNode(nums,index,len);
        }
    }
    public static void headSort(int[] nums){
        for(int i=nums.length/2-1;i>=0;i--){
            heapSortSetOneNode(nums,i,nums.length);
        }
        int temp=nums[0];
        nums[0]=nums[nums.length-1];
        nums[nums.length-1]=temp;

        for(int i=nums.length-1;i>0;i--){
            heapSortSetOneNode(nums,0,i);
            temp=nums[0];
            nums[0]=nums[i-1];
            nums[i-1]=temp;

        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 3, 2, 6, 4, 8, 0, 1};
        //headSort(nums);
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
