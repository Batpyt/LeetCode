package 栈;
import java.util.*;

/*
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

 */
public class YaruTanchu {
	public static void main(String[] args) {
		int[] in = {1,2,3,4,5};
		int[] out1 = {4,5,3,2,1};
		int[] out2 = {4,3,5,1,2};
		
		System.out.println(validateStackSequences(in, out2));
	}
	
	/*
	 * 用一个辅助栈来检测，先一直压入数据，直到popped数组中有和最新压入的数据相等的数
	 * 再遍历popped数组直到popped数组和下一个stack里要pop的不一样。
	 * 若最后stack中的都顺利出栈了，则true。
	 */
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		
		int j = 0;
		for(int i = 0; i < pushed.length; i++) {
			stack.push(pushed[i]);  //压入数据
			while(!stack.isEmpty() && stack.peek() == popped[j]) {  //监测到有一样的便开始遍历，直到碰到不一样的
				stack.pop();  //若一样，则pop栈中的数据。
				j++;
			}
		}
		
		
		return stack.isEmpty();
    }

}
