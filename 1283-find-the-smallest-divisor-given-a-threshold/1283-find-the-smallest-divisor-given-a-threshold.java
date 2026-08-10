class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int left = 1;
        int right = 1;

        for(int num : nums){
             right = Math.max(right,num);
            
        }
        

        while(left <= right){
            int mid = left + (right-left)/2;
            if(canDivide(nums,threshold,mid)){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return left;
        
    }
    private boolean canDivide(int[]nums,int threshold,int divisor){
        int sum = 0;
        for(int num : nums){
            sum += (num + divisor-1)/divisor;
        }
        return sum <= threshold;

    }
}