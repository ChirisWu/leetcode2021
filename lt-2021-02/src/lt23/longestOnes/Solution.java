package lt23.longestOnes;

/**
 * @by ：chiris
 * @when ：Created in 2021-02-23
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0, maxCount = 0;
        for (int i = 0; i < n; ++i){
            if (nums[i] == 1){
                count ++;
            }else{
                maxCount = Math.max(maxCount, count);
                count = 0;

            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}
