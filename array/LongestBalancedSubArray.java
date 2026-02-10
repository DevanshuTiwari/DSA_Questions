package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestBalancedSubArray {
    public static void main(String[] args) {
        int[] nums = {2, 5, 4, 3};

        int ans = longestBalanced(nums);
        System.out.println(ans);

    }

    private static int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        Set<Integer> allEvens = new HashSet<>();
        Set<Integer> allOdds = new HashSet<>();
        for (int x : nums) {
            if (x % 2 == 0) allEvens.add(x);
            else allOdds.add(x);
        }

        int maxK = Math.min(allEvens.size(), allOdds.size());

        for (int k = 1; k <= maxK; k++) {
            Map<Integer, Integer> windowMap = new HashMap<>();
            int left = 0, distEven = 0, distOdd = 0;

            for (int right = 0; right < n; right++) {
                int rVal = nums[right];
                windowMap.put(rVal, windowMap.getOrDefault(rVal, 0) + 1);

                if (windowMap.get(rVal) == 1) {
                    if (rVal % 2 == 0) distEven++;
                    else distOdd++;
                }

                while (distEven > k || distOdd > k) {
                    int lVal = nums[left];
                    windowMap.put(lVal, windowMap.get(lVal) - 1);
                    if (windowMap.get(lVal) == 0) {
                        if (lVal % 2 == 0) distEven--;
                        else distOdd--;
                        windowMap.remove(lVal);
                    }
                    left++;
                }

                if (distEven == k && distOdd == k) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
            }
        }
        return maxLen;

        // int n = nums.length;
        // int ans = 0;

        // for(int i = 0; i < n; i++) {
        //    Map<Integer, Integer> mpp = new HashMap<>();

        //     int oddCount = 0;
        //     int evenCount = 0;

        //     for(int j = i; j < n; j++) {
        //         if(!mpp.containsKey(nums[j])) {
        //             if(nums[j] % 2 == 0) {
        //                 evenCount++;
        //             } else {
        //                 oddCount++;
        //             }
        //         }

        //         mpp.put(nums[j], mpp.getOrDefault(nums[j],0) + 1);

        //         if (oddCount == evenCount) {
        //             ans = Math.max(ans, j - i + 1);
        //         }
        //     }
        // }

        // return ans;
    }
}
