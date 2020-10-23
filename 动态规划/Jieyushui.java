package 动态规划;
/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
/*
思路：找到每一列左右两边最高的列。
 */

public class Jieyushui {
    public static void main(String[] args) {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));

    }

    public static int trap(int[] height) {

        int sum = 0;

        for(int i = 1; i < height.length - 1; i++) { //第一列和最后一列不用管
            int maxleft = 0;
            for(int j = i - 1; j >= 0; j--) {//找到左边最高的列
                if(height[j] > maxleft) maxleft = height[j];
            }

            int maxright = 0;
            for(int j = i + 1; j < height.length; j++) {//找到右边最高的列
                if(height[j] > maxright) maxright = height[j];
            }

            int min = Math.min(maxleft, maxright);//两边最高的列中低的那一个
            //System.out.println(maxleft +" "+maxright);
            if(min > height[i]) sum = sum + min - height[i];//若低的那一个高于该列，则计算

        }
        return sum;
    }
}
