package 栈;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *  
 *
 * 说明：
 *
 * 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *  123
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ImplementQueueUsingStack {
	class MyQueue {
		Stack<Integer> stackin;
		Stack<Integer> stackout;

		/** Initialize your data structure here. */
		public MyQueue() {
			stackin = new Stack<>();
			stackout = new Stack<>();
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			stackin.push(x);
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			if(stackout.isEmpty()) {
				pushinstackout();
			}
			return stackout.pop();
		}

		/** Get the front element. */
		public int peek() {
			if(stackout.isEmpty()) {
				pushinstackout();
			}
			return stackout.peek();
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return stackin.isEmpty() && stackout.isEmpty();
		}

		public void pushinstackout() {
			while(!stackin.isEmpty()) {
				stackout.push(stackin.pop());
			}
		}
	}
}
