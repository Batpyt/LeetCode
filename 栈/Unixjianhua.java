package 栈;
import java.util.*;
/*
 * 输入描述：
一个字符串，表示Unix风格的路径

输出描述：
简化后的Unix风格的路径
 */
/*
 * “..”表示返回路径的上级目录（如果当前是根目录则不处理），“.”表示当前目录。
 * “/”分离路径名，多个“/”也等同于一个，所以监测到“/”直接跳到下一个字符。
 * 若监测到当前字符不是“/”，则记录字符串直到下个“/“。
 * 若记录的不是”."或者".."，则将字符串压入栈。
 * 若监测到".."，将栈中最上面的弹出。
 * 
 */

public class Unixjianhua {
	public static void main(String[] args) {
		String unix = "/a/./b/../../c/";
		
		System.out.println(Jianhua(unix));
	}
	
	public static String Jianhua(String unix) {
		String res = "";
		Stack<String> s = new Stack<>();
		
		for(int i = 0; i < unix.length(); i++) {
			String name = "";
			
			if(unix.charAt(i) == '/') {  //跳到下一个字符
				continue;
			}
			
			while(i < unix.length() && unix.charAt(i) != '/') {  //记录字符直到下个“/”
				name = name + unix.charAt(i);
				i++;
			}
			if(!name.equals(".") && !name.equals("..")) {  //记录
				s.push(name);
			}
			if(name.equals("..") && !s.isEmpty()) {  //弹出
				s.pop();
			}
			
		}
		
		if(s.isEmpty()) {
			return "/";
		}
		else {
			while(!s.isEmpty()) {
				res = "/" + s.pop() + res;
			}
		}
		return res;
		
	}

}
