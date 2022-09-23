package test;


import java.util.Arrays;

class quicksort {
    public static void main(String[] args) {


        int[] nums = sortArray(new int[]{39,28,55,87,66,3,17,39});
        System.out.println(Arrays.toString(nums));
    }

    public static int[] sortArray(int[] nums) {

        return quickSort(nums,0,nums.length-1);
    }

    public  static int[] quickSort(int[] nums,int left,int right){
        if(left>right){
            return nums;
        }
        int pivot = partition(nums,left,right);
        quickSort(nums,left,pivot-1);
        quickSort(nums,pivot+1,right);
        return nums;
    }

    public static  int partition(int[] nums,int left,int right){
        int pivot = nums[left];
        while(left<right){
            while(left<right&&nums[right]>=pivot){
                right--;
            }
            nums[left] = nums[right];
            while(left<right&&nums[left]<=pivot){
                left++;

            }
            nums[right]=nums[left];
        }
        nums[left] =pivot;
        return left;
    }
}