import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> track = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (track.containsKey(x)) {
                return new int[] { track.get(x), i };
            }
            track.put(nums[i], i);
        }

        return new int[0];
    }
}
