package Arrays;

public class TwoSum {
    public int[] twoSum(int[] arr,int T){
        int i=0,j=arr.length-1;
        while (i<j){
            int sum=arr[i]+arr[j];
            if(sum==T) return new int[]{i,j};
            else if(sum<T) i++;
            else j--;
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] arr = {1,2,3,4,5,6};
        int T = 7;
        int[] result = ts.twoSum(arr, T);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }

}
