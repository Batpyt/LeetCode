package 动态规划;

public class WordMatching {
	public static void main(String[] args) {
		String s = "adceb", p = "*a*b";
		System.out.println(isMatch(s,p));
	}

	public static boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		//第0行和第0列分别是p匹配空和s匹配空
		//[0,0]代表空匹配空
		dp[0][0] = true;
		//p匹配空字符，若有*则是true，没有跳出
		for(int i = 1; i <= p.length(); i++) {
			if(p.charAt(i-1) == '*') {
				dp[0][i] = true;
			}
			else {
				break;
			}
		}


		for(int i = 1; i <= s.length(); i++) {
			for(int j = 1; j <= p.length(); j++) {
				//该情况要看两个字符串的前一对字符是否相等
				if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
					dp[i][j] = dp[i-1][j-1];
				}
				//看各自前一对是否相等
				if(p.charAt(j-1) == '*') {
					dp[i][j] = dp[i][j-1] | dp[i-1][j];
 				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
