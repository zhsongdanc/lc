package twopointer;

/**
 * @author demussong
 * @describe
 * @date 2023/8/19 16:51
 */
public class S11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int water = Math.min(height[0], height[height.length - 1])*(height.length - 1);

        while (left < right) {
            water = Math.max(water, Math.min(leftMax, rightMax)*(right - left));
            if (height[left] <= height[right]) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
            }else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return water;
    }
}
