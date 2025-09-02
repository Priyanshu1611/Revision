class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row[] = new boolean[m];
        boolean col[] = new boolean[n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j]==0){
                    row[i]=true;
                    col[j] = true;
                }
            }
        }
        
        for(int i = 0;i<col.length;i++){
            if(col[i]==true){
                int j  = 0;
                while(j<row.length){
                    matrix[j][i]=0;
                    j++;
                }
            }
        }
        for(int i = 0;i<row.length;i++){
            if(row[i]==true){
                int j  = 0;
                while(j<col.length){
                    matrix[i][j]=0;
                    j++;
                }
            }
        }
    }
}