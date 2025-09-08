package String;

public class PatternMatching {
    public static void main(String[] args) {
        String s1 = "sadbutsad";
        String s2 = "but";

        int idx = strStr(s1, s2);

        System.out.println(idx);
    }

    private static int strStr(String a, String b) {
        int n = a.length();
        int m = b.length();

        if (m == 0) return 0;

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && a.charAt(i + j) == b.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}
