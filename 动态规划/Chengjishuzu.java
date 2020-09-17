package 动态规划;
/*
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 1 2 3 4 5
 * 1 1 3 4 5
 * 1 2 1 4 5
 * 1 2 3 1 5
 * 1 2 3 4 1
 */
public class Chengjishuzu {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		for(int num : constructArr(a)) {
			System.out.println(num);
		}
	}
	
	public static int[] constructArr(int[] a) {
		int[] res = new int[a.length];
		int temp = 1;
		res[0] = 1;  //左上角的1
		for(int i = 1; i < a.length; i++) {  //以中间的斜线1为轴，先计算下面的半三角。从第二行开始，因为第一行第一列固定为1.
			res[i] = res[i - 1] * a[i - 1];  //每次都在上一行的乘积结果上再乘a[i-1]
		}
		for(int i = a.length - 2; i >= 0; i--) {  //计算上半三角
			temp = temp * a[i + 1];
			res[i] = temp * res[i];
		}
		return res;
		
	}

}
