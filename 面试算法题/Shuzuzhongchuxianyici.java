package 面试算法题;

/*
 * 找出数组中只出现一次的那个数，其他都出现两次。
 */
/*
 * XOR。每个数XOR自己都等于0，XOR遵循交换律，最后得出的结果就是答案。
 */
public class Shuzuzhongchuxianyici {
	public static void main(String[] args) {
		int[] num = {1, 2, 2, 1, 4, 3, 3};
		System.out.println(Panduan(num));
		
		int[] num2 = {5, 1, 2, 2, 1, 4, 3, 3};
		int f = Panduan(num2);
		String binary = Integer.toBinaryString(f);
		System.out.println(binary);
	}
	
	public static int Panduan(int[] num) {
		int res = 0;
		for(int i = 0; i < num.length; i++) {
			res = res ^ num[i];
		}
		
		return res;
	}
	
//	public static int[] Liangge(int num) {
//		int[] res = new int[2];
//		
//		
//	}

}
