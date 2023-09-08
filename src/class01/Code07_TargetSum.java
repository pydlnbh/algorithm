package class01;

import java.util.HashMap;

// leetcode 494题
public class Code07_TargetSum {
    // solution one
    public static int findTargetSumWays1(int[] arr, int s) {
        return process1(arr, 0, s);
    }

    public static int process1(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }

        return process1(arr, index + 1, rest - arr[index])
                + process1(arr, index + 1, rest + arr[index]);
    }

    // solution two
    public static int findTargetSumWays2(int[] arr, int s) {
        return process2(arr, 0, s, new HashMap<>());
    }

    public static int process2(int[] arr, int index, int rest, HashMap<Integer, HashMap<Integer, Integer>> dp) {
        if (dp.containsKey(index) && dp.get(index).containsKey(rest)) {
            return dp.get(index).get(rest);
        }

        int ans = 0;
        if (index == arr.length) {
            ans = rest == 0 ? 1 : 0;
        } else {
            ans = process2(arr, index + 1, rest - arr[index], dp) + process2(arr, index + 1, rest + arr[index], dp);
        }

        if (!dp.containsKey(index)) {
            dp.put(index, new HashMap<>());
        }

        dp.get(index).put(rest, ans);

        return ans;
    }

    // solution three
    public static int findTargetSumWays(int[] arr, int target) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }

        return sum < target || ((target & 1) ^ (sum & 1)) != 0 ? 0 : subset2(arr, (target + sum) >> 1);
    }

    public static int subset1(int[] nums, int s) {
        if (s < 0) {
            return 0;
        }

        int n = nums.length;
        int[][] dp = new int[n + 1][s + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][s];
    }

    public static int subset2(int[] nums, int s) {
        if (s < 0) {
            return 0;
        }

        int[] dp = new int[s + 1];
        dp[0] = 1;

        for (int n : nums) {
            for (int i = s; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }

        return dp[s];
    }
}
