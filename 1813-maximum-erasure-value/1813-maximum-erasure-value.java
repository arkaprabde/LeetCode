class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int s = 0, mx = 0;
        for (int l = 0, h = 0; h < nums.length; h++) {
            s += nums[h];
            while (mp.containsKey(nums[h])) {
                mp.put(nums[l], mp.get(nums[l]) - 1);
                if (mp.get(nums[l]) == 0) mp.remove(nums[l]);
                s -= nums[l++];
            }
            mp.put(nums[h], 1);
            mx = Math.max(mx, s);
        }
        return mx;
    }
}