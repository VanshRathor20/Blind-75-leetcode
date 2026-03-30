package Binary;

public class CountingBits {
    public int[] countBits(int n){
        int[] result=new int[n+1];
        for(int i=0;i<n+1;i++){
            result[i]=hammingWeight(i);
        }
        return result;
    }

    private int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            if ((n & 1)==1) {
                count++;

            }
            n=n>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        CountingBits countingBits=new CountingBits();
        int n=5;
        int[] result=countingBits.countBits(n);
        System.out.print("The number of 1's in the binary representation of numbers from 0 to "+n+" are: ");
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
