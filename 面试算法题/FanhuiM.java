package 面试算法题;

public class FanhuiM {
	public static void main(String[] args) {
		int[] num = {1,3,2,4,5,6,7,9,8,2,2,3,3,4,5,6,6,4,5,5,6,11,21,1,23,2323,121,544};
		int m = 10;
		
		int[] res = Fanhui(num, m);
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		
	}
	
	public static int[] Fanhui(int[] num, int m) {
		int[] res = new int[m];
		int count = 0;
		int i = 0;
		
		Sort(num, 0, 0); //先用快排排序
		
		if(m >= num.length) {
			return num;
		}
		
		while(count < m && i < m) {  //记录偶数
			if(num[i] % 2 == 0) {
				res[count] = num[i];
				i++;
				count++;
			}
			else {
				i++;
			}
		}
		if(count >= m - 1) {
			return res;
		}
		
		i = 0;
		while(count < m && i < m) {  //记录奇数
			if(num[i] % 2 != 0) {
				res[count] = num[i];
				i++;
				count++;
			}
			else {
				i++;
			}
		}
		
		
		
		return res;
	}
	
	public static void Sort(int[] num, int low, int high) {
		if(low < high) {
			int index = getIndex(num, low, high);
			
			Sort(num, low, index - 1);
			Sort(num, index + 1, high);
			}
		
	}
	
	public static int getIndex(int[] num, int low, int high) {
		int temp = num[low];
		while(low < high) {
			while(low < high && num[high] >= temp) {
				high--;
			}
			num[low] = num[high];
			
			while(low < high && num[low] <= temp) {
				low++;
			}
			num[high] = num[low];
			
		}
		num[low] = temp;
		return low;
	}
}
