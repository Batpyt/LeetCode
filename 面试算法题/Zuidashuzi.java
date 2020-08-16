package 面试算法题;
import java.util.*;
/*
 * 输入一串字符串， 包含字母和数字， 输出最大的数字。比如：fasdf323fajs424434fajsdfl1，结果应该为424434.
 */

public class Zuidashuzi {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String str = sc.nextLine();
			char[] c = str.toCharArray();  //转为char数组
			
			
			
			System.out.println(Zuida(c));
			
			
		}
		
		
	}
	
	public static int Zuida(char[] c) {
		int j = 0;
		int res = 0;
		String shu = "";  //用来储存数字的字符串
		int max = 0;
		int temp = 0;
		
		for(int i = 0; i < c.length; i++) {    //从第一个开始循环
			shu = "";                          //重置储存数字的字符串
			j = i;                             //j从i的地方再次开始
			while(Character.isDigit(c[j])) {   //如果j是数字，开始遍历后面的字符，直到不再是数字
				shu = shu + c[j];              //储存数字
				j++;                           //遍历
				if(j == c.length) {            //如果是最后一个字符，跳出
					break;
				}
			}
			if(shu != "") {                    //如果有数字存储，比大小
				temp = Integer.parseInt(shu);
				if(temp >= max){
					max = temp;
				}
			}
			
			i = j;
		}
		
		
		return max;
	}

}
