class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] dp = new int[(1<<n)];
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        int[] dp2;
        dp[0] = 0;
        for (int j=0; j<n; j++) {
            dp2 = dp.clone();
            int k = j+1;
            int state = (1<<k)-1;
            while (state < (1 << n))
            {
                for (int i=0; i<n ;i++) {
                    if (((state>>i)&1)==1) {
                        dp[state] = Math.min(dp[state], dp2[state-(1<<i)]+(nums2[j]^nums1[i]));
                    }
                }

                int c = state & - state;
                int r = state + c;
                state = (((r ^ state) >> 2) / c) | r;
            }
            
            // for (int state = 1; state<(1<<n); state++) {
            //     if (Integer.bitCount(state) != j+1) continue;
            //     for (int i=0; i<n ;i++) {
            //         if (((state>>i)&1)==1) {
            //             dp[state] = Math.min(dp[state], dp2[state-(1<<i)]+(nums2[j]^nums1[i]));
            //         }
            //     }
            // }
        }
        return dp[(1<<n)-1];
    }
}