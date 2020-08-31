package 面试算法题;
/*
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 */
public class Zifuchuanzhuanzhengshu {
	public static void main(String[] args) {
		String str = "+123";
		System.out.println(strToInt(str));
	}
	
	public static int strToInt(String str) {
		str = str.trim();
		if(str.isEmpty()) return 0;
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int res = 0;
		int sign = 1;
		int zheng = 0;
		if(!Character.isDigit(str.charAt(0))){  //判断第一个非空字符是不是正负号
			if(str.charAt(0) == '-') { 
				i = 1;
				sb.append("-");
				sign = -1;
			}
			if(str.charAt(0) == '+') {
				i = 1;
				zheng = 1;
			}
		}
		if(sign == -1 && str.length() == 1) return 0;  //如果只有负号/正号，返回0
		if(zheng == 1 && str.length() == 1) return 0;
		
		int da = Integer.MAX_VALUE / 10;
		while(Character.isDigit(str.charAt(i))){
			if(res > da || (res == da && str.charAt(i) > '7')) {  //判断是否超过最大值
				System.out.println(res);
				if(sign == 1) return Integer.MAX_VALUE;
				else return Integer.MIN_VALUE;
			}
			res = res * 10 + str.charAt(i) - '0';
			i++;
			if(i >= str.length()) {
				break;
			}
		}
		
		return sign * res;
		
		
	}

}
