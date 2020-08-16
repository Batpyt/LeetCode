package 栈;
import java.util.*;
/*
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
 */
/*
 * 两个栈，一个记录正常数据，一个只记录比上一个更小的数据。
 */
public class MinStack {
	/** initialize your data structure here. */
	Stack<Integer> a, b;
    public MinStack() {
    	a = new Stack<>();
    	b = new Stack<>();
    }
    
    public void push(int x) {
    	a.add(x);
    	if(b.empty()) { //若b是空的，压入第一个数
    		b.add(x);
    	}
    	else if(x <= b.peek()) {  //之后的数都要比上一个小
    		b.add(x);
    	}
    }
    
    public void pop() {
    	if(a.peek().equals(b.peek())) {  //若a和b的第一个数相等，才都出栈
    		a.pop();
    		b.pop();
    	}
    	else {
    		a.pop();  //若不相等只出a
    	}
    }
    
    public int top() {
    	return a.peek();
    }
    
    public int min() {
    	return b.peek();
    }

}
