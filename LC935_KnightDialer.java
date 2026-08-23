public class LC935_KnightDialer {

    public static int knightDialer(int n) {

        int MOD = 1_000_000_007;

        int[][] moves = {
            {4, 6},       // 0
            {6, 8},       // 1
            {7, 9},       // 2
            {4, 8},       // 3
            {0, 3, 9},    // 4
            {},           // 5
            {0, 1, 7},    // 6
            {2, 6},       // 7
            {1, 3},       // 8
            {2, 4}        // 9
        };

        long[] dp = new long[10];

        // One-digit numbers
        for (int i = 0; i < 10; i++) {
            dp[i] = 1;
        }

        for (int step = 1; step < n; step++) {

            long[] next = new long[10];

            for (int digit = 0; digit < 10; digit++) {

                for (int nextDigit : moves[digit]) {
                    next[nextDigit] =
                            (next[nextDigit] + dp[digit]) % MOD;
                }
            }

            dp = next;
        }

        long answer = 0;

        for (long count : dp) {
            answer = (answer + count) % MOD;
        }

        return (int) answer;
    }

    public static void main(String[] args) {

        System.out.println(knightDialer(1));
        System.out.println(knightDialer(2));
        System.out.println(knightDialer(3));
    }
}
