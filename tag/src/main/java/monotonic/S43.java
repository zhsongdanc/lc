package monotonic;

import java.util.Stack;

/**
 * @author demussong
 * @describe todo 重点修改
 * @date 2023/8/19 09:37
 */
public class S43 {
    // 最简单的思路1
    public int trap1(int[] height) {
        int[] leftMax = new int[height.length];
        int leftMaxVal = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMaxVal = Math.max(leftMaxVal, height[i - 1]);
            leftMax[i] = leftMaxVal;
        }

        int[] rightMax = new int[height.length];
        int rightMaxVal = height[height.length - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            rightMaxVal = Math.max(rightMaxVal, height[j + 1]);
            rightMax[j] = rightMaxVal;
        }

        int water = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int tmp = Math.min(leftMax[i], rightMax[i]);
            if (height[i] < tmp) {
                water+=(tmp - height[i]);
            }
        }

        return water;
    }

    // [0,1,0,2,1,0,1,3,2,1,2,1]
    public int trap(int[] height) {

        int water = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int peek = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int width = current - stack.peek() -1;
                int curHeight = Math.min(height[stack.peek()], height[current]) - height[peek];
                water+=(width*curHeight);
            }


            stack.push(current++);
        }

        return water;
    }





        public static void main(String[] args) {
        S43 s43 = new S43();
        int[] array = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        //                     0 0 1 1 2  2 2 2 3 3 3 3
        s43.trap(array);
    }
}
