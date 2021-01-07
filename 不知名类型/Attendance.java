package 不知名类型;

/**
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 *
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 *
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *
 * 示例 1:
 * 输入: "PPALLP"
 * 输出: True
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Attendance {
    public static void main(String[] args) {
        String s = "PPALLL";
        System.out.println(checkRecord(s));
    }

    public static boolean checkRecord(String s) {
        s = "PP" + s;
        char[] c = s.toCharArray();
        boolean isa = false;
        //if(c[0] == 'A') isa = true;
        for(int i = 2; i < c.length; i++) {
            if(c[i] == 'A') {
                if(isa) return false;
                else isa = true;
            }
            if(c[i] == 'L') {
                if(c[i - 1] == 'L' && c[i - 2] == 'L') return false;
            }
        }
        return true;
    }

    //s.lastIndexOf():最后一次出现该字符的位置
    public boolean checkRecord2(String s) {
        int i = s.indexOf('A');
        return (i == -1 || s.lastIndexOf('A') == i) && !s.contains("LLL");
    }
}
