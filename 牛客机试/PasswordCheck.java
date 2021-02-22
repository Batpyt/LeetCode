package 牛客机试;

import java.util.*;

public class PasswordCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str = sc.nextLine();
			if(checkPassWord(str)) {
				System.out.println("OK");
			}
			else {
				System.out.println("NG");
			}
		}
	}

	public static boolean checkPassWord(String str) {
		if(str == null || str.length() <= 8) {
			return false;
		}

		int lower = 0, upper = 0, integer = 0, ch = 0;
		for(char c : str.toCharArray()) {
			//System.out.println(c);
			if(Character.isDigit(c)) {
				integer = 1;
				continue;
			}
			if(Character.isLowerCase(c)) {
				lower = 1;
				continue;
			}
			if(Character.isUpperCase(c)) {
				upper = 1;
				continue;
			}
			else {
				System.out.println(c);
				ch = 1;
				continue;
			}
		}
		System.out.println(integer+" "+lower+" "+upper+" "+ch);
		if((integer + lower + upper + ch) < 3) return false;

		for(int i = 0; i < str.length() - 2; i++) {
			String sub1 = str.substring(i, i + 3);
			if(str.substring(i + 1).contains(sub1)) return false;
		}
		return true;
	}
}
