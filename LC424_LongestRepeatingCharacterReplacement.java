public class LC424_LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            int index = s.charAt(right) - 'A';
            freq[index]++;

            maxFreq = Math.max(maxFreq, freq[index]);

            // Characters that need replacement
            int replacements = (right - left + 1) - maxFreq;

            while (replacements > k) {
                freq[s.charAt(left) - 'A']--;
                left++;

                replacements = (right - left + 1) - maxFreq;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        System.out.println(characterReplacement(s, k));
    }
}
