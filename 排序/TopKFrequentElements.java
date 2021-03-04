package 排序;

import java.util.*;

/**
 * 前k个高频元素
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TopKFrequentElements {
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,2,3,3,3,4,4,5,5,5,5};
		int[] res = topKFrequent(nums, 3);
		for(int i : res) {
			System.out.println(i);
		}
	}

	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		//先将每个数字对应的出现次数记录
		for(int num : nums) {
			if(!map.containsKey(num)) {
				map.put(num, 1);
			}
			else {
				map.put(num, map.get(num) + 1);
			}
		}

		//建立优先队列，队列中储存整数，按照该整数在数组中的出现次数升序排列
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o1) - map.get(o2);
			}
		});

		for(int key : map.keySet()) {
			//当不到k个时，插入元素
			if(queue.size() < k) {
				queue.add(key);
			}
			//队列中首个元素出现次数为最小
			//当有了k个，且当前元素出现次数大于队列中首个元素出现次数
			//首个元素出列，插入当前新元素
			else if(map.get(key) > map.get(queue.peek())) {
				queue.remove();
				queue.add(key);
			}
			System.out.println(queue+" "+queue.peek());
		}
		int[] res = new int[k];
		int i = 0;
		while(!queue.isEmpty()) {
			res[i] = queue.remove();
			i++;
		}
		return res;
	}
}
