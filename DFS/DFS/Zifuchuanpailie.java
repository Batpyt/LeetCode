package DFS;
import java.util.*;
/*
 * 输入一个字符串，打印出该字符串中字符的所有排列。你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
/*
 * 真的很难。深度优先遍历。
 * 从第一个字符开始，一次确定一位，确认到最后一个时，再通过递归将后两个交换位置，再往前一个交换位置。
 */

public class Zifuchuanpailie {
	static List<String> list = new ArrayList<>();  //用来储存结果
	static char[] c;  //用来暂存字符串
	public static void main(String[] args) {
		String s = "abc";
		String[] res = permutation(s);
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	
	public static String[] permutation(String s) {
		c = s.toCharArray();
		
		dfs(0);  //调用dfs
		
		return list.toArray(new String[list.size()]);  //把list转成String数组输出
	}
	
	public static void dfs(int x) {
		if(x >= c.length - 1) {  //若遍最后一位已确定，返回结果
			list.add(String.valueOf(c));
			return;
		}
		HashSet<Character> set = new HashSet<>();  //建立set来判断字符是否已经出现
		
		for(int i = x; i < c.length; i++) {
			if(set.contains(c[i])) {  //若已经出现，跳过此循环。
				continue;
			}
			set.add(c[i]);  //确认该位置的字符
			swap(i, x);  //交换，一开始是（0，0），（1，1），（2，2），递归回来是 i++：（2，1）。。
			dfs(x + 1);  //交换位置
			swap(x, i);  //恢复现场
		}
		
	}
	
	public static void swap(int i, int x) {
		char temp = c[i];
		c[i] = c[x];
		c[x] = temp;
	}

}
