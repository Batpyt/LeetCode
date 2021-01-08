package 字符串;

import java.util.Stack;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class OneEdit {
	public static void main(String[] args) {
		String s1 = "spartan", s2 = "part";
		System.out.println(oneEditAway(s1,s2));
	}


	//分情况
	public static boolean oneEditAway(String first, String second) {
		//长度差要在一个以内
		if(Math.abs(second.length() - first.length()) >= 2) return false;
		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		boolean diff = false;

		//长度不同时，双指针
		//若第一个的长度大于第二个
		if(first.length() > second.length()) {
			//j为first的指针，i为second的指针
			int j = 0;
			for(int i = 0; i < second.length(); i++) {
				System.out.println(first.charAt(j) +" "+second.charAt(i));
				//当不一样时
				if(first.charAt(j) != second.charAt(i)) {
					//若之前没出现过不一样，下一轮依然判断second的这一个，所以i--
					if(!diff) {
						diff = true;
						i--;
						j++;
					}
					else return false;
				}
				else {
					j++;
				}
			}
		}
		//second长度大于first，原理一样
		if(first.length() < second.length()) {
			int j = 0;
			for(int i = 0; i < first.length(); i++) {
				if(first.charAt(i) != second.charAt(j)) {
					if(!diff) {
						diff = true;
						i--;
						j++;
					}
					else return false;
				}
				else j++;
			}
		}
		//当长度相同发，直接判断
		if(first.length() == second.length()) {
			for(int i = 0; i < first.length(); i++) {
				if(first.charAt(i) != second.charAt(i)) {
					if(!diff) diff = true;
					else return false;
				}
			}
		}

		return true;
	}
}
