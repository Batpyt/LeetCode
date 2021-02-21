package 牛客机试;
import java.util.*;

public class SortRandomNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            TreeSet<Integer> set = new TreeSet<>();
            int size = scanner.nextInt();
            if(size > 0) {
                for(int i  = 0; i < size; i++) {
                    set.add(scanner.nextInt());
                }
            }
            for(int i : set) {
                System.out.println(i);
            }
        }
    }
}
