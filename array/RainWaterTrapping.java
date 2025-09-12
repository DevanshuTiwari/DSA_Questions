package array;

public class RainWaterTrapping {
    public static void main(String[] args) {
        int[] height = {3, 0, 0, 2, 0, 4};
        int ans = maxWater(height);

        System.out.println(ans);
    }

    private static int maxWater(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        maxRight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        int[] water = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            water[i] = Math.min(maxLeft[i], maxRight[i]) - height[i];
            sum += water[i];
        }
        return sum;
    }
}
