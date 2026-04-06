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

    public static void main(String[] args) {
        ProductofArrayExceptSelf obj=new ProductofArrayExceptSelf();
        int[] nums={1,2,3,4};
        int[] res=obj.better(nums);
        for(int i:res){
            System.out.print(i+" ");
        }
    }

}
