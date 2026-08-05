class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;

        for(int bananas : piles){
            right = Math.max(right, bananas);
        }
        while(left < right){
            int mid = left + (right-left)/2;

            if(canFinish(piles,h,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
        
    }
    private boolean canFinish(int[] piles,int h, int k){
        long hours = 0;
        for(int bananas : piles){
            hours += (bananas + k -1)/k;
        }
        return hours <= h;

    }
}