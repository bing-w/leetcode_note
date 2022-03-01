class Solution {
    List<List<Integer>> ret;
    int[] visited;
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        ret = new ArrayList<>();
        visited = new int[n];
        dfs(nums, new ArrayList<>());
        return ret;
    }
    
    public void dfs(int[] nums, List<Integer> cur) {
        int n = nums.length;
        if (cur.size() == n) {
            ret.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i=0; i<n; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            cur.add(nums[i]);
            dfs(nums, cur);
            visited[i] = 0;
            cur.remove(cur.size()-1);
        }
    }
}