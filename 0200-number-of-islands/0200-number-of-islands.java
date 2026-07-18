class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int island=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    bfs(grid,i,j);
                    island++;

                }

            }
        }
        return island;
        
    }
    private void bfs(char[][] grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        grid[i][j] = '0';

        int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x =  curr[0],y=curr[1];

            for(int[] dir : directions){
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY]== '1'){
                    queue.add(new int[]{newX,newY});
                    grid[newX][newY] = '0';
                }
            }


        }


        
    }
}