package twopointer;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/8/20 10:27
 */
public class S34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }

        return new int[]{searchLeft(nums, target), searchRight(nums, target)};

    }


    // [0, 1] tar = 0, mid = 1
    public int searchLeft(int[] array, int target) {
        int l = 0;
        int r = array.length - 1;

        while (l < r) {
            int mid = (l + r) >>> 1;

            if (array[mid] < target) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }

        return array[l] == target ? l:-1;
    }


    public int searchRight(int[] array, int target) {
        int l = 0;
        int r = array.length - 1;

        while (l < r) {
            int mid = (l + r + 1) >>> 1;

            if (array[mid] > target) {
                r = mid - 1;
            }else {
                l = mid;
            }
        }

        return array[l] == target ? l:-1;
    }


    public static void main(String[] args) {
        S34 s34 = new S34();
        int[] array = new int[]{5,7,7,8,8,10};
        s34.searchRange(array, 8);
    }
}
