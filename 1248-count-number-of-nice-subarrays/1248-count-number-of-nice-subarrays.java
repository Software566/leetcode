class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,1);
        int n = nums.length;
        int count = 0;
        int sum=0;
        


        for(int right=0;right<n;right++){
            sum += nums[right] % 2;
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);

        
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            
        }
        return count;
    
    }
}