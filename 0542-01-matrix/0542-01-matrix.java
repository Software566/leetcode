class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int [][]directions = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});

                }else{
                    mat[i][j] = -1;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
           

            for(int[] dir : directions ){
                int newX = curr[0] + dir[0];
                int newY = curr[1] + dir[1];

                if(newX >= 0 &&  newX < m && newY >= 0 && newY < n && mat[newX][newY] == -1){
                    mat[newX][newY] = mat[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{newX,newY});
                }
            }


        }
        return mat;
        
    }
}