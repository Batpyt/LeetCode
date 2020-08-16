package 递归;
import java.util.*;
/*
 * 问题描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共需要多少种跳法。
 */

public class Qingwatiaotaijie {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			long num = sc.nextInt();
			System.out.println("进行");
			System.out.println(Diedai(num));
			System.out.println(Digui(num));
		}
		
		
	}
	
	public static long Diedai(long num) {
		long former1 = 1;
		long former2 = 2;
		long res = 0;
		if(num == 0) {
			return 0;
		}
		if(num == 1) {
			return 1;
		}
		if(num == 2) {
			return 2;
		}
		
		/*
		 * 当n>=3，当前还剩的步数f(n)，如果接下去跳一步，那么还剩下的步数是f(n-1)；
		 * 如果接下去跳两步，那么还剩下的步数是f(n-2)，故：f(n)=f(n-1)+f(n-2)。
		 */
		else {
			for(int i = 3 ; i <= num; i++) {
				res = former1 + former2;     //f(n)=f(n-1)+f(n-2)。  s3=f(n)，s2=f(n-2)，s1=f(n-1)，s3 = res, s1 = former1, s2 = former2
				former1 = former2;           //为下一轮赋值: s1 = f(n-2)
				former2 = res;               //s2 = f(n)
			}
			return res;
		}
	}
	
	/*
	 * 递归方法：
	 * 青蛙的第一跳有两种情况：跳1级台阶或者跳两级台阶，假如跳一级，那么 剩下的两级台阶就是f(2)；
	 * 假如跳两级，那么剩下的一级台阶就是f(1)，因此f(3)=f(2)+f(1)  当n = 4时，f(4) = f(3) +f(2),以此类推.
	 */
	
	public static long Digui(long num) {
		if(num == 0) {
			return 0;
		}
		if(num == 1) {
			return 1;
		}
		if(num == 2) {
			return 2;
		}
		
		else {
			return Digui(num - 1) + Digui(num - 2);
		}
	}

}
