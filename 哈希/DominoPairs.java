package 哈希;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *  
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class DominoPairs {
	public static void main(String[] args) {
		int[][] dom = {{1,2},{2,1},{3,4},{5,7}};
		System.out.println(numEquivDominoPairs(dom));
	}

	/*
	将每个牌排序，存入hashmap中
	 */
	public static int numEquivDominoPairs(int[][] dominoes) {
		HashMap<String, Integer> map = new HashMap<>();
		for(int[] domino : dominoes) {
			Arrays.sort(domino);
			String key = domino[0] +"," +domino[1];
			//System.out.println(domino[0]+" "+domino[1]);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		int res = 0;
		//统计总共多少对，并不知道为什么这么算
		for(int val : map.values()) {
			//System.out.println(val);
			if(val == 1) continue;
			int num = val * (val - 1) / 2;
			res = res + num;
		}
		return res;
	}
}
