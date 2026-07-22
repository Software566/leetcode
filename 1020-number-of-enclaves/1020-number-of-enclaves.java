class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int [][]directions = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0;i<m;i++){
            if(grid[i][0] == 1){
                queue.offer(new int[]{i,0});
                grid[i][0] = 0;
            }
            if(grid[i][n-1] == 1){
                queue.offer(new int[]{i,n-1});
                grid[i][n-1] = 0;
            }
            
        }

        for(int j=0;j<n;j++){
            if(grid[0][j] == 1){
                queue.offer(new int[]{0,j});
                grid[0][j] = 0;
            }
            if(grid[m-1][j] == 1){
                queue.offer(new int[]{m-1,j});
                grid[m-1][j] = 0;
            }
        }

        while(!queue.isEmpty()){
            int []curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for(int []dir : directions){
                 int newX = x + dir[0];
                 int newY = y + dir[1];

                 if(newX >= 0 && newX < m && newY >= 0 && newY < n  && grid[newX][newY] == 1){

                    queue.offer(new int[]{newX,newY});
                    grid[newX][newY] = 0;
                    
                 }

            }
         
        }
        int count = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    count++;

                }
            }
        }
        return count;
        
    }
}