package Array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int target = 9;

        int[] ans = twoSum(input, target);

        System.out.println(Arrays.toString(ans));
    }


    private static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int remaining = target - arr[i];

            if (mpp.containsKey(remaining)) {
                return new int[]{mpp.get(remaining), i};
            }
            mpp.put(arr[i], i);
        }

        return new int[]{-1, -1};
    }
}
