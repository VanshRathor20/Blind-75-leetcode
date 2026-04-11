package Arrays;

public class ThreeSum {
    public int[] findSum(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if(arr[i]+arr[j]+arr[k]==target){
                        return new int[] {arr[i],arr[j],arr[k]};
                    }
                }
            }
        }
        return new int[] {-1,-1,-1};
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] arr = {1,2,3,4,5,6};
        int target = 10;
        int[] result = threeSum.findSum(arr,target);
        if(result[0]!=-1){
            System.out.println("Triplet found: "+result[0]+", "+result[1]+", "+result[2]);
        }else{
            System.out.println("No triplet found.");
        }
    }
}
