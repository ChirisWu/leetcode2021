package lt23.spiralOrder;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @by ：chiris
 * @when ：Created in 2021-03-23
 */
class Solution {
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0){
            return null;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int res[] = new int[row * col];
        int visitedCount = 0;
        boolean visited[][] = new boolean[row + 1][col + 1];
        int [][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int directionsCorsur = 0;
        while(visitedCount < row * col){
            visited[x][y] = true;
            res[visitedCount++] = matrix[x][y];
            int nextX = directions[directionsCorsur][0] + x;
            int nextY = directions[directionsCorsur][1] + y;
            if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col || visited[nextX][nextY]){
                directionsCorsur = (directionsCorsur + 1) % 4;
                x = directions[directionsCorsur][0] + x;
                y = directions[directionsCorsur][1] + y;
                continue;
            }
            x = nextX;
            y = nextY;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3,}, {4, 5, 6}, {7, 7, 9}};
        int[] res = spiralOrder(matrix);
        System.out.println(Arrays.toString(res));
        HashSet<Integer> set = new HashSet<>();
    }
}