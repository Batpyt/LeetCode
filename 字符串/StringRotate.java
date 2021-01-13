package 字符串;

public class StringRotate {
	public static void main(String[] args) {
		String s1 = "waterbottle", s2 = "erbottlewat";
		System.out.println(isFlipedString(s1,s2));
	}

	public static boolean isFlipedString(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		String ss = s2+s2;
		return ss.contains(s1);
	}
}
