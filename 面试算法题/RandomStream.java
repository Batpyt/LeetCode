package 面试算法题;

import java.util.*;

public class RandomStream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String random = scanner.nextLine().trim();
            String target = scanner.nextLine();
            Stack<Character> stack = new Stack<>();
            for(int i = target.length() - 1; i >= 0; i--) {
                stack.push(target.charAt(i));
            }
            int index = 0;
            int count = 0;
            while(!stack.isEmpty()) {
                if(random.charAt(index) == stack.peek()) {
                    System.out.println(stack.peek()+" "+count);
                    stack.pop();
                    index++;
                    if(index >= random.length()) {
                        index = 0;
                    }
                    continue;
                }
                else {

                    index++;
                    count++;
                    System.out.println(random.charAt(index - 1) + " "+count);
                    if(index >= random.length()) {
                        index = 0;
                    }
                    continue;
                }
            }
            System.out.println(count);
        }
    }
}
