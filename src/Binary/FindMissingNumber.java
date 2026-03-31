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

    // Using XOR: XOR of all numbers from 1 to n and XOR of all elements in the array will give the missing number.
    int optimal2(int[] arr){
        int xor1=0,xor2=0;
        int n=arr.length+1;
        for(int i=0;i<arr.length;i++){
            xor1^=arr[i];
        }
        for(int i=1;i<=n;i++){
            xor2^=i;
        }
        return xor1^xor2;
    }

    public static void main(String[] args) {
        FindMissingNumber obj=new FindMissingNumber();
        int[] arr={1,2,3,4,6};
        System.out.println(obj.optimal1(arr));
        System.out.println(obj.optimal2(arr));
    }
}
