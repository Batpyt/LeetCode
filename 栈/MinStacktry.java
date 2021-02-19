package 栈;

import java.util.Stack;

public class MinStacktry {
	Stack<Integer> a, b;
	public MinStacktry() {
		a = new Stack<>();
		b = new Stack<>();
	}

	public void push(int x) {
		a.push(x);
		if(b.isEmpty()) {
			b.push(x);
		}
		else if(x <= b.peek()) {
			b.push(x);
		}
	}

	public void pop() {
		if(a.peek().equals(b.peek())) {
			a.pop();
			b.pop();
		}
		else {
			a.pop();
		}
	}

	public int top() {
		return a.peek();
	}

	public int min() {
		return b.peek();
	}
}
