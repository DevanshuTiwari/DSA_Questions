package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = uniqueTripletSum(arr);

        System.out.println(ans);
    }

    private static List<List<Integer>> uniqueTripletSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> uniqueTriplets = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue; // condition for uniqueness

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    uniqueTriplets.add(Arrays.asList(arr[i], arr[j], arr[k]));


                    while (j < k && arr[j] == arr[j + 1]) j++;
                    while (j < k && arr[k] == arr[k - 1]) k--;

                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }

        }

        return uniqueTriplets;
    }
}
