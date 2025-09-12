package array;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1};

        boolean ans = isContainsDuplicate(input);

        System.out.println(ans);
    }

    private static boolean isContainsDuplicate(int[] input) {
        HashSet<Integer> duplicatesSet = new HashSet<>();
        for (int val : input) {
            duplicatesSet.add(val);
        }

        return duplicatesSet.size() != input.length;
    }
}
