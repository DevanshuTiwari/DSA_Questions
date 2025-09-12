package string;

public class ReverseVowels {
    public static void main(String[] args) {
        String s = "IceCreAm";
        String ans = reverseVowel(s);

        System.out.println(ans);
    }

    private static String reverseVowel(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int i = 0, j = s.length() - 1;
        StringBuilder str = new StringBuilder(s);

        while (i < j) {
            if (!isVowel(s.charAt(i))) {
                i++;
            }

            if (!isVowel(s.charAt(j))) {
                j--;
            }

            if (isVowel(s.charAt(i)) && isVowel(s.charAt(j))) {
                char temp = str.charAt(i);
                str.setCharAt(i, str.charAt(j));
                str.setCharAt(j, temp);

                i++;
                j--;

            }
        }

        return str.toString();
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
