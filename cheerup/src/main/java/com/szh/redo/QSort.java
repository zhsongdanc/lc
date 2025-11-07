package com.szh.redo;

import java.util.Arrays;

public class Sort {


    public static void sort(int nums[], int left, int right) {
        if (left >= right) {
            return;
        }
        int par = partition(nums, left, right);
        sort(nums, left, par - 1);
        sort(nums, par + 1, right);
    }



    private static int partition(int nums[], int left, int right) {
        int pivot = nums[left];

        while (left < right) {

            while (left < right && nums[right] >= pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            swap(nums, left, right);
        }
        nums[left] = pivot;
        return left;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
