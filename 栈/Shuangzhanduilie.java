package 栈;
/*
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

 

 示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]

 */

/*
 * 双栈实现队列。
 * 一个栈负责输入数据，一个负责输出数据，队列为先进先出，所以当输出时把第一个栈中的数据先进后出地pop进第二个栈。第二个栈便会先输出先进入第一个栈的数据。
 */

import java.util.LinkedList;

public class Shuangzhanduilie {
	class CQueue {
		LinkedList<Integer> l1, l2;

	    public CQueue() {
	    	l1 = new LinkedList<Integer>();
	    	l2 = new LinkedList<Integer>();
	    	
	    }
	    
	    public void appendTail(int value) {
	    	l1.push(value);

	    }
	    
	    public int deleteHead() {
	    	if(!l2.isEmpty()) {
	    		return l2.pop();
	    	}
	    	else if(l1.isEmpty()) {
	    		return -1;
	    	}
	    	else {
	    		while(!l1.isEmpty()) {
	    			l2.push(l1.pop());
	    		}
	    		return l2.pop();
	    	}

	    }
	}
}
