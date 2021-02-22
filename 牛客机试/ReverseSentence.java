package 牛客机试;

import java.util.*;

public class ReverseSentence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] ss = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = ss.length - 1; i >= 0; i--) {
//			StringBuilder temp = new StringBuilder();
//			temp.append(ss[i]).reverse();
//			System.out.println(temp.toString());
//			sb.append(temp.toString() + " ");
			sb.append(ss[i] + " ");
		}
		System.out.println(sb.toString());
	}
}
