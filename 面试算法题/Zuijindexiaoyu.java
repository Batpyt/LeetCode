package 面试算法题;

import java.util.Stack;

/**
 * 找左边和右边最近的比当前元素小的值
 */

public class Zuijindexiaoyu {
    public static void main(String[] args) {
        int[] nums = {3,4,1,5,6,2,7,7};
        int[] n = {3,1,3,4,3,5,3,2,2};
        int[][] res = getIndex(n);
        for(int i[] : res) {
            System.out.println(i[0] +" "+i[1]);
        }
        int[][] rr = getIndex2(n);
        System.out.println("-------------");
        for(int i[] : rr) {
            System.out.println(i[0]+" "+i[1]);
        }
    }

    public static int[][] getIndex(int[] nums) {
        //单调栈，栈中储存元素下标，
        Stack<Integer> stack = new Stack<>();
        int[] r1 = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            //当当前栈不为空，且栈顶下标位置的元素大于等于当前元素时将栈顶元素时，栈顶元素出栈，因为要找比当前元素小的索引的位置
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            //如果是空的说明没有比当前元素小的
            if(stack.isEmpty()) {
                r1[i] =  -1;
            }
            //其他时候说明找到相应下标，赋值即可
            else {
                r1[i] = stack.peek();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            stack.pop();
        }


        int[] newnums = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            newnums[i] = nums[nums.length - 1 - i];
            //System.out.println(newnums[i]+" q");
        }
        int[] r2 = new int[nums.length];
        for(int i = 0; i < newnums.length; i++) {
            while(!stack.isEmpty() && newnums[stack.peek()] >= newnums[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                r2[i] =  -1;
            }
            else {
                //r2[i] = stack.peek();
                r2[i] = r2.length - 1 - stack.peek();
            }
            stack.push(i);
        }
        int[][] res = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            res[i][0] = r1[i];
            res[i][1] = r2[r2.length - 1 - i];
        }
        return res;
    }

    public static int[][] getIndex2(int[] nums) {
        int[][] res = new int[nums.length][2];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                if(res[stack.peek()][1] == 0) {
                    res[stack.pop()][1] = i;
                }

            }
            if(stack.isEmpty()) {
                res[i][0] = -1;
            }
            else {
                res[i][0] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}
