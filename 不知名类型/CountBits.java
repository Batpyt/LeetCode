package 不知名类型;

public class CountBits {
	public static void main(String[] args) {
		int[] res = countBits(5);
		for(int i : res) {
			System.out.println(i);
		}
	}

	public static int[] countBits(int num) {
		int[] res = new int[num + 1];
		for(int i = 0;i <= num; i++) {
			res[i] = Integer.bitCount(i);
		}
		return res;
	}
}
