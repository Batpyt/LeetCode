package 排序;

import java.util.Arrays;
/*
现在有一个特殊的排名系统，依据参赛团队在投票人心中的次序进行排名，每个投票者都需要按从高到低的顺序对参与排名的所有团队进行排位。

排名规则如下：

参赛团队的排名次序依照其所获「排位第一」的票的多少决定。如果存在多个团队并列的情况，将继续考虑其「排位第二」的票的数量。以此类推，直到不再存在并列的情况。
如果在考虑完所有投票情况后仍然出现并列现象，则根据团队字母的字母顺序进行排名。
给你一个字符串数组 votes 代表全体投票者给出的排位情况，请你根据上述排名规则对所有参赛团队进行排名。

请你返回能表示按排名系统 排序后 的所有团队排名的字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rank-teams-by-votes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class RankTeam {
    public static void main(String[] args) {
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        System.out.println(rankTeams(votes));

    }

    /*
    建立二维数组来记录每组在各个排名上所获得的分数。
    再通过自定义排序来排序每个组
     */
    public static String rankTeams(String[] votes) {
        int len = votes.length;

        if(len == 1) return votes[0];

        //一共有多少个组
        int size = votes[0].length();

        //记录组在每个排名上所得的分数
        //26行，每行时一组，第一列为组号
        int[][] m = new int[26][size + 1];
        for(int i = 0; i < 26; i++) {
            m[i][0] = i;
        }

        //记录每组在每个排名上的分数，
        for(String str : votes) {
            for(int i = 0; i < size; i++) {
                //str.charAt(i) - 'A'：定位到该投票结果第i名的组。
                m[str.charAt(i) - 'A'][i + 1]++;
            }
        }

        /*
        源码中写作(a, b) => a - b
        Arrays.sort(arr, (a, b) -> a - b)
        是对数组进行冒泡排序
        如果 a - b>0 则b在前 a在后、直到有序
        意味着：返回正数的话b在前
         */
        Arrays.sort(m, (a, b) -> {
            for(int i = 1; i < a.length; i++){
                //从第一名所得票数开始排序
                if(a[i] < b[i]){ //b在该位置的票数大于a，b在前，返回正数
                    return 1;
                }else if(a[i] > b[i]){//b在后，返回负数
                    return -1;
                }
            }
            //当a，b得票数完全相同时，根据字母排序，若a的字母顺序在前，a在前。
            return a[0] - b[0];//a在前是，返回负数，b相反
        });

        /*
        生成结果
        按顺序将已排序好的各组第一列转成组名输出
        由于未出现的组名票数都为0，所有都在最后
        visited记录已生成多少组，生成完后便跳出循环
         */
        StringBuilder sb = new StringBuilder();
        int visited = 0;
        for(int[]arr : m) {
            sb.append((char)(arr[0] + 'A'));
            visited++;
            if(visited == size) break;
        }

        return sb.toString();
    }
}
