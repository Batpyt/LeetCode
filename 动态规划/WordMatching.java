package 动态规划;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
