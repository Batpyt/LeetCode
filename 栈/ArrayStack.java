package 栈;

import java.util.Arrays;
import java.util.EmptyStackException;
/*
用数组实现栈
 */
public class ArrayStack {
	private int[] stack = new int[10];
	private int size;
	public void push(int i) {
		//判断是否需要扩容
		if(size > stack.length) {
			stack = Arrays.copyOf(stack, stack.length * 2);
		}
		//插入数据
		stack[size++] = i;
	}

	public int peek() {
		//判断是否为空
		if(size == 0) {
			throw new EmptyStackException();
		}
		return stack[size - 1];
	}

	public int pop() {
		int i = this.peek();
		size--;
		return i;
	}

	public boolean isEmpty() {
		return size == 0;
	}
}
