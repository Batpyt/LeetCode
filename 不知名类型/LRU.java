package 不知名类型;

import java.util.*;

/**
 * least recently used，最近最少使用算法，
 * 长期不使用的数据，当内存占用达到阈值时，移除最近最少使用的数据，
 * 用双向链表的形式实现key-value对。
 */

//双向链表的构造
class LRUNode {
	String key;
	Object value;
	LRUNode next;
	LRUNode pre;

	public LRUNode(String key, Object value) {
		this.key = key;
		this.value = value;
	}
}

public class LRU {
	//用图来储存k-v对
	Map<String, LRUNode> map = new HashMap<>();
	//头节点和尾节点
	LRUNode head;
	LRUNode tail;
	//内存阈值
	int limit;

	public LRU(int limit) {
		this.limit = limit;
	}


	/*
	使用/输入数据
	 */
	public void put(String key, Object value) {
		/*
		若是第一个数据，直接新建然后插入到链表头部
		 */
		if(head == null) {
			head = new LRUNode(key, value);
			tail = head;
			map.put(key, head);
		}

		//在map中查找该数据是否存在
		LRUNode node = map.get(key);
		/*
		若存在，则为老数据，调用方法
		 */
		if(node != null) {
			node.value = value;
			removeAndInsert(node);
		}
		/*
		若不存在，则为新数据
		 */
		else {
			//新建节点
			LRUNode temp = new LRUNode(key, value);
			//若已达到内存阈值上限，删除尾部节点
			if(map.size() >= limit) {
				map.remove(tail);
				tail = tail.pre;
				tail.next = null;
			}
			//将节点插入首部
			map.put(key, temp);
			temp.next = head;
			head.pre = temp;
			head = temp;
		}
	}

	public Object get(String key) {
		LRUNode node = map.get(key);
		if(node != null) {
			removeAndInsert(node);
			return node.value;
		}
		return null;
	}

	public void removeAndInsert(LRUNode node) {
		//若node就是首部，不做改动
		if(node == head) return;
		/*
		若是尾部节点，该节点的前一个节点变为尾部节点
		 */
		else if (node == tail) {
			tail = node.pre;
			tail.next = null;
		}
		/*
		若是中间节点，链接该节点前后节点
		 */
		else {
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}

		//将该节点设为首部
		node.next = head;
		node.pre = null;
		head.pre = node;
		head = node;
	}
}
