package String;

import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
        String s = "aaabbcccd";
        char[] chars = {'a', 'a', 'b', 'b', 'c'};
        String ans = compressString(s);
        char[] ans1 = compressString(chars);

        System.out.println(Arrays.toString(ans1));


        System.out.println(ans);

    }

    private static char[] compressString(char[] chars) {

        int inx = 0;

        if (chars == null || chars.length == 0) {
            return new char[]{};
        }

        int n = chars.length;

        for (int i = 0; i < n; i++) {
            int cnt = 1;

            while (i < n - 1 && chars[i] == chars[i + 1]) {
                cnt++;
                i++;
            }

            chars[inx++] = chars[i];

            if (cnt > 1) {
                for (char c : String.valueOf(cnt).toCharArray())
                    chars[inx++] = c;
            }
        }
        char[] result = new char[inx];
        System.arraycopy(chars, 0, result, 0, inx);

        return result;
    }

    private static String compressString(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        int n = str.length();
        StringBuilder stringBuilder = new StringBuilder();


        for (int i = 0; i < n; i++) {
            Integer count = 1;

            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            stringBuilder.append(str.charAt(i));

            if (count > 0) {
                stringBuilder.append(count);
            }
        }
        return stringBuilder.toString();
    }
}
