class Solution {
    List<List<Integer>> ret;
    int[] visited;
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        ret = new ArrayList<>();
        // visited = new int[n];
        // Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0);
        return ret;
    }
    
    public void dfs(int[] nums, List<Integer> cur, int idx) {
        ret.add(new ArrayList<>(cur));
        // if (idx == n) return;
        
        
        
        for (int i=idx; i<n; i++) {
            // if (visited[i] == 1) continue;
            // visited[i] = 1;
            cur.add(nums[i]);
            dfs(nums, cur, i+1);
            // visited[i] = 0;
            cur.remove(cur.size()-1);
        }
    }
}