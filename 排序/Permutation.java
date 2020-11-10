package 排序;

/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
本质为数组中数字组合为新的数字，是新的数字仅大于当前组成的数字。若当前数字已经是最大，将数组按递增序排列。
从后往前倒序遍历，寻找第一个正序组合，即nums[i] < nums[i + 1]，
由于i后面的数为递减，在后面寻找第一个比i处的数大的数，将两数交换，再将i后面的数倒转，变为递增序排列。
当没有递增组合时，说明数组已经递减排列，为最大值，直接倒转
 */
public class Permutation {
    public static void main(String[] args) {
        int[] nums = {4,5,2,6,3,1};
        int[] n = {6,5,4,3};
        Permutation p = new Permutation();
        p.nextPermutation(n);
        for(int i : n) {
            System.out.print(i+" ");
        }
    }

    public void nextPermutation(int[] nums) {
        int index = nums.length - 2;

        //倒序寻找递增组合
        while(index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }

        //index为第一个比自己后面的值小的位置，index<0说明不存在
        if(index >= 0) {
            int right = nums.length - 1;

            //寻找index后面第一个比index大的值
            while(right >= index && nums[index] >= nums[right]) {
                right--;
            }
            //交换两个值
            swap(nums, index, right);
        }
        reverse(nums, index + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //倒转
    public static void reverse(int[] nums, int i) {
        int left = i;
        int right = nums.length - 1;
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
