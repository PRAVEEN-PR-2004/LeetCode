class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int current_max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            current_max = Math.max(current_max, current);
        }
        return current_max;
    }

    public static void main(String[] args) {
        MaxSubarray solution = new MaxSubarray();
        
        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + solution.maxSubArray(nums1)); // Output: 6

        // Test case 2
        int[] nums2 = {1};
        System.out.println("Maximum Subarray Sum: " + solution.maxSubArray(nums2)); // Output: 1

        // Test case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Maximum Subarray Sum: " + solution.maxSubArray(nums3)); // Output: 23
    }
}
