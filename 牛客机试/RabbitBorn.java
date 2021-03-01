package 牛客机试;

import java.util.Scanner;

public class RabbitBorn {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			System.out.println(getNum(n));
		}

	}

	public static int getNum(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		//从第三个月起，第一只兔子成熟，可以生孩子
		int old = 1;
		//未成熟的兔子，不能生孩子
		int yong = 0;
		//刚出生的兔子，第一个月
		int month1 = 1;
		//第二个月的兔子
		int month2 = 0;
		for(int i = 4; i <= n; i++) {
			//第二个月的兔子变成熟
			old += month2;
			//第一个月的兔子长到第二个月
			month2 = month1;
			//成熟的兔子生出了新的兔子
			month1 = old;
			//第一个月+第二个月的兔子为未成熟兔子总数
			yong = month1 + month2;
		}
		return old + yong;
	}
}
