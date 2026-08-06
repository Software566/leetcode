class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        
        for(int weight : weights){
            left = Math.max(left,weight);
            right += weight;
        }
        while(left < right){
            int mid = left + (right-left)/2;
            if(canShip(days,weights,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
        
    }
    private  boolean canShip(int days,int[] weights,int capacity){
        int daysNeeded = 1;
        int currentWeight = 0;

        for(int weight : weights ){
            if(currentWeight + weight <= capacity){
                currentWeight += weight;
            }else{
                daysNeeded++;
                currentWeight = weight;
            }
        }
        return daysNeeded <= days;


    }

}