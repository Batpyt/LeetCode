package 牛客机试;

import java.util.Scanner;

public class CountFourElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String str = scan.nextLine();
            int countletter = 0, countspace = 0, countnum = 0, countother = 0;
            for(char c : str.toCharArray()) {
                if(Character.isLetter(c)) countletter++;
                else if(Character.isSpaceChar(c)) countspace++;
                else if(Character.isDigit(c)) countnum++;
                else countother++;
            }
            System.out.println(countletter);
            System.out.println(countspace);
            System.out.println(countnum);
            System.out.println(countother);
        }
    }
}
