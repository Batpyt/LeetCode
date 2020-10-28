package 面试算法题;

import java.util.*;

public class UniqueOccur {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        int[] arr2 = {1,2};
        System.out.println(uniqueOccurrences(arr2));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<Integer>(map.values());
        return map.size() == set.size();
    }
}
