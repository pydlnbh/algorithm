package class01;

import java.util.Arrays;

// 给定一个有序数组arr，代表坐落在X轴上的点，给定一个正数K，代表绳子的长度，返回绳子最多压中几个点？ 即使绳子边缘处盖住点也算盖住
public class Code01_CordCoverMaxPoint {
    // solution one
    public static int maxPoint1(int[] arr, int L) {
        int res = 1;

        for (int i = 0; i < arr.length; i++) {
            int nearest = nearestIndex(arr, i, arr[i] - L);
            res = Math.max(res, i - nearest + 1);
        }

        return res;
    }

    public static int nearestIndex(int[] arr, int R, int value) {
        int L = 0;
        int index = R;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return index;
    }

    // solution two
    public static int maxPoint2(int[] arr, int L) {
        int left = 0;
        int right = 0;
        int N = arr.length;
        int max = 0;
        while (left < N) {
            while (right < N && arr[right] - arr[left] <= L) {
                right++;
            }

            max = Math.max(max, right - (left++));
        }

        return max;
    }

    // test method
    public static int test(int[] arr, int L) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;

            while (pre >= 0 && arr[i] - arr[pre] <= L) {
                pre--;
            }

            max = Math.max(max, i - pre);
        }

        return max;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int length = (int) (Math.random() * maxSize) + 1;

        int[] ans = new int[length];

        for (int i = 0; i < length; i++) {
            ans[i] = (int) (Math.random() * maxValue) + 1;
        }

        Arrays.sort(ans);

        return ans;
    }

    // for test
    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;
        int testTimes = 10000;

        System.out.println("test begin");

        for (int i = 0; i < testTimes; i++) {
            int L = (int) (Math.random() * maxValue);
            int[] arr = generateRandomArray(maxSize, maxValue);

            int ans1 = maxPoint1(arr, L);
            int ans2 = maxPoint2(arr, L);
            int ans3 = test(arr, L);

            if (ans1 != ans2 || ans2 != ans3    ) {
                System.out.println("Oops");
                break;
            }
        }

        System.out.println("test end");
    }
}