package string;


public class SortVowels {
    public static void main(String[] args) {
        String s = "lEetcOde";

        String ans = sortVowels(s);
        System.out.println(ans);
    }

    public static String sortVowels(String s) {
        int[] vowelCount = new int[128];

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowelCount[c]++;
            }
        }

        int vowelIndex = 0;
        StringBuilder str = new StringBuilder(s);
        String sortedVowelChars = "AEIOUaeiou";

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {

                while (vowelCount[sortedVowelChars.charAt(vowelIndex)] == 0) {
                    vowelIndex++;
                }

                str.setCharAt(i, sortedVowelChars.charAt(vowelIndex));
                vowelCount[sortedVowelChars.charAt(vowelIndex)]--;
            }
        }

        return str.toString();
// ------------------------------------------------------------------------------------------------------------------------------------

        // List<Character> vowels = new ArrayList<>();

        // for(char c : s.toCharArray()){
        //     if(isVowel(c)){
        //         vowels.add(c);
        //     }
        // }

        // Collections.sort(vowels);

        // int vowelIndex = 0;
        // StringBuilder str = new StringBuilder(s);
        // for(int i  = 0; i < s.length(); i++){
        //     if(isVowel(s.charAt(i))){
        //         str.setCharAt(i,vowels.get(vowelIndex));
        //         vowelIndex++;
        //     }
        // }

        // return str.toString();

    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
