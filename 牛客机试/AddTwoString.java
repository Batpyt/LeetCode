package 牛客机试;

import java.math.BigInteger;
import java.util.*;

public class AddTwoString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String s1 = scanner.nextLine().trim();
			String s2 = scanner.nextLine().trim();

			BigInteger i1 = new BigInteger(s1);
			BigInteger i2 = new BigInteger(s2);

			System.out.println(i1.add(i2));
		}
	}
}