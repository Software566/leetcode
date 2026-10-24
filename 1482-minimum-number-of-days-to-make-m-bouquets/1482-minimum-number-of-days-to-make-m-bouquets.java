class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m * k > bloomDay.length){
            return -1;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for(int bloom :bloomDay){
            left = Math.min(left,bloom);
            right = Math.max(right,bloom);
        }
        while(left < right){
            int mid = left + (right-left)/2;
            if(canMake(bloomDay, m,k,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
        
    }
    
    private boolean canMake(int[] bloomDay, int m, int k, int day) {

    int bouquets = 0;
    int flowers = 0;

    for (int bloom : bloomDay) {

        if (bloom <= day) {
            flowers++;

            if (flowers == k) {
                bouquets++;
                flowers = 0;
            }

        } else {
            flowers = 0;
        }

        if (bouquets >= m) {
            return true;
        }
    }

    return false;
}
}