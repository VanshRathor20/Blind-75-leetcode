package Matrix;

public class SetMatrixZeroes {
    //Brute Force Approach
     int n;
    private void validateRectangularMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        int cols = matrix[0].length;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i] == null || matrix[i].length != cols) {
                throw new IllegalArgumentException("Matrix requires a rectangular shape.");
            }
        }
    }
    
    private void markRow(int[][] matrix,int row){
        for(int col=0;col<matrix[row].length;col++){
            if(matrix[row][col]!=0){
                matrix[row][col]=-1;
            }
        }
    }
    private void markCol(int[][] matrix,int col){
        for(int i=0;i<n;i++){
            if(matrix[i] != null && col < matrix[i].length && matrix[i][col]!=0){
                matrix[i][col]=-1;
            }
        }
    }
    public void setZeroBrute(int[] [] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        n = matrix.length;

        for(int i=0;i<n;i++){
            if (matrix[i] == null) {
                continue;
            }
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    markRow(matrix,i);
                    markCol(matrix,j);  
                }
            }
        }     
        
        for(int i=0;i<n;i++){
            if (matrix[i] == null) {
                continue;
            }
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
                 
            }
        }
    }

    //Optimal Approach
    public void setZeroBetter(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        validateRectangularMatrix(matrix);
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
            smz.setZeroBetter(matrix);
             for(int[] row : matrix) {
                 for (int val : row) {
                     System.out.print(val + " ");
                 }
                 System.out.println();
             }
    }
}
