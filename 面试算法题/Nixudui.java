package 面试算法题;

public class Nixudui {
    public static void main(String[] args){
        int[] nums = {7,5,6,3};
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int j = i + 1;
            while(j < nums.length){
                if(nums[i] > nums[j]){
                    count++;
                    j++;
                }
                else{
                    j++;
                }
            }
        }
        return count;
    }
}
