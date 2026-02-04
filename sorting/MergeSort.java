package sorting;

public class MergeSort implements Sorter {
    private long steps = 0;
    public void sort(int[] input) {
        resetSteps();
        mergeSort(input, input.length);
    }
    public void mergeSort(int[] list, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = list[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = list[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(list, l, r, mid, n - mid);
    }
    public void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
     
        while (i < left && j < right) {
            steps++; 
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
            steps++; 
        }
        while (j < right) {
            a[k++] = r[j++];
            steps++; 
        }
    }
    public long getSteps() {
        return steps;
    }
    public void resetSteps() {
        steps = 0;
    }
}