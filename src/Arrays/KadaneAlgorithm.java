package Arrays;

public class KadaneAlgorithm {
    public int maximumSubArray(int[] arr){
        int n=arr.length;
        int maxSum=Integer.MIN_VALUE;
        int currentSum=0;
        for(int i=0;i<n;i++) {
            currentSum += arr[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        KadaneAlgorithm obj=new KadaneAlgorithm();
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        int res=obj.maximumSubArray(arr);
        System.out.println(res);
    }
}
