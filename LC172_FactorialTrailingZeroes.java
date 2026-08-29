class LC172_FactorialTrailingZeroes {

    public static int trailingZeroes(int n) {
        int count = 0;

        while (n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 25;

        System.out.println(trailingZeroes(n));
    }
}