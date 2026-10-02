class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxlen = 0;
        int left =0;
        int zero =0;


        for(int right =0;right<n;right++){
            if(nums[right] == 0){
                zero++;
            }
            while(zero > k){
                if(nums[left] == 0){
                    zero--;
                }
                left++;
            }
            maxlen = Math.max(maxlen,right-left+1);


        }
        return maxlen;
    }
}