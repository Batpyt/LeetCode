package 栈;

import java.util.Stack;

public class Hantuigezifuchuan {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";

        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();

        char[] cs = S.toCharArray();
        char[] ct = T.toCharArray();

        for(char c : cs) {
            if(!s.isEmpty() && c == '#') {
                s.pop();
            }
            else if (c != '#') {
                //System.out.println(c);
                s.push(c);
            }
        }
        for(char c : ct) {
            if(!t.isEmpty() && c == '#') {
                t.pop();
            }
            else if (c != '#') {
                t.push(c);
            }
        }

        while(!s.isEmpty() && !t.isEmpty()) {
            if(s.pop() != t.pop()) return false;
        }
        if(!s.isEmpty() || !t.isEmpty()) return false;

        return true;

//        String s1 = "";
//        while(!s.isEmpty()) {
//            s1 = s1 + s.pop();
//        }
//        String s2 = "";
//        while(!t.isEmpty()) {
//            s2 = s2 + t.pop();
//        }
//        System.out.println(s1);
//        System.out.println(s2);
//
//        if(!s1.equals(s2)) return false;
//        else return true;
    }
}
