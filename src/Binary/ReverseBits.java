package Binary;

public class ReverseBits {
    int reverseBits(int n){
        if(n==0) return 0;
        int result=0;
        for(int i=0;i<32;i++){
            result<<=1;
            result=result | (n&1);
            n>>=1;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits obj=new ReverseBits();
        int n=43261596;
        System.out.println(obj.reverseBits(n));
    }
}