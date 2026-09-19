import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long MOD = 1_000_000_007L;
        long result = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() &&
                   (i == n || arr[stack.peek()] >= arr[i])) {

                int mid = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();

                int right = i;

                long leftCount = mid - left;
                long rightCount = right - mid;

                result = (result +
                        (long) arr[mid] * leftCount % MOD * rightCount) % MOD;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return (int) result;
    }
}