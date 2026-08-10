class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 1;
        int right = 0;

        for(int weight : weights){
            left = Math.max(left,weight);
            right += weight;

        }
        while(left < right){
            int mid = left + (right-left)/2;
            if(canShip(weights,days,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;



        
    }
    private boolean canShip(int[] weights,int days,int capacity){
        int dayNeeded = 1;
        int currentWeight = 0;

        for(int weight : weights){
            if(currentWeight + weight <= capacity){
                currentWeight += weight;
            }else{
                dayNeeded++;
                currentWeight = weight;
            }
        }
        return dayNeeded <= days;
    }
}