package 牛客机试;

import java.util.*;

/**
 * 题目描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *
 * 如，输入： By?e 输出： Be?y
 *
 *
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 *
 *
 * 输入描述:
 * 输入字符串
 * 输出描述:
 * 输出字符串
 * 示例1
 * 输入
 * 复制
 * A Famous Saying: Much Ado About Nothing (2012/8).
 * 输出
 * 复制
 * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */

public class SortString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String str = scan.nextLine();
			char[] ch = str.toCharArray();
			List<Character> list = new ArrayList<>();
			//将字符串记录
			for(char c : ch) {
				if(Character.isLetter(c)) {
					list.add(c);
				}
			}

			//自定义排序字符串链表
			Collections.sort(list, new Comparator<Character>() {
				@Override
				public int compare(Character o1, Character o2) {
					return Character.toLowerCase(o1) - Character.toLowerCase(o2);
				}
			});

			//将字符替换为排序后的链表位置字符
			int index = 0;
			for(int i = 0; i < ch.length; i++) {
				if(Character.isLetter(ch[i])) {
					ch[i] = list.get(index);
					index++;
				}
			}
			System.out.println(ch);
		}

	}
}
