package Arrays;

public class ContainerWithMostWater {
    //brute force approach
    public int maxAreaBrute(int[] height){
        int n=height.length;
        int maxArea=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int width=j-i;
                int minHeight=Math.min(height[i],height[j]);
                int area=width*minHeight;
                maxArea=Math.max(maxArea,area);
            }
        }
        return maxArea;
    }

    //optimal approach using two pointers
    public int maxArea(int[] height){
        int n=height.length;
        int left=0, right=n-1;
        int maxArea=0;
        while(left<right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater obj=new ContainerWithMostWater();
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println("Max area using brute force: "+obj.maxAreaBrute(height));
        System.out.println("Max area using optimal approach: "+obj.maxArea(height));
    }
}
