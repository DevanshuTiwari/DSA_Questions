package array;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] input = {0, 1, 0, 3, 12};
        int[] ans = moveZerosToEnd(input);

        System.out.println(Arrays.toString(ans));
    }

    private static int[] moveZerosToEnd(int[] input) {
        int j = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0) {
                swap(input, i, j);
                j++;
            }
        }

        return input;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
