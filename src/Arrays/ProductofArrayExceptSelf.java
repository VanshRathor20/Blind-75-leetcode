package Arrays;

public class ProductofArrayExceptSelf {
    public int[] better(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int product=1;
        for(int i=0;i<n;i++){
            product*=nums[i];
        }
        for(int i=0;i<n;i++){
            res[i]=product/nums[i];
        }
        return res;

    }

    //optimal
    public int[] optimal(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        int product=1;
        for(int i=n-1;i>=0;i--){
            res[i]=res[i]*product;
            product*=nums[i];
        }
        return res;

    }

    public static void main(String[] args) {
        ProductofArrayExceptSelf obj=new ProductofArrayExceptSelf();
        int[] nums={1,2,3,4};
        int[] res=obj.optimal(nums);
        for(int i:res){
            System.out.print(i+" ");
        }
    }

}
