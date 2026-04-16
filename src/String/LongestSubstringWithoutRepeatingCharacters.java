package String;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    public int brute(String s){
        int n=s.length();
        int maxLen=0;
        for(int i=0;i<n;i++){
            int[] hash=new int[256];
            Arrays.fill(hash,0);
            for(int j=i;j<n;j++){
                if(hash[s.charAt(j)]==1) break;
                hash[s.charAt(j)]=1;
                maxLen=Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;
    }
    public int optimal(String s){
        int n=s.length();
        int maxLen=0;
        int[] hash=new int[256];
        Arrays.fill(hash,0);
        int left=0, right=0;
        while(right<n){
            if((hash[s.charAt(right)])==1){
                hash[s.charAt(left)]=0;
                left++;
            }
            else{
                hash[s.charAt(right)]=1;
                maxLen=Math.max(maxLen,right-left+1);
                right++;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj=new LongestSubstringWithoutRepeatingCharacters();
        String s="abcabcbb";
        System.out.println("Length of longest substring without repeating characters: "+obj.brute(s));
        System.out.println("Length of longest substring without repeating characters: "+obj.optimal(s));
    }
}
