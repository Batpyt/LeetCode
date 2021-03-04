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
        int[] nums = {1,2};
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
        HashMap<Integer, Integer> newmap = new HashMap<>();
        for(int key : map.keySet()) {
            //System.out.println(map.get(key)+" "+key);
            newmap.put(map.get(key), key);
        }
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return map.get(o1) - map.get(o2);
                    }
                });

        for(int key : map.keySet()) {
            if(pq.size() < k) {
                pq.add(key);
            }

            else if(map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
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