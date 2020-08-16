package 二分法;

import java.util.Scanner;

/*
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

示例 1：
输入：[3,4,5,1,2]
输出：1

示例 2：
输入：[2,2,2,0,1]
输出：0
 */

public class Xuanzhuanshuzu {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int[] num = new int[6];
		while(i < 6) {
			num[i] = sc.nextInt();
			i++;
			
		}
		
	}
	
	/*
	 * 左右分为两个有序数组，递增。需要找到右边数组的起始点，也称作旋转点。
	 * 二分法，中位数为m，i为左头，j为右。当n[m] > n[j]时，左边比右边最大点还大，m在左边数组中，旋转点还需向右找，i = m + 1。
	 * 当n[m] < n[j]时，m在右数组中，将右边界j设为m。
	 * 当相等时，无法确定，减小判断范围j--。
	 */
	
	public int minArray(int numbers[]) {
		int i = 0;
		int j = numbers.length - 1;
		int m = 0;
		
		while(i < j) {
			m = (i + j) / 2;
			if(numbers[m] > numbers[j]) {
				i = m + 1;
			}
			else if(numbers[m] < numbers[j]) {
				j = m;
			}
			else {
				j--;
			}
		}
		
		
		
		
		
		return numbers[i];
	}

}
