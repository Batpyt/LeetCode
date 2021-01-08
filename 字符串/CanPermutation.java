package 字符串;

import java.util.HashSet;

public class CanPermutation {
	public static void main(String[] args) {
		String s = "tactcoai";
		System.out.println(canPermutePalindrome(s));
	}

	public static boolean canPermutePalindrome(String s) {
		int[] count = new int[128];
		HashSet<Character> set = new HashSet<>();
		for(char c : s.toCharArray()) {
			if(set.contains(c)) set.remove(c);
			else set.add(c);
		}

		return set.size() <= 1;
	}
}
