package basic;

/**
 * @author demussong
 * @describe todo 几种方式的快排？
 * @date 2023/8/8 22:52
 */
public class QuickSort {
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array,int l, int r){
        if (l >= r) {
            return;
        }

        int partition = partition(array, l , r);
        quickSort(array, l, partition);
        quickSort(array, partition+ 1, r);
    }

    static int partition(int[] array, int l, int r) {
        int pivot = array[l];

        while (l < r) {
            while (l < r && array[r] >= pivot) {
                r--;
            }
            array[l] = array[r];
            while (l < r && array[l] <= pivot) {
                l++;
            }
            array[r] = array[l];
        }
        array[l] = pivot;


        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,213,43,18,13,97,53};
        quickSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
