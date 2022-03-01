class Solution {
    List<List<Integer>> ret;
    int n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ret = new ArrayList<>();
        n = nums.length;
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0);
        return ret;
    }
    
    public void dfs(int[] nums, List<Integer> cur, int idx) {
        ret.add(new ArrayList<>(cur));
        if (idx==n) return;
        
        for (int i=idx; i<n; i++) {
            // 1,2,2,2,2,2
            if (i>idx && nums[i]==nums[i-1]) continue;
            cur.add(nums[i]);
            dfs(nums, cur, i+1);
            cur.remove(cur.size()-1);
        }
    }
}