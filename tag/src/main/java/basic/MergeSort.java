package basic;

/**
 * @author demussong
 * @describe todo 好好反思一下
 * @date 2023/8/9 22:55
 */
public class MergeSort {
    public static void mergeSort(int nums[]) {

        int l = 0;
        int r = nums.length - 1;

        mergeSort(nums,l, r);
    }



    static void mergeSort(int nums[], int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = (l + r)>>>1;

        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1, r);
        mergeTwoArray(nums, l , mid, r);
    }



    public static void  mergeTwoArray(int[] nums, int l, int mid, int r) {

        int[] tmp = new int[r - l + 1];
        int k = 0;
        int m = l;
        int n = mid + 1;
        while (m <= mid && n <= r) {
            if (nums[m] <= nums[n]) {
                tmp[k++] = nums[m++];
            }else {
                tmp[k++] = nums[n++];
            }
        }

        while (m <= mid) {
            tmp[k++] = nums[m++];

        }

        while (n <= r) {
            tmp[k++] = nums[n++];

        }

        int  v = 0;
        for (int i = l; i <= r; i++) {
            nums[i] = tmp[v++];
        }

    }


    public static void main(String[] args) {
        int[] nums = new int[]{4,213,43,13,13,97,13};
        mergeSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
