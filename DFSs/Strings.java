package DFSs;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *  
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Strings {
	public static void main(String[] args) {
		String s = "abc";
		Strings strings = new Strings();
		String[] ss = strings.permutation(s);
		for(String str : ss) {
			System.out.println(str);
		}
	}

	//创建全局变量
	//list用来储存结果
	List<String> list = new ArrayList<>();
	//char[]用来暂存字符串，也是每一轮重新排序的载体
	char[] c;
	public String[] permutation(String s) {
		c = s.toCharArray();
		dfs(0);
		return list.toArray(new String[list.size()]);
	}

	//深度遍历
	//x为遍历位置
	public void dfs(int x) {
		//当遍历到了最后一位，添加当前结果到list
		if(x >= c.length - 1) {
			list.add(String.valueOf(c));
			return;
		}

		//用来判断有没有重复
		HashSet<Character> set = new HashSet<>();
		for(int i = x; i < c.length; i++) {
			//有重复，跳过当前，剪枝
			if(set.contains(c[i])) continue;
			set.add(c[i]);
			swap(i, x);//交换，将c[i]固定在x位置
			dfs(x + 1);//开始固定x+1字符
			swap(x, i);//恢复现场
		}
	}

	void swap(int i, int x) {
		char temp = c[i];
		c[i] = c[x];
		c[x] = temp;
	}
}
