package 栈;

import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CalculatorWithNoKuoHao {
	public static void main(String[] args) {
		System.out.println(calculate("2 + 4 / 2"));
	}

	/*
	将数字储存在栈中，每当遍历到符号，回去查看上一个符号。
	若是乘除，便用栈顶的数字和当前数字做运算，若是加减，将数字带上符号入栈
	 */
	public static int calculate(String s) {
		//第一个符号默认为+
		char sign = '+';
		Stack<Integer> stack = new Stack<>();
		int num = 0;
		int res = 0;
		for(int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			//若当前是数字
			if(Character.isDigit(cur)) {
				//与之前的数字凑成新的数
				num = num * 10 - '0' + cur;
			}
			//若当前是符号或字符串最后一位
			if((cur < '0' && cur != ' ') || i >= s.length() - 1) {
				//注意，这个符号是上一个符号
				switch (sign) {
					//加减，直接带上符号入栈
					case '+' :
						stack.push(num);
						break;
					case '-' :
						stack.push(-num);
						break;
						//乘除，与栈顶元素做运算，再入栈
					case '*' :
						stack.push(stack.pop() * num);
						break;
					case '/' :
						stack.push(stack.pop() / num);
						break;
				}
				//再记录新的符号
				sign = cur;
				num = 0;
			}
		}

		//累加数字
		while(!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
	}
}
