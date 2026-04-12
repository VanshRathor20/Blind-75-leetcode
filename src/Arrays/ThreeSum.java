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

    // optimal approach using sorting and two pointers
    public List<List<Integer>> threeSumOptimal(int[] arr,int target){
        Arrays.sort(arr);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i]==arr[i-1]) continue; // skip duplicates - check i>0 first
            int left=i+1, right=arr.length-1;
            while(left<right){
                int sum=arr[i]+arr[left]+arr[right];
                if(sum==target) {
                    ans.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;

                    while (left < right && arr[left] == arr[left - 1]) left++;
                    while (left < right && arr[right] == arr[right - 1]) right--;
                } else if (sum<0) {
                    left++;
                } else {
                    right--;

                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] arr = {1,2,3,4,5,6};
        int target = 10;
        List<List<Integer>> result = threeSum.threeSumOptimal(arr, target);
        if(!result.isEmpty()){
            System.out.println("Triplets found: "+result);
        }else{
            System.out.println("No triplet found.");
        }

    }
}
