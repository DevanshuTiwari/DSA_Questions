package array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int ans = maxWater(heights);
        System.out.println(ans);
    }

    private static int maxWater(int[] heights) {
        int res = Integer.MIN_VALUE;
        int i = 0, j = heights.length - 1;

        while (i < j) {
            int area = Math.min(heights[i], heights[j]) * (j - i);
            res = Math.max(res, area);

            if (heights[i] <= heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return res;
    }
}