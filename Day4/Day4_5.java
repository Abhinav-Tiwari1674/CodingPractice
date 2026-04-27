
class Solution {
    public int maxSum(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (maxDigit(nums[i]) == maxDigit(nums[i + 1])) {
                max = Math.max(max, nums[i] + nums[i + 1]);
            }
        }
        return max;
    }

    private int maxDigit(int num) {
        int max = 0;
        while (num > 0) {
            int digit = num % 10;
            max = Math.max(max, digit);
            num /= 10;
        }
        return max;
    }
}