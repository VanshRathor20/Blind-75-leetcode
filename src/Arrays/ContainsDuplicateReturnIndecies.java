package Arrays;

public class ContainsDuplicateReturnIndecies {
    public int[] containsDuplicate(int[] arr){
        int i=0,j=arr.length-1;
        while (i<j){
            if(arr[i]==arr[j]) return new int[]{i,j};
            else if(arr[i]<arr[j]) i++;
            else j--;
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        ContainsDuplicateReturnIndecies cd = new ContainsDuplicateReturnIndecies();
        int[] arr = {1,2,3,1};
        int[] result = cd.containsDuplicate(arr);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
