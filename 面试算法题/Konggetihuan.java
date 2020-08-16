package 面试算法题;

import java.util.Scanner;

public class Konggetihuan {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String s = sc.nextLine();
			String str = replaceSpace(s);
			
			System.out.println(str);
		}
		
	}
	
	public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        String c = " ";
        for(int i = 0; i < s.length(); i++){
            if(s.substring(i, i+1).equals(c)){
                sb.append("%20");
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        String str = sb.toString();
        return str;

    }

}
