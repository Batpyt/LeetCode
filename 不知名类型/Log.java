package 不知名类型;

public class Log {

    public static void main(String[] args) {
        String[][] input = {{"123", "AmeituanBv5.0CbaiduDandroid"}, {"124", "AmeituanBv5.0Dandroid"}};
        String[][] res = Analys(input);
        for(String[] s : res) {
            for(String ss : s) {
                System.out.print(ss+", ");
            }
            System.out.println();
        }
    }

    public static String[][] Analys(String[][] input) {
        String[][] res = new String[input.length][5];
        for(int j = 0; j < input.length; j++) {
            String id = input[j][0];
            char[] info = input[j][1].toCharArray();
            int index = 1;
            for(int i = 0; i < info.length; i++) {
                if(Character.isUpperCase(info[i])) {
                    if(info[i] == 'A') index = 1;
                    if(info[i] == 'B') index = 2;
                    if(info[i] == 'C') index = 3;
                    if(info[i] == 'D') index = 4;
                    System.out.println(info[i]);
                    StringBuilder sb = new StringBuilder();
                    while(i+1 < info.length && !Character.isUpperCase(info[i+1])) {
                        sb.append(info[i+1]);
                        i++;
                    }
                    res[j][index] = sb.toString();
                    //index++;
                }
            }
            res[j][0] = id;
        }
        return res;
    }
}
