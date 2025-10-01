package stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        int ans = carFleet(target, position, speed);
        System.out.println(ans);
    }

    private static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n <= 1) return n;

        double[][] cars = new double[n][2]; // position and arrival time
        Stack<Double> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        for (double[] car : cars) {
            double arrivalTime = car[1];

            if (st.isEmpty() || arrivalTime > st.peek()) {
                st.push(arrivalTime);
            }
        }


        return st.size();

        // without stack
//        int n = position.length;
//        if (n <= 1) {
//            return n;
//        }
//
//
//        double[][] cars = new double[n][2];
//        for (int i = 0; i < n; i++) {
//            cars[i][0] = position[i];
//            cars[i][1] = (double)(target - position[i]) / speed[i];
//        }
//
//
//        Arrays.sort(cars, Comparator.comparingDouble(a -> -a[0]));
//
//
//        int fleetCount = 0;
//        double lastFleetTime = -1.0;
//
//
//        for (int i = 0; i < n; i++) {
//            double arrivalTime = cars[i][1];
//
//            if (arrivalTime > lastFleetTime) {
//                fleetCount++;
//                lastFleetTime = arrivalTime;
//            }
//        }
//
//        return fleetCount;
    }
}
