class Solution {
    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        long result = 1;

        for (int i = b.length - 1; i >= 0; i--) {
            result = (result * power(a, b[i])) % MOD;
            a = power(a, 10);
        }

        return (int) result;
    }

    private int power(long a, int n) {
        long result = 1;

        while (n > 0) {
            if ((n & 1) == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            n >>= 1;
        }

        return (int) result;
    }
}