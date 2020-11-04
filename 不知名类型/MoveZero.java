package 不知名类型;

/*
将所有0移动至前面或者后面。只在原数组上面进行改动。
 */

/*
使用快慢指针，先将所有非0都安放好
快指针定位到非0的元素，慢指针每记录一次非0元素往后（前）移动一个。
最后将慢指针之后（之前）的补零。
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] a = {80,0, 5, 0, 134, 0, 3, 6, 5, 0, 7, 0};
        int[] res = Move(a);
        for(int i : res) {
            System.out.print(i +",");
        }
        System.out.println();
        res = moveZeroes(a);
        for(int i : res) {
            System.out.print(i +",");
        }
    }

    //0后移
    public static int[] moveZeroes(int[] num) {
        int fast = 0, slow = 0;
        while(fast != num.length) {
            if(num[fast] != 0) {
                num[slow] = num[fast];
                slow++;
            }
            fast++;
        }
        while(slow != num.length) {
            num[slow] = 0;
            slow++;
        }
        return num;
    }

    //0前移
    public static int[] Move(int[] a) {
        int fast = a.length - 1, slow = a.length - 1;
        //boolean has0 = false;
        while(fast != -1) {
            if(a[fast] != 0) {
                a[slow] = a[fast];
                slow--;
            }
            fast--;
        }
        while(slow != -1) {
            a[slow] = 0;
            slow--;
        }
        return a;
    }
  }
