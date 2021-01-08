package 不知名类型;

public class UniqueChar {
	public static void main(String[] args) {
		String s = "leetcode";
		System.out.println(isUnique(s));

		String s1 = "abc", s2 = "bca";
		System.out.println(CheckPermutation(s1,s2));
	}

	public static boolean isUnique(String astr) {
		for(char c : astr.toCharArray()) {
			if(astr.indexOf(c) != astr.lastIndexOf(c)) return false;
		}
		return true;
	}

	public static boolean CheckPermutation(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		int[] a1 = new int[26];
		//int[] a2 = new int[s1.length()];
		for(int i = 0; i < s1.length(); i++) {
			a1[s1.charAt(i) - 'a']++;
			a1[s2.charAt(i) - 'a']--;
		}
		for(int i : a1) {
			if(i != 0) return false;
		}
		return true;
	}
}
