package 排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
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

public class KMostFrequent {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3,4,4,4,4,4,4,5};
        int[] res = topKFrequent(nums, 2);
        for(int i : res) {
            System.out.println(i);
        }

    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        //重写优先队列的排序，按照元素的出现次数升序排列
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return map.get(o1) - map.get(o2);
                    }
                });

        //向队列中插入数据
        for(int key : map.keySet()) {
            //若没达到k个，直接加入数据
            if(pq.size() < k) {
                pq.add(key);
            }

            //若已满k个，若当前元素出现次数大于队列首个元素出现次数，移除首个，插入新的
            else if(map.get(key) > map.get(pq.peek())) {
                System.out.println(pq.peek());
                pq.remove();
                pq.add(key);
            }

            System.out.println(pq);
        }
        int[] res = new int[k];
        int index = 0;
        System.out.println(pq);
        while(!pq.isEmpty()) {
            res[index] = pq.remove();
            index++;
        }
        return res;
    }
}