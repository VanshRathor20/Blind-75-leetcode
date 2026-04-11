package Arrays;

import java.util.*;

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

    //better approach using sorting and two pointers
    public List<List<Integer>> threeSum(int[] arr, int n) {
        // Store unique triplets
        Set<List<Integer>> ans = new HashSet<>();
        // First loop for first element
        for (int i = 0; i < n; i++) {
            // Set to store elements seen in this iteration
            Set<Integer> hashset = new HashSet<>();
            // Second loop for second element
            for (int j = i + 1; j < n; j++) {
                // Calculate third element needed
                int third = -(arr[i] + arr[j]);
                // If third already in set, we found a triplet
                if (hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    Collections.sort(temp);
                    ans.add(temp);
                }
                // Add current element to set
                hashset.add(arr[j]);
            }
        }
        // Convert set to list
        return new ArrayList<>(ans);
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
