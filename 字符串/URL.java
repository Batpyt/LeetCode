package 字符串;

public class URL {
	public static void main(String[] args) {
		String s = "Mr John Smith    ";
		System.out.println(replaceSpaces(s, 13));
		System.out.println(replaceSpaces("           ",5));
	}

	public static String replaceSpaces(String S, int length) {
		//String[] sc = new String[length];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++) {
			if(S.charAt(i) == ' ') {
				//sc[i] = "%20";
				sb.append("%20");
			}
			else {
				//sc[i] = Character.toString(S.charAt(i));
				sb.append(S.charAt(i));
			}
		}
		return sb.toString();
	}
}
