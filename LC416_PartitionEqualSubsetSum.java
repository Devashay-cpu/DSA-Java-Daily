import java.util.*;

class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        // Odd total sum cannot be divided equally
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        // dp[j] = whether sum j can be formed
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Traverse backwards so each number is used only once
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
