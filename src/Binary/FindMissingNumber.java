package Binary;

public class FindMissingNumber {
    int optimal1(int[] arr){
        long sum=0;
        int n=arr.length+1;
        // Iterate over existing elements only; n is one more than array length.
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        long naturalSum=(n*(n+1))/2;
        return (int)(naturalSum-sum);
    }

    public static void main(String[] args) {
        FindMissingNumber obj=new FindMissingNumber();
        int[] arr={1,2,3,4,6};
        System.out.println(obj.optimal1(arr));
    }
}
