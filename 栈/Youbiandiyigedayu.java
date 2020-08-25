package 栈;
import java.util.*;
/*
 * 给定一个整型数组，数组元素随机无序的，要求打印出所有元素右边第一个大于该元素的值。
 * 如数组A=[1,5,3,6,4,8,9,10] 输出[5, 6, 6, 8, 8, 9, 10, -1]
 * 如数组A=[8, 2, 5, 4, 3, 9, 7, 2, 5] 输出[9, 5, 9, 9, 9, -1, -1, 5, -1]
 */


public class Youbiandiyigedayu {
	public static void main(String[] args) {
		int[] num = {8, 2, 5, 4, 3, 9, 7, 2, 5};
		int[] num2 = {1,5,3,6,4,8,9,10};
		
		int[] res = You(num2);
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i]+", ");
		}
	}
	/*
	 * 建立辅助栈，栈中储存的是数组的索引。
	 * 一开始向栈中压入0，意思是从数组第一个只开始找。循环从1开始。
	 * 若遍历到的数组的值大于栈中的顶层的索引对应的数组的值，意味着第一个比他大的找到了，将栈的顶层弹出，并在弹出的索引的位置赋值遍历到的数组值。
	 * 若遍历到的不大于，将该索引压入栈，并继续往后遍历。
	 */
	
	public static int[] You(int[] num) {
		int[] res = new int[num.length];
		Stack<Integer> s = new Stack<>();
		s.push(0);
		int index = 1;
		
		while(index < num.length) {
			if(!s.isEmpty() && num[index] > num[s.peek()]) {
				res[s.pop()] = num[index];
				//这里没有index++，因为要再对比栈中以前存入的是否满足条件
			}
			else {
				s.push(index);
				index++;
			}
		}
		while(!s.isEmpty()) {
			res[s.pop()] = -1;
		}
		
		return res;
		
	}
	

}
