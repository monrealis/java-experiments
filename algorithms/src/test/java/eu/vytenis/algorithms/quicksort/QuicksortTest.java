package eu.vytenis.algorithms.quicksort;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class QuicksortTest {
    @Test
    public void run() {
        int[] a = {1, 2, 3, 5, 7, 8, 4, 3, 5};
        quicksort(a, 0, a.length - 1);
        System.out.print(Arrays.toString(a));
    }

    private void quicksort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int p = partition(a, lo, hi);
            quicksort(a, lo, p - 1);
            quicksort(a, p + 1, hi);
        }
    }

    private int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo;
        for (int j = lo; j < hi; ++j)
            if (a[j] < pivot) {
                swap(a, i, j);
                ++i;
            }
        swap(a, i, hi);
        return i;
    }

    private void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

}
