class Solution {

    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n];

        // Worst case: i cuts for first i+1 characters
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }

        for (int center = 0; center < n; center++) {

            // Odd length palindrome
            expand(s, center, center, dp);

            // Even length palindrome
            expand(s, center, center + 1, dp);
        }

        return dp[n - 1];
    }

    private void expand(String s, int left, int right, int[] dp) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            if (left == 0) {
                dp[right] = 0;
            } else {
                dp[right] = Math.min(
                    dp[right],
                    dp[left - 1] + 1
                );
            }

            left--;
            right++;
        }
    }
}