class Solution {

    public int findCircleNum(int[][] isConnected) {
       int n = isConnected.length;
       boolean[] visited = new boolean[n];
       int count =0;

       for(int i=0;i<n;i++){
        if(!visited[i]){
            bfs(isConnected,visited,i);
            count++;
        }
       }
       return count;

    }

    public void bfs(int[][] isConnected, boolean[] visited,int city){
        Queue<Integer> queue =  new LinkedList<>();
        queue.offer(city);
        visited[city] = true;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int j=0;j < isConnected.length;j++){
                if(isConnected[curr][j]  == 1 && !visited[j]){
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
        
    }
}