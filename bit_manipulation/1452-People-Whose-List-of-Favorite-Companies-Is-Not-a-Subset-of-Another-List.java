class Solution {
    public List<Integer> peopleIndexes(List<List<String>> f) {
        Map<String, BitSet> map = new HashMap<>();
        for (int i=0; i<f.size(); i++) {
            for (int j=0; j<f.get(i).size(); j++) {
                map.putIfAbsent(f.get(i).get(j), new BitSet(100));
                map.get(f.get(i).get(j)).set(i);
            }
        }
        
        List<Integer> ret = new ArrayList<>();
        for (int i=0; i<f.size(); i++)
        {
            BitSet bs = new BitSet(100);
            bs.set(0,100);
            
            for (String c: f.get(i)) 
            {
                bs.and(map.get(c));
            }
            if (bs.cardinality()==1)
                ret.add(i);
        }
        return ret;    
    }
}