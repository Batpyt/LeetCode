package 字符串;

/**
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 * 示例1
 * 输入
 * 复制
 * "1","99"
 * 返回值
 * 复制
 * "100"
 * 说明
 * 1+99=100
 */

public class StringAdd {
	public static void main(String[] args) {
		System.out.println(add("99", "5"));
		System.out.println(add("99","5"));
	}

	public static String add(String s, String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		int[] a1 = new int[sc.length];
		int[] a2 = new int[tc.length];
		for(int i = 0; i < a1.length; i++) {
			a1[i] = sc[i] - '0';
		}
		for(int i = 0; i < a2.length; i++) {
			a2[i] = tc[i] - '0';
		}

		StringBuilder sb = new StringBuilder();
		int i1 = a1.length - 1, i2 = a2.length - 1, carry = 0;
		while(i1 >= 0 || i2 >= 0 || carry > 0) {
			int i = 0, j = 0;
			if(i1 >= 0) i = a1[i1];
			if(i2 >= 0) j = a2[i2];
			int temp = i + j + carry;
			if(temp >= 10) {
				carry = 1;
			}
			else {
				carry = 0;
			}
			//System.out.println(temp);
			sb.append(temp % 10);
			i1--;
			i2--;
		}
		return sb.reverse().toString();
	}
}
