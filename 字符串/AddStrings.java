package 字符串;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 提示：
 * <p>
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("123", "9"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) {
                carry += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                carry += num2.charAt(j) - '0';
                j--;
            }
            sb.append(carry % 10);
            carry = carry / 10;
        }
        return sb.reverse().toString();
    }


    /*
    654321
    321

    123456
    123450
    */
    public static String sum(String num1, String num2) {
        String s1 = new StringBuilder(num1).reverse().toString();
        String s2 = new StringBuilder(num2).reverse().toString();
        int len1 = s1.length();
        int len2 = s2.length();
        int len = len1 > len2 ? len1 : len2;
        if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                s2 += "0";
            }
        } else {
            for (int i = len1; i < len2; i++) {
                s1 += "0";
            }
        }
        //boolean over = false;
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int temp = Integer.parseInt(s1.charAt(i) + "") + Integer.parseInt(s2.charAt(i) + "");
            temp += carry;
            sum.append(temp % 10);
            carry = temp / 10;
        }

        if (carry > 0) {
            sum.append(1);
        }
        return sum.reverse().toString();
    }

}
