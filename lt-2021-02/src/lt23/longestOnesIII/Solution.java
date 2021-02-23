package lt23.longestOnesIII;

/**
 * @by ：chiris
 * @when ：Created in 2021-02-23
 */
class Solution {
    public int longestOnes1(int[] A, int K) {
        int n = A.length, l = 0, r = 0;
        int zeroCount = 0;
        int res = 0;
        while(r < n){
            if (A[r] == 0){
                zeroCount ++;
            }
            r ++;
            while(zeroCount > K){
                if (A[l] == 0){
                    zeroCount --;
                }
                l ++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

    public int longestOnes2(int[] A, int K) {
        int n = A.length, left = 0, lsum = 0, rsum = 0;
        int res = 0;
        for (int right = 0; right < n; ++ right){
            rsum += 1 - A[right];
            while(lsum < rsum - K){
                lsum += 1 - A[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
