class Solution {
    public int specialTriplets(int[] nums) {
         int MOD = 1_000_000_007;
        Map<Integer, Integer> countBefore = new HashMap<>();
        Map<Integer, Integer> countAfter = new HashMap<>();
        
        // Count frequency of all elements for "after"
        for (int num : nums) {
            countAfter.put(num, countAfter.getOrDefault(num, 0) + 1);
        }
        
        long result = 0;
         for (int j = 0; j < nums.length; j++) {
            int val = nums[j];
            
            // Remove current element from countAfter
            countAfter.put(val, countAfter.get(val) - 1);
            
            int doubleVal = 2 * val;
            int before = countBefore.getOrDefault(doubleVal, 0);
            int after = countAfter.getOrDefault(doubleVal, 0);
            
            result = (result + ((long) before * after) % MOD) % MOD;
            
            // Add current element to countBefore
            countBefore.put(val, countBefore.getOrDefault(val, 0) + 1);
        }
        
        return (int) result;
    }
}
