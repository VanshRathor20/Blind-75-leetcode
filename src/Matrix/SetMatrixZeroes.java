package Matrix;

public class SetMatrixZeroes {
    //Brute Force Approach
    int n;
    int m;
    private void markRow(int[][] matrix,int row){
        for(int col=0;col<m;col++){
            if(matrix[row][col]!=0){
                matrix[row][col]=-1;
            }
        }
    }
    private void markCol(int[][] matrix,int col){
        for(int i=0;i<n;i++){
            if(matrix[i][col]!=0){
                matrix[i][col]=-1;
            }
        }
    }
    public void setZeroBrute(int[] [] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        n = matrix.length;
        m = matrix[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    markRow(matrix,i);
                    markCol(matrix,j);  
                }
            }
        }     
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
                 
            }
        }
    }

    //Optimal Approach
    public void setZeroBetter(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] rowZero=new boolean[n];
        boolean[] colZero=new boolean[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    rowZero[i]=true;
                    colZero[j]=true;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rowZero[i] || colZero[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
            int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
            SetMatrixZeroes smz = new SetMatrixZeroes();
//            smz.setZeroBrute(matrix);
            smz.setZeroBetter(matrix);
             for(int i=0;i<matrix.length;i++) {
                 for (int j = 0; j < matrix[0].length; j++) {
                     System.out.print(matrix[i][j] + " ");
                 }
                 System.out.println();
             }
    }
}
