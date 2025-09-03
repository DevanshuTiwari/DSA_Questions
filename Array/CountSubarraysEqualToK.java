package Array;

import java.util.HashMap;

public class CountSubarraysEqualToK {
    public static void main(String[] args) {
        int[] arr = {9, 4, 20, 3, 10, 5};
        int k = 33;

        int ans = countSubarrays(arr, k);
        System.out.println(ans);
    }

    // Optimal Approach - O(N)
    private static int countSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int count = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) count++;

            if (mpp.containsKey(sum - k)) {
                count += mpp.get(sum - k);
            }

            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);
        }

        return count;
    }


    // Brute approach - O(N^2)
//    private static int countSubarrays(int[] arr, int k) {
//        int res = 0;
//        int n = arr.length;
//
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum += arr[j];
//
//                if (sum == k) {
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
}
