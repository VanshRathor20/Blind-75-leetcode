package Binary;

public class SumofTwoIntegers {
    public int getSum(int a,int b){
        int carry=(a&b)<<1;
        int sum=a^b;
        while(carry!=0){
            int newCarry=(sum & carry)<<1;
            sum=sum^carry;
            carry=newCarry;
        }
        return sum;
    }

    public static void main(String[] args) {
        SumofTwoIntegers sumofTwoIntegers=new SumofTwoIntegers();
        int a=5;
        int b=3;
        int result=sumofTwoIntegers.getSum(a,b);
        System.out.println("The sum of "+a+" and "+b+" is: "+result);
    }

}
