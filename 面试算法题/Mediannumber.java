package 面试算法题;
/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 * You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */

public class Mediannumber {
	public static void main(String[] args) {
		int[] nums1 = {1,3,5,7};
		int[] nums2 = {2,4,6,8};
		//1 2 3 4 5 6 7
		//1 2 3
		//1 2 3 4 5 6 7 8
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double res = 0;
		if((nums1.length + nums2.length) % 2 == 1) {
			res = findK(nums1, nums2, (nums1.length + nums2.length - 1) / 2);
		}
		else {
			double res1 = findK(nums1, nums2, ((nums1.length + nums2.length) / 2) - 1);
			double res2 = findK(nums1, nums2, (nums1.length + nums2.length) / 2);
			System.out.println(res1+" "+res2);
			res = (res1 + res2) / 2;
		}
		return res;
	}
	
	public static double findK(int nums1[], int[] nums2, int mid) {
		double res = 0;
		int[] num = new int[nums1.length + nums2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		//int mid = (nums1.length + nums2.length + 1) / 2;
		//if(num.length % 2 == 1) {
		while(k <= mid) {
			//System.out.println(k);
			if(i < nums1.length && j < nums2.length) {
				if(nums1[i] < nums2[j]) {
					res = nums1[i];
					//System.out.print(res);
					i++;
				}
				else {
					res = nums2[j];
					j++;
				}
			}
			else if(i < nums1.length && j >= nums2.length) {
				res = nums1[i];
				i++;
			}
			else if(i >= nums1.length && j < nums2.length){
				res = nums2[j];
				j++;
			}
			
			k++;
		}
		//}
		return res;
	}

}
