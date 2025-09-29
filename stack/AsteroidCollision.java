package stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {10,2,-5};
        int[] ans = asteroidCollision(asteroids);

        System.out.println(Arrays.toString(ans));
    }

    private static int[] asteroidCollision(int[] asteroids){
        if(asteroids == null || asteroids.length == 0) {
            assert asteroids != null;
            return new int[asteroids.length];
        }

        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for(int ast : asteroids){
            boolean collide = false;
            while(!st.isEmpty() && ast < 0 && st.peek() > 0){
                int prev = st.peek();

                if(Math.abs(ast) > prev){
                    st.pop();
                    continue;
                } else if(Math.abs(ast) == prev){
                    st.pop();
                    collide = true;
                } else{
                    collide = true;
                }

                break;
            }

            if (!collide) {
                st.push(ast);
            }
        }

        int[] result = new int[st.size()];
        for(int i = st.size() - 1; i >= 0; i--){
            result[i] = st.pop();
        }

        return result;
    }
}
