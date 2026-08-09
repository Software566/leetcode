class Solution {
    public long maxPairStrength(int[] nums) {
        int n = nums.length;
        long ans = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long g = gcd(nums[i],nums[j]);
                long strength = (1L * nums[i] * nums[j]) / (g * g);
                ans  = Math.max(ans,strength);
            }
        }
        return ans;
    }
    private long gcd (long a,long b){
        while(b != 0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;

    }
}