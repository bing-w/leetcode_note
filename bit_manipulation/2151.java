class Solution {
    public int maximumGood(int[][] statements) {
        int m = statements.length;
        for (int k=m; k>=1; k--) {
            int state = (1 << k) - 1;            
            while (state < (1 << m))
            {
                // System.out.println(state+"+"+k);
                if(check(state, statements)) {
                    // System.out.println("SSS");
                    return k;
                }

                int c = state & - state;
                int r = state + c;
                state = (((r ^ state) >> 2) / c) | r;
            }
        }
        return 0;
    }
    
    public boolean check(int state, int[][] statements) {
        int n = statements.length;
        int[] judge = new int[n];
        Arrays.fill(judge, -1);
        for (int i=0; i<n; i++) {
            int cur = ((state>>i)&1);
            if (cur==0) continue;
            for (int j=0; j<n; j++) {
                if (statements[n-1-i][j] == 2) continue;
                if (judge[j] == -1) {
                    judge[j] = statements[n-1-i][j];
                } else if (judge[j] != statements[n-1-i][j]) {
                    return false;
                }
            }
        }
        
        for (int i=0; i<n; i++) {
            int cur = (state>>i)&1;
            if (cur==1 && judge[n-1-i]==0) {
                // System.out.println(judge[n-1-i]+"+"+state+"+"+(n-1-i));
                return false;
            }
            if (cur==0 && judge[n-1-i]==1){
                return false;
            }
        }
        return true;
    }
}