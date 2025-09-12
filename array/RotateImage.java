package array;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[][] ans = rotateImageBy90Degree(matrix);
        System.out.println(Arrays.deepToString(ans));
    }


    // Optimal Approach
    private static int[][] rotateImageBy90Degree(int[][] matrix) {
        int n = matrix.length;

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

        return matrix;
    }

    // Brute approach
//    private static int[][] rotateImageBy90Degree(int[][] matrix) {
//        int n = matrix.length;
//        int[][] rotatedMatrix = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                rotatedMatrix[j][n - 1 - i] = matrix[i][j];
//            }
//        }
//
//        return rotatedMatrix;
//
//    }
}
