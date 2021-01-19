package DFSs;

import java.util.*;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class RestoreIpAddress {
	public static void main(String[] args) {
		String s = "25525511135";
		System.out.println(restoreIpAddresses(s));
	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		int[] ip = new int[4];
		dfs(s, res, ip, 0,0);
		return res;
	}

	/**
	 *
	 * @param s 源字符串
	 * @param res 最终结果
	 * @param ip size为4的数组
	 * @param oneindex 当前处理的数组位置
	 * @param onebegin 当前遍历的字符串索引
	 */
	public static void dfs(String s, List<String> res, int[] ip, int oneindex, int onebegin) {
		//若数组四个片段都已经填充
		if(oneindex == 4) {
			//若字符串也全都装完
			if(onebegin == s.length()) {
				//将该次结果记录
				StringBuilder sb = new StringBuilder();
				for(int n : ip) {
					sb.append(n +".");
				}
				//System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
				res.add(sb.deleteCharAt(sb.length() - 1).toString());
			}
			//若没填充完，直接返回
			return;
		}

		//若字符串填装完，但并不够四个片段，直接返回
		if(onebegin == s.length()) {
			//System.out.println(res);
			return;
		}

		//若第一个为0，直接进入下一个片段
		if(s.charAt(onebegin) == '0') {
			ip[oneindex] = 0;
			//System.out.println(ip[onebegin]);
			dfs(s, res, ip, oneindex+1, onebegin+1);
		}

		//一般情况
		int val = 0;
		for(int i = onebegin; i < s.length(); i++) {
			val = val * 10 + (s.charAt(i)-'0');
			//值要大于0小于255
			if(val > 0 && val <= 255) {
				ip[oneindex] = val;
				dfs(s, res, ip, oneindex+1, i+1);
				//System.out.println(ip[0]+" "+ip[1]+" "+ip[2]+" "+ip[3]);
			}
			else {
				break;
			}
		}
	}
}
