package Binary;

public class Numberof1Bits {
    public int hammingWeight(int n){
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
        Numberof1Bits numberof1Bits=new Numberof1Bits();
        int n=11;
        System.out.println(numberof1Bits.hammingWeight(n));
    }
}
