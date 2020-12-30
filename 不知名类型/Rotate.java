package 不知名类型;

/**
 *
 给定一个 n × n 的二维矩阵表示一个图像。

 将图像顺时针旋转 90 度。

 说明：

 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

 示例 1:

 给定 matrix = 
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],

 原地旋转输入矩阵，使其变为:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]
 */
public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        rotate(matrix);

        for(int[] m : matrix) {
            for(int i : m) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /*
    [ 5, 1, 9,11],
    [ 2, 4, 8,10],
    [13, 3, 6, 7],
    [15,14,12,16]

    上下翻转：
    15 14 12 16
    13  3  6  7
    2   4  8 10
    5   1  9 11
    
    右上左下翻转：
    [15,13, 2, 5],
    [14, 3, 4, 1],
    [12, 6, 8, 9],
    [16, 7,10,11]
     */
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        //上下翻转
        for(int i = 0; i < length / 2; i++) {
            for(int j = 0; j < length; j++) {
                //System.out.println(i +" "+ j +" "+matrix[i][j]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - i][j];
                matrix[length - 1 - i][j] = temp;
            }
        } 
        //右上左下翻转
        for(int i = 0; i < length; i++) {
            for(int j = i; j < length; j++) {
                //System.out.println(matrix[i][j] + " " + matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


}
