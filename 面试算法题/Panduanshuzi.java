package 面试算法题;
import java.util.*;

/*
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 */

public class Panduanshuzi {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String s = sc.nextLine();
			System.out.println(isNumber(s));
		}
		
	}
	public static boolean isNumber(String s) {
		if(s == null || s.length() == 0) {
			return false;
		}
		char[] n = s.trim().toCharArray();
		boolean dot = false;
		boolean eE = false;
		boolean shu = false;
		
		for(int i = 0; i < n.length; i++) {
			if(n[i] >= '0' && n[i] <= '9') { //如果是数字
				shu = true;
			}
			else if(n[i] == '+' || n[i] == '-') { //如果是+或者-，只能数现在一开始或者e、E后面。
				if(i != 0 && n[i - 1] != 'e' && n[i - 1] != 'E') {
					return false;
				}
			}
			else if(n[i] == '.') {
				if(dot || eE) {    //如果是小数点，在e、E前面只能出现一次，，不能在e、E后面出现。
					return false;
				}
				dot = true;
			}
			else if(n[i] == 'e' || n[i] == 'E') {
				if(!shu || eE) {    //如果e、E前面没有数字，或者已出现过e，E，则返回错误。
					return false;
				}
				else {
					eE = true;
					shu = false;  //e、E之后重新开始检测有没有数字。
				}
			}
			else {
				return false;
			}
		}
		
		return shu;
	}

}
