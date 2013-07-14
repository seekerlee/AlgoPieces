package io.github.seekerlee.algopieces;

import java.util.Arrays;

/**
 * User: seeker
 * Date: 7/14/13
 * Time: 9:22 AM
 */
public class QuickSort {

    private final int[] arr;
    private long comparison_count = 0L;

    public QuickSort(int[] arr) {
        this.arr = arr;
        this.sort1(0, arr.length);
    }

    public void sort(final int startIndex, final int len) {
        if (len <= 1) {
            return;
        }
        //int nextScanIndex = startIndex + 1;
        int lessThanPLength = 0;
        // begin scan:
        for(int i = 1 + startIndex; i < len + startIndex; i++) {
            comparison_count ++;
            if (arr[i] < arr[startIndex]) {
                //swap
                int tmp = arr[i];
                arr[i] = arr[startIndex + lessThanPLength + 1];
                arr[startIndex + lessThanPLength + 1] = tmp;
                //increase
                lessThanPLength ++;
            }
        }
        //swap pivot to its place
        int tmp = arr[startIndex];
        arr[startIndex] = arr[startIndex + lessThanPLength];
        arr[startIndex + lessThanPLength] = tmp;
        //recursion
        sort(startIndex, lessThanPLength);
        sort(startIndex + lessThanPLength + 1, len - lessThanPLength - 1);
    }

    public void sort1(final int startIndex, final int len) {
        if (len <= 1) {
            return;
        }
        //swap first with last
        int tmp0 = arr[startIndex];
        arr[startIndex] = arr[startIndex + len - 1];
        arr[startIndex + len - 1] = tmp0;
        //int nextScanIndex = startIndex + 1;
        int lessThanPLength = 0;
        // begin scan:
        for(int i = 1 + startIndex; i < len + startIndex; i++) {
            comparison_count ++;
            if (arr[i] < arr[startIndex]) {
                //swap
                int tmp = arr[i];
                arr[i] = arr[startIndex + lessThanPLength + 1];
                arr[startIndex + lessThanPLength + 1] = tmp;
                //increase
                lessThanPLength ++;
            }
        }
        //swap pivot to its place
        int tmp = arr[startIndex];
        arr[startIndex] = arr[startIndex + lessThanPLength];
        arr[startIndex + lessThanPLength] = tmp;
        //recursion
        sort1(startIndex, lessThanPLength);
        sort1(startIndex + lessThanPLength + 1, len - lessThanPLength - 1);
    }

    public void sort2(final int startIndex, final int len) {
        if (len <= 1) {
            return;
        }
        int midI = startIndex + (len + 1)/2 - 1;
        int endI = startIndex + len - 1;
        if (len >= 3) {
            if ((arr[startIndex] <= arr[midI] && arr[midI] <= arr[endI])
             || (arr[startIndex] >= arr[midI] && arr[midI] >= arr[endI])) {
                int tmp = arr[midI];
                arr[midI] = arr[startIndex];
                arr[startIndex] = tmp;
            } else if ((arr[endI] <= arr[midI] && arr[startIndex] <= arr[endI])
                    || (arr[endI] >= arr[midI] && arr[startIndex] >= arr[endI])) {
                int tmp = arr[endI];
                arr[endI] = arr[startIndex];
                arr[startIndex] = tmp;
            }
        }
        //int nextScanIndex = startIndex + 1;
        int lessThanPLength = 0;
        // begin scan:
        for(int i = 1 + startIndex; i < len + startIndex; i++) {
            comparison_count ++;
            if (arr[i] < arr[startIndex]) {
                //swap
                int tmp = arr[i];
                arr[i] = arr[startIndex + lessThanPLength + 1];
                arr[startIndex + lessThanPLength + 1] = tmp;
                //increase
                lessThanPLength ++;
            }
        }
        //swap pivot to its place
        int tmp = arr[startIndex];
        arr[startIndex] = arr[startIndex + lessThanPLength];
        arr[startIndex + lessThanPLength] = tmp;
        //recursion
        sort2(startIndex, lessThanPLength);
        sort2(startIndex + lessThanPLength + 1, len - lessThanPLength - 1);
    }

    public int[] getArr() {
        return arr;
    }

    public long getComparison_count() {
        return comparison_count;
    }

    public static void main(String[] a) {
        QuickSort qs = new QuickSort(new int[]{3, 6, 1, 2, 9, 8, 3, 5, 7});
        System.out.println(Arrays.toString(qs.getArr()));
        System.out.println(qs.getComparison_count());
    }
}
