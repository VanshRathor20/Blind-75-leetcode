package Matrix;

public class RotateMatrixBy90Degrees {

    //brute
     public int[][] rotateBrute(int[][] matrix) {
         int n = matrix.length;
         int[][] rotated = new int[n][n];
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 rotated[j][n-i-1] = matrix[i][j];
             }

         }
         return rotated;
     }

    //optimal approach: first transpose the matrix and then reverse each row
    public void rotate(int[][] matrix) {
        int n =matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //reverse row
        for(int i=0;i<n;i++){
            int left=0,right=n-1;
            while(left<right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        RotateMatrixBy90Degrees obj = new RotateMatrixBy90Degrees();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        obj.rotateBrute(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
