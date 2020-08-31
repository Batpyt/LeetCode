package 面试算法题;
import java.util.*;
/*
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 */

public class MaxQueue {
    Queue<Integer> queue;  //储存队列
    LinkedList<Integer> max;  //用来储存最大值的队列，从大到小排列
    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();

    }

    public int max_value() {
        if(max.size() == 0) {
            return -1;
        }
        else{
            return max.getFirst();
        }

    }

    public void push_back(int value) {
        queue.add(value);
        while(!max.isEmpty() && value > max.peekLast()) {  //每当队列插入一个数据，在辅助队列中从后往前找到该数应该在的位置
        	max.removeLast();
        }
        max.addLast(value);

    }

    public int pop_front() {
    	if(queue.isEmpty()) return -1;
    	int v = queue.poll();
    	if(v == max.peekFirst()) {  //对比pop的数是不是最大值
    		max.removeFirst();
    	}
    	return v;
    }
}
